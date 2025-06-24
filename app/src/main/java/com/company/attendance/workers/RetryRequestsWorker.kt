package com.company.attendance.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.company.attendance.data.repository.AttendanceRepository
import com.company.attendance.utils.Constants
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@HiltWorker
class RetryRequestsWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val attendanceRepository: AttendanceRepository
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val result = attendanceRepository.processQueuedRequests()
            
            if (result.isSuccess) {
                val processedCount = result.getOrDefault(0)
                // Return success with data about processed requests
                val outputData = workDataOf("processed_count" to processedCount)
                Result.success(outputData)
            } else {
                // Retry later if processing failed
                Result.retry()
            }
        } catch (e: Exception) {
            // If there's an exception, retry the work
            Result.retry()
        }
    }

    companion object {
        const val WORK_NAME = "retry_requests_work"
        
        fun createOneTimeWorkRequest(): OneTimeWorkRequest {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(false)
                .build()

            return OneTimeWorkRequestBuilder<RetryRequestsWorker>()
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    WorkRequest.MIN_BACKOFF_MILLIS,
                    java.util.concurrent.TimeUnit.MILLISECONDS
                )
                .addTag(WORK_NAME)
                .build()
        }
        
        fun createPeriodicWorkRequest(): PeriodicWorkRequest {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(false)
                .build()

            return PeriodicWorkRequestBuilder<RetryRequestsWorker>(
                15, // Run every 15 minutes to process queued requests
                java.util.concurrent.TimeUnit.MINUTES
            )
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    WorkRequest.MIN_BACKOFF_MILLIS,
                    java.util.concurrent.TimeUnit.MILLISECONDS
                )
                .addTag(WORK_NAME)
                .build()
        }
    }
}