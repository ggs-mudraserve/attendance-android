package com.company.attendance.data.repository

import com.company.attendance.data.model.*
import kotlinx.coroutines.flow.Flow

interface AttendanceRepository {
    
    // Authentication
    suspend fun signIn(email: String, password: String): Result<String>
    suspend fun signOut(): Result<Unit>
    suspend fun getCurrentUser(): String?
    suspend fun isUserLoggedIn(): Boolean
    
    // Profile & Onboarding
    suspend fun getUserProfile(): Result<Profile>
    suspend fun onboardDevice(bankDetails: BankDetails?): Result<String>
    suspend fun isDeviceOnboarded(): Boolean
    
    // Attendance
    suspend fun markIn(): Result<AttendanceSession>
    suspend fun markOut(): Result<AttendanceSession>
    suspend fun sendHeartbeat(sessionId: String?): Result<String>
    suspend fun getMonthlyAttendance(year: Int, month: Int): Result<List<AttendanceRecord>>
    suspend fun getAttendanceForDateRange(startDate: kotlinx.datetime.LocalDate, endDate: kotlinx.datetime.LocalDate): Result<List<AttendanceRecord>>
    suspend fun getAttendanceSummary(year: Int, month: Int): Result<AttendanceSummary>
    suspend fun getCurrentSession(): AttendanceSession?
    
    // Wi-Fi Validation
    suspend fun isOnApprovedWiFi(): Boolean
    fun getWiFiInfo(): com.company.attendance.utils.WiFiInfo
    suspend fun getApprovedWiFiNetworks(): Result<List<ApprovedWiFiNetwork>>
    
    // Offline Queue
    fun getQueuedRequests(): Flow<List<QueuedRequest>>
    suspend fun processQueuedRequests(): Result<Int>
    suspend fun retryRequestManually(requestId: Long): Result<Boolean>
    suspend fun retryCriticalRequests(): Result<Int>
    suspend fun clearQueue()
    suspend fun clearFailedRequests(): Result<Int>
    fun getQueueStatus(): kotlinx.coroutines.flow.StateFlow<com.company.attendance.service.QueueStatus>
    
    // Health Check
    suspend fun healthCheck(): Result<String>
}

data class BankDetails(
    val accountNumber: String,
    val ifscCode: String,
    val bankName: String
)

data class AttendanceSummary(
    val totalDays: Int,
    val presentDays: Int,
    val lateDays: Int,
    val halfDays: Int,
    val absentDays: Int,
    val holidayDays: Int,
    val workingDays: Int,
    val attendancePercentage: Float
)