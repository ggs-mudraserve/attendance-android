package com.company.attendance.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.company.attendance.data.repository.AttendanceRepository
import com.company.attendance.utils.Constants
import com.company.attendance.utils.PreferencesManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class HeartbeatWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val attendanceRepository: AttendanceRepository,
    private val preferencesManager: PreferencesManager,
    private val wifiMonitoringService: com.company.attendance.service.WiFiMonitoringService,
    private val notificationUtils: com.company.attendance.utils.NotificationUtils
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            // Check if user is logged in and has an active session
            if (!attendanceRepository.isUserLoggedIn()) {
                return@withContext Result.success()
            }

            val currentSession = attendanceRepository.getCurrentSession()
            if (currentSession == null || currentSession.outTime != null) {
                // No active session, nothing to do
                return@withContext Result.success()
            }

            // Check Wi-Fi validation before sending heartbeat
            val wifiStatus = wifiMonitoringService.wifiStatus.value
            if (!wifiStatus.isApproved) {
                // Not on approved Wi-Fi, show notification and skip this heartbeat
                notificationUtils.showHeartbeatErrorNotification(
                    "Not on approved Wi-Fi network", 
                    "Please connect to office Wi-Fi"
                )
                return@withContext Result.success()
            }

            // Send heartbeat
            val result = attendanceRepository.sendHeartbeat(currentSession.id)
            
            if (result.isSuccess) {
                // Update last heartbeat timestamp
                preferencesManager.lastHeartbeat = System.currentTimeMillis()
                
                // Show success notification
                notificationUtils.showHeartbeatSuccessNotification(
                    "Attendance Active", 
                    "Heartbeat sent successfully"
                )
                
                Result.success()
            } else {
                // Heartbeat failed, show error notification
                val errorMessage = result.exceptionOrNull()?.message ?: "Network error"
                notificationUtils.showHeartbeatErrorNotification(
                    "Heartbeat Failed", 
                    errorMessage
                )
                
                // The request will be queued for retry when network is available
                Result.success()
            }
        } catch (e: Exception) {
            // Show error notification
            notificationUtils.showHeartbeatErrorNotification(
                "Heartbeat Error", 
                e.message ?: "Unknown error occurred"
            )
            
            // Log error and return success to avoid stopping future heartbeats
            Result.success()
        }
    }

    companion object {
        const val WORK_NAME = "heartbeat_work"
        
        fun createPeriodicWorkRequest(): PeriodicWorkRequest {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(false)
                .build()

            return PeriodicWorkRequestBuilder<HeartbeatWorker>(
                Constants.HEARTBEAT_INTERVAL_MINUTES,
                java.util.concurrent.TimeUnit.MINUTES,
                // Flex interval of 5 minutes
                5,
                java.util.concurrent.TimeUnit.MINUTES
            )
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.EXPONENTIAL,
                    WorkRequest.MIN_BACKOFF_MILLIS,
                    java.util.concurrent.TimeUnit.MILLISECONDS
                )
                .addTag(WORK_NAME)
                .build()
        }
        
        fun createOneTimeWorkRequest(): OneTimeWorkRequest {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            return OneTimeWorkRequestBuilder<HeartbeatWorker>()
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.EXPONENTIAL,
                    WorkRequest.MIN_BACKOFF_MILLIS,
                    java.util.concurrent.TimeUnit.MILLISECONDS
                )
                .addTag(WORK_NAME)
                .build()
        }
    }
}