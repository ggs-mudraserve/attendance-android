package com.company.attendance.service

import com.company.attendance.data.local.QueuedRequestDao
import com.company.attendance.data.model.QueuedRequest
import com.company.attendance.data.remote.AttendanceApiService
import com.company.attendance.data.model.*
import com.company.attendance.utils.Constants
import com.company.attendance.utils.NetworkUtils
import com.google.gson.Gson
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.pow
import kotlin.random.Random

@Singleton
class RequestQueueManager @Inject constructor(
    private val queuedRequestDao: QueuedRequestDao,
    private val apiService: AttendanceApiService,
    private val supabaseClient: SupabaseClient,
    private val networkUtils: NetworkUtils,
    private val gson: Gson
) {
    
    private val _queueStatus = MutableStateFlow(QueueStatus())
    val queueStatus: StateFlow<QueueStatus> = _queueStatus.asStateFlow()
    
    /**
     * Get all queued requests as a flow
     */
    fun getQueuedRequests(): Flow<List<QueuedRequest>> {
        return queuedRequestDao.getAllQueuedRequests()
    }
    
    /**
     * Add a request to the queue
     */
    suspend fun queueRequest(
        endpoint: String,
        method: String,
        body: String?,
        eventId: String,
        priority: RequestPriority = RequestPriority.NORMAL
    ): Result<Long> {
        return try {
            val request = QueuedRequest(
                endpoint = endpoint,
                method = method,
                body = body,
                timestamp = System.currentTimeMillis(),
                eventId = eventId,
                retryCount = 0
            )
            
            val id = queuedRequestDao.insertRequest(request)
            updateQueueStatus()
            Result.success(id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Process all pending requests with exponential backoff
     */
    suspend fun processQueuedRequests(): Result<QueueProcessResult> {
        return try {
            if (!networkUtils.isNetworkAvailable()) {
                return Result.failure(Exception("No network connection available"))
            }
            
            val pendingRequests = queuedRequestDao.getPendingRequests(Constants.MAX_RETRY_ATTEMPTS)
            var successCount = 0
            var failureCount = 0
            val failedRequests = mutableListOf<QueuedRequest>()
            
            for (request in pendingRequests) {
                // Apply exponential backoff delay
                val backoffDelay = calculateBackoffDelay(request.retryCount)
                if (backoffDelay > 0) {
                    delay(backoffDelay)
                }
                
                val success = retryRequest(request)
                if (success) {
                    queuedRequestDao.deleteRequest(request)
                    successCount++
                } else {
                    val updatedRequest = request.copy(
                        retryCount = request.retryCount + 1,
                        timestamp = System.currentTimeMillis() // Update timestamp for next retry
                    )
                    queuedRequestDao.updateRequest(updatedRequest)
                    failureCount++
                    failedRequests.add(updatedRequest)
                }
            }
            
            updateQueueStatus()
            
            val result = QueueProcessResult(
                totalProcessed = successCount + failureCount,
                successCount = successCount,
                failureCount = failureCount,
                failedRequests = failedRequests
            )
            
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Retry a specific request manually
     */
    suspend fun retryRequestManually(requestId: Long): Result<Boolean> {
        return try {
            val request = queuedRequestDao.getRequestById(requestId)
                ?: return Result.failure(Exception("Request not found"))
            
            if (!networkUtils.isNetworkAvailable()) {
                return Result.failure(Exception("No network connection available"))
            }
            
            val success = retryRequest(request)
            if (success) {
                queuedRequestDao.deleteRequest(request)
            } else {
                val updatedRequest = request.copy(
                    retryCount = request.retryCount + 1,
                    timestamp = System.currentTimeMillis()
                )
                queuedRequestDao.updateRequest(updatedRequest)
            }
            
            updateQueueStatus()
            Result.success(success)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Retry all critical requests (IN/OUT) manually
     */
    suspend fun retryCriticalRequests(): Result<QueueProcessResult> {
        return try {
            if (!networkUtils.isNetworkAvailable()) {
                return Result.failure(Exception("No network connection available"))
            }
            
            val criticalRequests = queuedRequestDao.getCriticalRequests()
            var successCount = 0
            var failureCount = 0
            val failedRequests = mutableListOf<QueuedRequest>()
            
            for (request in criticalRequests) {
                val success = retryRequest(request)
                if (success) {
                    queuedRequestDao.deleteRequest(request)
                    successCount++
                } else {
                    val updatedRequest = request.copy(
                        retryCount = request.retryCount + 1,
                        timestamp = System.currentTimeMillis()
                    )
                    queuedRequestDao.updateRequest(updatedRequest)
                    failureCount++
                    failedRequests.add(updatedRequest)
                }
            }
            
            updateQueueStatus()
            
            val result = QueueProcessResult(
                totalProcessed = successCount + failureCount,
                successCount = successCount,
                failureCount = failureCount,
                failedRequests = failedRequests
            )
            
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Clear all failed requests that have exceeded max retries
     */
    suspend fun clearFailedRequests(): Result<Int> {
        return try {
            val failedCount = queuedRequestDao.getFailedRequestCount(Constants.MAX_RETRY_ATTEMPTS)
            queuedRequestDao.clearFailedRequests(Constants.MAX_RETRY_ATTEMPTS)
            updateQueueStatus()
            Result.success(failedCount)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Clear all queued requests
     */
    suspend fun clearAllRequests(): Result<Unit> {
        return try {
            queuedRequestDao.clearAllRequests()
            updateQueueStatus()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    /**
     * Calculate exponential backoff delay with jitter
     */
    private fun calculateBackoffDelay(retryCount: Int): Long {
        if (retryCount == 0) return 0L
        
        val baseDelay = 1000L // 1 second base delay
        val maxDelay = 60000L // 1 minute max delay
        
        // Exponential backoff: baseDelay * 2^retryCount
        val exponentialDelay = (baseDelay * 2.0.pow(retryCount.toDouble())).toLong()
        
        // Cap at max delay
        val cappedDelay = minOf(exponentialDelay, maxDelay)
        
        // Add jitter (random factor between 0.5 and 1.5)
        val jitter = Random.nextDouble(0.5, 1.5)
        
        return (cappedDelay * jitter).toLong()
    }
    
    /**
     * Retry a specific request
     */
    private suspend fun retryRequest(request: QueuedRequest): Boolean {
        return try {
            val token = supabaseClient.auth.currentAccessTokenOrNull() ?: return false
            
            when (request.endpoint) {
                "onboard" -> {
                    val onboardingRequest = gson.fromJson(request.body, OnboardingRequest::class.java)
                    val response = apiService.onboard("Bearer $token", request.eventId, onboardingRequest)
                    response.isSuccessful && response.body()?.success == true
                }
                "in" -> {
                    val response = apiService.markIn("Bearer $token", request.eventId)
                    response.isSuccessful && response.body()?.success == true
                }
                "out" -> {
                    val response = apiService.markOut("Bearer $token", request.eventId)
                    response.isSuccessful && response.body()?.success == true
                }
                "heartbeat" -> {
                    val heartbeatRequest = gson.fromJson(request.body, HeartbeatRequest::class.java)
                    val response = apiService.sendHeartbeat("Bearer $token", request.eventId, heartbeatRequest)
                    response.isSuccessful && response.body()?.success == true
                }
                else -> false
            }
        } catch (e: Exception) {
            false
        }
    }
    
    /**
     * Update queue status for monitoring
     */
    private suspend fun updateQueueStatus() {
        try {
            val totalCount = queuedRequestDao.getQueuedRequestCount()
            val pendingCount = queuedRequestDao.getPendingRequestCount(Constants.MAX_RETRY_ATTEMPTS)
            val failedCount = queuedRequestDao.getFailedRequestCount(Constants.MAX_RETRY_ATTEMPTS)
            val criticalCount = queuedRequestDao.getCriticalRequestCount()
            
            _queueStatus.value = QueueStatus(
                totalRequests = totalCount,
                pendingRequests = pendingCount,
                failedRequests = failedCount,
                criticalRequests = criticalCount,
                isProcessing = false,
                lastUpdated = System.currentTimeMillis()
            )
        } catch (e: Exception) {
            // Handle error silently to avoid disrupting queue operations
        }
    }
}

data class QueueStatus(
    val totalRequests: Int = 0,
    val pendingRequests: Int = 0,
    val failedRequests: Int = 0,
    val criticalRequests: Int = 0,
    val isProcessing: Boolean = false,
    val lastUpdated: Long = 0L
)

data class QueueProcessResult(
    val totalProcessed: Int,
    val successCount: Int,
    val failureCount: Int,
    val failedRequests: List<QueuedRequest>
)

enum class RequestPriority {
    LOW,      // Heartbeat requests
    NORMAL,   // General requests
    HIGH,     // Onboarding
    CRITICAL  // IN/OUT attendance requests
}