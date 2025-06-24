package com.company.attendance.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.company.attendance.data.model.AttendanceStatus
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "attendance_records")
data class AttendanceRecordEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "employee_id")
    val employeeId: String,
    @ColumnInfo(name = "attendance_date")
    val attendanceDate: LocalDate,
    @ColumnInfo(name = "in_time")
    val inTime: LocalDateTime?,
    @ColumnInfo(name = "out_time") 
    val outTime: LocalDateTime?,
    @ColumnInfo(name = "total_minutes")
    val totalMinutes: Int,
    @ColumnInfo(name = "status")
    val status: AttendanceStatus,
    @ColumnInfo(name = "cached_at")
    val cachedAt: Long = System.currentTimeMillis()
)