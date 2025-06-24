package com.company.attendance.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

@Dao
interface AttendanceRecordDao {
    
    @Query("SELECT * FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate ORDER BY attendance_date DESC")
    fun getAttendanceRecordsForPeriod(
        employeeId: String,
        startDate: LocalDate,
        endDate: LocalDate
    ): Flow<List<AttendanceRecordEntity>>
    
    @Query("SELECT * FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate ORDER BY attendance_date DESC")
    suspend fun getAttendanceRecordsForPeriodSync(
        employeeId: String,
        startDate: LocalDate,
        endDate: LocalDate
    ): List<AttendanceRecordEntity>
    
    @Query("SELECT * FROM attendance_records WHERE employee_id = :employeeId AND attendance_date = :date")
    suspend fun getAttendanceRecordForDate(employeeId: String, date: LocalDate): AttendanceRecordEntity?
    
    @Query("SELECT * FROM attendance_records WHERE employee_id = :employeeId ORDER BY attendance_date DESC LIMIT :limit OFFSET :offset")
    suspend fun getAttendanceRecordsPaginated(
        employeeId: String,
        limit: Int,
        offset: Int
    ): List<AttendanceRecordEntity>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendanceRecords(records: List<AttendanceRecordEntity>)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendanceRecord(record: AttendanceRecordEntity)
    
    @Update
    suspend fun updateAttendanceRecord(record: AttendanceRecordEntity)
    
    @Delete
    suspend fun deleteAttendanceRecord(record: AttendanceRecordEntity)
    
    @Query("DELETE FROM attendance_records WHERE employee_id = :employeeId AND cached_at < :expiry")
    suspend fun deleteExpiredRecords(employeeId: String, expiry: Long)
    
    @Query("DELETE FROM attendance_records WHERE employee_id = :employeeId")
    suspend fun deleteAllRecordsForEmployee(employeeId: String)
    
    @Query("SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = 'PRESENT'")
    suspend fun getPresentDaysCount(employeeId: String, startDate: LocalDate, endDate: LocalDate): Int
    
    @Query("SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = 'LATE'")
    suspend fun getLateDaysCount(employeeId: String, startDate: LocalDate, endDate: LocalDate): Int
    
    @Query("SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = 'HALF_DAY'")
    suspend fun getHalfDaysCount(employeeId: String, startDate: LocalDate, endDate: LocalDate): Int
    
    @Query("SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = 'ABSENT'")
    suspend fun getAbsentDaysCount(employeeId: String, startDate: LocalDate, endDate: LocalDate): Int
    
    @Query("SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = 'HOLIDAY'")
    suspend fun getHolidayDaysCount(employeeId: String, startDate: LocalDate, endDate: LocalDate): Int
}