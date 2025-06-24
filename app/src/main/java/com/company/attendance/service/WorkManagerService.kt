package com.company.attendance.service

import android.content.Context
import androidx.work.*
import com.company.attendance.workers.HeartbeatWorker
import com.company.attendance.workers.RetryRequestsWorker
import com.company.attendance.utils.NotificationUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorkManagerService @Inject constructor(
    @ApplicationContext private val context: Context,
    private val notificationUtils: NotificationUtils
) {
    
    private val workManager = WorkManager.getInstance(context)
    
    /**
     * Start periodic heartbeat for active session
     */
    fun startHeartbeatWork() {
        val heartbeatWork = HeartbeatWorker.createPeriodicWorkRequest()
        
        workManager.enqueueUniquePeriodicWork(
            HeartbeatWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP, // Keep existing work if already running
            heartbeatWork
        )
    }
    
    /**
     * Stop heartbeat work when session ends
     */
    fun stopHeartbeatWork() {
        workManager.cancelUniqueWork(HeartbeatWorker.WORK_NAME)
        // Dismiss heartbeat status notifications
        notificationUtils.dismissHeartbeatNotifications()
    }
    
    /**
     * Send immediate heartbeat
     */
    fun sendImmediateHeartbeat() {
        val immediateHeartbeat = HeartbeatWorker.createOneTimeWorkRequest()
        workManager.enqueue(immediateHeartbeat)
    }
    
    /**
     * Start periodic retry of queued requests
     */
    fun startRetryWork() {
        val retryWork = RetryRequestsWorker.createPeriodicWorkRequest()
        
        workManager.enqueueUniquePeriodicWork(
            RetryRequestsWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            retryWork
        )
    }
    
    /**
     * Stop periodic retry work
     */
    fun stopRetryWork() {
        workManager.cancelUniqueWork(RetryRequestsWorker.WORK_NAME)
    }
    
    /**
     * Retry queued requests immediately
     */
    fun retryQueuedRequestsNow() {
        val immediateRetry = RetryRequestsWorker.createOneTimeWorkRequest()
        workManager.enqueue(immediateRetry)
    }
    
    /**
     * Get work info for heartbeat work
     */
    fun getHeartbeatWorkInfo() = workManager.getWorkInfosForUniqueWorkLiveData(HeartbeatWorker.WORK_NAME)
    
    /**
     * Get work info for retry work
     */
    fun getRetryWorkInfo() = workManager.getWorkInfosForUniqueWorkLiveData(RetryRequestsWorker.WORK_NAME)
    
    /**
     * Cancel all background work
     */
    fun cancelAllWork() {
        stopHeartbeatWork()
        stopRetryWork()
    }
    
    /**
     * Initialize background work on app startup
     */
    fun initializeBackgroundWork() {
        // Start retry work immediately for any pending requests
        startRetryWork()
        
        // Heartbeat work will be started when user marks IN
    }
}