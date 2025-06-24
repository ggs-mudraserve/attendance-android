package com.company.attendance.data.repository

import com.company.attendance.data.local.QueuedRequestDao
import com.company.attendance.data.model.*
import com.company.attendance.data.remote.AttendanceApiService
import com.company.attendance.utils.*
import com.google.gson.Gson
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AttendanceRepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient,
    private val apiService: AttendanceApiService,
    private val queuedRequestDao: QueuedRequestDao,
    private val preferencesManager: PreferencesManager,
    private val deviceUtils: DeviceUtils,
    private val wifiValidator: WiFiValidator,
    private val wifiMonitoringService: com.company.attendance.service.WiFiMonitoringService,
    private val requestQueueManager: com.company.attendance.service.RequestQueueManager,
    private val attendanceRecordDao: com.company.attendance.data.local.AttendanceRecordDao
) : AttendanceRepository {
    
    private val gson = Gson()
    private var approvedBSSIDs: Set<String> = emptySet()
    private var currentSession: AttendanceSession? = null
    
    override suspend fun signIn(email: String, password: String): Result<String> {
        return try {
            // This method is deprecated - use AuthRepository instead
            Result.failure(Exception("Use AuthRepository for authentication"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun signOut(): Result<Unit> {
        return try {
            // This method is deprecated - use AuthRepository instead
            preferencesManager.clear()
            clearQueue()
            currentSession = null
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getCurrentUser(): String? {
        return supabaseClient.auth.currentUserOrNull()?.id
    }
    
    override suspend fun isUserLoggedIn(): Boolean {
        return supabaseClient.auth.currentUserOrNull() != null
    }
    
    override suspend fun getUserProfile(): Result<Profile> {
        return try {
            val user = supabaseClient.auth.currentUserOrNull()
                ?: return Result.failure(Exception("User not logged in"))
            
            val response = supabaseClient.postgrest["profile"]
                .select {
                    filter {
                        eq("id", user.id)
                    }
                }
                .decodeSingle<ProfileResponse>()
            
            val profile = Profile(
                id = response.id,
                email = response.email,
                firstName = response.firstName,
                lastName = response.lastName,
                empCode = response.empCode,
                isActive = response.isActive,
                deviceId = response.deviceId,
                androidLogin = response.androidLogin,
                bankAccountNo = response.bankAccountNo,
                bankIfsc = response.bankIfsc,
                bankName = response.bankName
            )
            
            Result.success(profile)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun onboardDevice(bankDetails: BankDetails?): Result<String> {
        return try {
            val deviceUuid = preferencesManager.deviceUuid 
                ?: deviceUtils.generateDeviceUuid().also { 
                    preferencesManager.deviceUuid = it 
                }
            
            val token = supabaseClient.auth.currentAccessTokenOrNull()
                ?: return Result.failure(Exception("No access token"))
            
            val timestamp = System.currentTimeMillis()
            val eventId = CryptoUtils.generateEventId(deviceUuid, timestamp)
            
            val request = OnboardingRequest(
                deviceUuid = deviceUuid,
                bankAccountNo = bankDetails?.accountNumber,
                bankIfsc = bankDetails?.ifscCode,
                bankName = bankDetails?.bankName
            )
            
            val response = apiService.onboard(
                authorization = "Bearer $token",
                eventId = eventId,
                request = request
            )
            
            if (response.isSuccessful && response.body()?.success == true) {
                preferencesManager.isOnboarded = true
                Result.success(response.body()?.data ?: "Device onboarded successfully")
            } else {
                queueRequest("onboard", "POST", gson.toJson(request), eventId)
                Result.failure(Exception(response.body()?.error ?: "Onboarding failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun isDeviceOnboarded(): Boolean {
        return preferencesManager.isOnboarded
    }
    
    override suspend fun markIn(): Result<AttendanceSession> {
        return try {
            if (!isOnApprovedWiFi()) {
                return Result.failure(Exception("Not connected to approved Wi-Fi network"))
            }
            
            val deviceUuid = preferencesManager.deviceUuid
                ?: return Result.failure(Exception("Device not registered"))
            
            val token = supabaseClient.auth.currentAccessTokenOrNull()
                ?: return Result.failure(Exception("No access token"))
            
            val timestamp = System.currentTimeMillis()
            val eventId = CryptoUtils.generateEventId(deviceUuid, timestamp)
            
            val response = apiService.markIn(
                authorization = "Bearer $token",
                eventId = eventId
            )
            
            if (response.isSuccessful && response.body()?.success == true) {
                currentSession = response.body()?.data
                Result.success(response.body()?.data!!)
            } else {
                queueRequest("in", "POST", null, eventId)
                Result.failure(Exception(response.body()?.error ?: "Mark in failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun markOut(): Result<AttendanceSession> {
        return try {
            if (!isOnApprovedWiFi()) {
                return Result.failure(Exception("Not connected to approved Wi-Fi network"))
            }
            
            val deviceUuid = preferencesManager.deviceUuid
                ?: return Result.failure(Exception("Device not registered"))
            
            val token = supabaseClient.auth.currentAccessTokenOrNull()
                ?: return Result.failure(Exception("No access token"))
            
            val timestamp = System.currentTimeMillis()
            val eventId = CryptoUtils.generateEventId(deviceUuid, timestamp)
            
            val response = apiService.markOut(
                authorization = "Bearer $token",
                eventId = eventId
            )
            
            if (response.isSuccessful && response.body()?.success == true) {
                currentSession = response.body()?.data
                Result.success(response.body()?.data!!)
            } else {
                queueRequest("out", "POST", null, eventId)
                Result.failure(Exception(response.body()?.error ?: "Mark out failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun sendHeartbeat(sessionId: String?): Result<String> {
        return try {
            val deviceUuid = preferencesManager.deviceUuid
                ?: return Result.failure(Exception("Device not registered"))
            
            val token = supabaseClient.auth.currentAccessTokenOrNull()
                ?: return Result.failure(Exception("No access token"))
            
            val timestamp = System.currentTimeMillis()
            val eventId = CryptoUtils.generateEventId(deviceUuid, timestamp)
            
            val request = HeartbeatRequest(sessionId = sessionId)
            
            val response = apiService.sendHeartbeat(
                authorization = "Bearer $token",
                eventId = eventId,
                request = request
            )
            
            if (response.isSuccessful && response.body()?.success == true) {
                preferencesManager.lastHeartbeat = timestamp
                Result.success(response.body()?.data ?: "Heartbeat sent")
            } else {
                queueRequest("heartbeat", "POST", gson.toJson(request), eventId)
                Result.failure(Exception(response.body()?.error ?: "Heartbeat failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getMonthlyAttendance(year: Int, month: Int): Result<List<AttendanceRecord>> {
        return try {
            val userId = supabaseClient.auth.currentUserOrNull()?.id
                ?: return Result.failure(Exception("User not logged in"))
            
            // Calculate date range for the month
            val startDate = kotlinx.datetime.LocalDate(year, month, 1)
            val daysInMonth = when (month) {
                2 -> if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
                4, 6, 9, 11 -> 30
                else -> 31
            }
            val endDate = kotlinx.datetime.LocalDate(year, month, daysInMonth)
            
            // Try to fetch from server
            val token = supabaseClient.auth.currentAccessTokenOrNull()
            if (token != null) {
                val response = apiService.getMonthlyAttendance(
                    authorization = "Bearer $token",
                    year = year,
                    month = month
                )
                
                if (response.isSuccessful && response.body()?.success == true) {
                    val serverData = response.body()?.data ?: emptyList()
                    
                    // Cache the server data
                    cacheAttendanceRecords(userId, serverData)
                    
                    return Result.success(serverData)
                }
            }
            
            // Fallback to cached data
            val cachedData = attendanceRecordDao.getAttendanceRecordsForPeriodSync(userId, startDate, endDate)
            val attendanceRecords = cachedData.map { entity ->
                AttendanceRecord(
                    id = entity.id,
                    employeeId = entity.employeeId,
                    attendanceDate = entity.attendanceDate,
                    inTime = entity.inTime,
                    outTime = entity.outTime,
                    totalMinutes = entity.totalMinutes,
                    status = entity.status
                )
            }
            
            Result.success(attendanceRecords)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getAttendanceForDateRange(
        startDate: kotlinx.datetime.LocalDate,
        endDate: kotlinx.datetime.LocalDate
    ): Result<List<AttendanceRecord>> {
        return try {
            val userId = supabaseClient.auth.currentUserOrNull()?.id
                ?: return Result.failure(Exception("User not logged in"))
            
            // Get cached data
            val cachedData = attendanceRecordDao.getAttendanceRecordsForPeriodSync(userId, startDate, endDate)
            val attendanceRecords = cachedData.map { entity ->
                AttendanceRecord(
                    id = entity.id,
                    employeeId = entity.employeeId,
                    attendanceDate = entity.attendanceDate,
                    inTime = entity.inTime,
                    outTime = entity.outTime,
                    totalMinutes = entity.totalMinutes,
                    status = entity.status
                )
            }
            
            Result.success(attendanceRecords)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getAttendanceSummary(year: Int, month: Int): Result<AttendanceSummary> {
        return try {
            val userId = supabaseClient.auth.currentUserOrNull()?.id
                ?: return Result.failure(Exception("User not logged in"))
            
            val startDate = kotlinx.datetime.LocalDate(year, month, 1)
            val daysInMonth = when (month) {
                2 -> if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
                4, 6, 9, 11 -> 30
                else -> 31
            }
            val endDate = kotlinx.datetime.LocalDate(year, month, daysInMonth)
            
            val presentDays = attendanceRecordDao.getPresentDaysCount(userId, startDate, endDate)
            val lateDays = attendanceRecordDao.getLateDaysCount(userId, startDate, endDate)
            val halfDays = attendanceRecordDao.getHalfDaysCount(userId, startDate, endDate)
            val absentDays = attendanceRecordDao.getAbsentDaysCount(userId, startDate, endDate)
            val holidayDays = attendanceRecordDao.getHolidayDaysCount(userId, startDate, endDate)
            
            val workingDays = daysInMonth - holidayDays
            val attendancePercentage = if (workingDays > 0) {
                ((presentDays + lateDays + halfDays).toFloat() / workingDays.toFloat()) * 100f
            } else {
                0f
            }
            
            val summary = AttendanceSummary(
                totalDays = daysInMonth,
                presentDays = presentDays,
                lateDays = lateDays,
                halfDays = halfDays,
                absentDays = absentDays,
                holidayDays = holidayDays,
                workingDays = workingDays,
                attendancePercentage = attendancePercentage
            )
            
            Result.success(summary)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private suspend fun cacheAttendanceRecords(userId: String, records: List<AttendanceRecord>) {
        val entities = records.map { record ->
            com.company.attendance.data.local.AttendanceRecordEntity(
                id = record.id,
                employeeId = record.employeeId,
                attendanceDate = record.attendanceDate,
                inTime = record.inTime,
                outTime = record.outTime,
                totalMinutes = record.totalMinutes,
                status = record.status,
                cachedAt = System.currentTimeMillis()
            )
        }
        attendanceRecordDao.insertAttendanceRecords(entities)
        
        // Clean up old cached records (older than 30 days)
        val thirtyDaysAgo = System.currentTimeMillis() - (30L * 24L * 60L * 60L * 1000L)
        attendanceRecordDao.deleteExpiredRecords(userId, thirtyDaysAgo)
    }
    
    override suspend fun getCurrentSession(): AttendanceSession? = currentSession
    
    override suspend fun isOnApprovedWiFi(): Boolean {
        return wifiMonitoringService.wifiStatus.value.isApproved
    }
    
    override fun getWiFiInfo(): com.company.attendance.utils.WiFiInfo {
        return wifiValidator.getWiFiInfo()
    }
    
    override suspend fun getApprovedWiFiNetworks(): Result<List<ApprovedWiFiNetwork>> {
        return try {
            val token = supabaseClient.auth.currentAccessTokenOrNull()
                ?: return Result.failure(Exception("No access token"))
            
            // TODO: Implement API call to fetch wifi_allowed table from server
            // For now, return empty list - will be implemented with Office Server
            Result.success(emptyList())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override fun getQueuedRequests(): Flow<List<QueuedRequest>> {
        return requestQueueManager.getQueuedRequests()
    }
    
    override suspend fun processQueuedRequests(): Result<Int> {
        return requestQueueManager.processQueuedRequests()
            .mapCatching { it.successCount }
    }
    
    override suspend fun retryRequestManually(requestId: Long): Result<Boolean> {
        return requestQueueManager.retryRequestManually(requestId)
    }
    
    override suspend fun retryCriticalRequests(): Result<Int> {
        return requestQueueManager.retryCriticalRequests()
            .mapCatching { it.successCount }
    }
    
    override suspend fun clearQueue() {
        requestQueueManager.clearAllRequests()
    }
    
    override suspend fun clearFailedRequests(): Result<Int> {
        return requestQueueManager.clearFailedRequests()
    }
    
    override fun getQueueStatus(): kotlinx.coroutines.flow.StateFlow<com.company.attendance.service.QueueStatus> {
        return requestQueueManager.queueStatus
    }
    
    override suspend fun healthCheck(): Result<String> {
        return try {
            val response = apiService.healthCheck()
            if (response.isSuccessful) {
                Result.success(response.body()?.data ?: "Server is healthy")
            } else {
                Result.failure(Exception("Health check failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private suspend fun queueRequest(endpoint: String, method: String, body: String?, eventId: String) {
        val priority = when (endpoint) {
            "in", "out" -> com.company.attendance.service.RequestPriority.CRITICAL
            "onboard" -> com.company.attendance.service.RequestPriority.HIGH
            "heartbeat" -> com.company.attendance.service.RequestPriority.LOW
            else -> com.company.attendance.service.RequestPriority.NORMAL
        }
        
        requestQueueManager.queueRequest(endpoint, method, body, eventId, priority)
    }
    
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
}

// Data classes for Supabase responses
private data class ProfileResponse(
    val id: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val empCode: String,
    val isActive: Boolean,
    val deviceId: String?,
    val androidLogin: Boolean,
    val bankAccountNo: String?,
    val bankIfsc: String?,
    val bankName: String?
)