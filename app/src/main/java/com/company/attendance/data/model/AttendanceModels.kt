package com.company.attendance.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

@Parcelize
data class Profile(
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
) : Parcelable

@Parcelize
data class AttendanceRecord(
    val id: String,
    val employeeId: String,
    val attendanceDate: @RawValue LocalDate,
    val inTime: @RawValue LocalDateTime?,
    val outTime: @RawValue LocalDateTime?,
    val totalMinutes: Int,
    val status: AttendanceStatus
) : Parcelable

enum class AttendanceStatus {
    PRESENT, LATE, HALF_DAY, ABSENT, HOLIDAY
}

@Parcelize
data class AttendanceSession(
    val id: String,
    val employeeId: String,
    val sessionDate: @RawValue LocalDate,
    val inTime: @RawValue LocalDateTime,
    val lastHeartbeat: @RawValue LocalDateTime,
    val outTime: @RawValue LocalDateTime?,
    val missedCount: Int
) : Parcelable

data class OnboardingRequest(
    val deviceUuid: String,
    val bankAccountNo: String? = null,
    val bankIfsc: String? = null,
    val bankName: String? = null
)

data class HeartbeatRequest(
    val sessionId: String? = null
)

data class ApiResponse<T>(
    val success: Boolean,
    val data: T? = null,
    val message: String? = null,
    val error: String? = null
)

@Parcelize
@Entity(tableName = "queued_requests")
data class QueuedRequest(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val endpoint: String,
    val method: String,
    val body: String?,
    val timestamp: Long,
    @ColumnInfo(name = "retry_count")
    val retryCount: Int = 0,
    @ColumnInfo(name = "event_id")
    val eventId: String
) : Parcelable