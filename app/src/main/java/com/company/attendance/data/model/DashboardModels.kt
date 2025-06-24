package com.company.attendance.data.model

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

data class AttendanceSessionState(
    val isActive: Boolean = false,
    val sessionId: String? = null,
    val inTime: LocalDateTime? = null,
    val lastHeartbeat: LocalDateTime? = null,
    val currentDuration: String = "0h 0m",
    val status: SessionStatus = SessionStatus.NOT_STARTED
)

enum class SessionStatus {
    NOT_STARTED,
    ACTIVE,
    COMPLETED,
    MISSED_HEARTBEAT
}

data class DailyAttendanceSummary(
    val date: kotlinx.datetime.LocalDate,
    val totalMinutes: Int = 0,
    val status: AttendanceStatus = AttendanceStatus.ABSENT,
    val inTime: LocalTime? = null,
    val outTime: LocalTime? = null,
    val breakDuration: Int = 0
)

sealed class AttendanceAction {
    object MarkIn : AttendanceAction()
    object MarkOut : AttendanceAction()
    object SendHeartbeat : AttendanceAction()
}

sealed class AttendanceResult {
    data class Success(val message: String) : AttendanceResult()
    data class Error(val message: String, val canRetry: Boolean = true) : AttendanceResult()
    object Loading : AttendanceResult()
    object NetworkError : AttendanceResult()
    object WiFiNotApproved : AttendanceResult()
    object DeviceNotRegistered : AttendanceResult()
}

data class AttendanceButtonState(
    val isEnabled: Boolean,
    val text: String,
    val action: AttendanceAction,
    val color: androidx.compose.ui.graphics.Color? = null,
    val loadingText: String = "Processing..."
)