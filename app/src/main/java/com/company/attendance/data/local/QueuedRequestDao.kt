package com.company.attendance.data.local

import androidx.room.*
import com.company.attendance.data.model.QueuedRequest
import kotlinx.coroutines.flow.Flow

@Dao
interface QueuedRequestDao {
    
    @Query("SELECT * FROM queued_requests ORDER BY timestamp ASC")
    fun getAllQueuedRequests(): Flow<List<QueuedRequest>>
    
    @Query("SELECT * FROM queued_requests WHERE retry_count < :maxRetries ORDER BY timestamp ASC")
    suspend fun getPendingRequests(maxRetries: Int = 3): List<QueuedRequest>
    
    @Query("SELECT * FROM queued_requests WHERE retry_count >= :maxRetries ORDER BY timestamp ASC")
    suspend fun getFailedRequests(maxRetries: Int = 3): List<QueuedRequest>
    
    @Query("SELECT * FROM queued_requests WHERE endpoint = :endpoint ORDER BY timestamp ASC")
    suspend fun getRequestsByType(endpoint: String): List<QueuedRequest>
    
    @Query("SELECT * FROM queued_requests WHERE endpoint IN ('in', 'out') ORDER BY timestamp ASC")
    suspend fun getCriticalRequests(): List<QueuedRequest>
    
    @Query("SELECT * FROM queued_requests WHERE id = :id")
    suspend fun getRequestById(id: Long): QueuedRequest?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRequest(request: QueuedRequest): Long
    
    @Update
    suspend fun updateRequest(request: QueuedRequest)
    
    @Delete
    suspend fun deleteRequest(request: QueuedRequest)
    
    @Query("DELETE FROM queued_requests WHERE id = :id")
    suspend fun deleteRequestById(id: Long)
    
    @Query("DELETE FROM queued_requests")
    suspend fun clearAllRequests()
    
    @Query("DELETE FROM queued_requests WHERE retry_count >= :maxRetries")
    suspend fun clearFailedRequests(maxRetries: Int = 3)
    
    @Query("SELECT COUNT(*) FROM queued_requests")
    suspend fun getQueuedRequestCount(): Int
    
    @Query("SELECT COUNT(*) FROM queued_requests WHERE retry_count < :maxRetries")
    suspend fun getPendingRequestCount(maxRetries: Int = 3): Int
    
    @Query("SELECT COUNT(*) FROM queued_requests WHERE retry_count >= :maxRetries")
    suspend fun getFailedRequestCount(maxRetries: Int = 3): Int
    
    @Query("SELECT COUNT(*) FROM queued_requests WHERE endpoint IN ('in', 'out')")
    suspend fun getCriticalRequestCount(): Int
}