package com.company.attendance.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.company.attendance.data.model.QueuedRequest
import com.company.attendance.data.model.ApprovedWiFiNetwork

@Database(
    entities = [QueuedRequest::class, ApprovedWiFiNetwork::class, AttendanceRecordEntity::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AttendanceDatabase : RoomDatabase() {
    abstract fun queuedRequestDao(): QueuedRequestDao
    abstract fun approvedWiFiDao(): ApprovedWiFiDao
    abstract fun attendanceRecordDao(): AttendanceRecordDao
}