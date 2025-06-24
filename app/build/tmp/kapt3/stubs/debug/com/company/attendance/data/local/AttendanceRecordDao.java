package com.company.attendance.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0017J,\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001a0\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\'J,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0014J,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u001fJ&\u0010 \u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0014J&\u0010!\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0014J&\u0010\"\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0014J&\u0010#\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010$\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010%\u001a\u00020\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u001aH\u00a7@\u00a2\u0006\u0002\u0010\'J\u0016\u0010(\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006)"}, d2 = {"Lcom/company/attendance/data/local/AttendanceRecordDao;", "", "deleteAllRecordsForEmployee", "", "employeeId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAttendanceRecord", "record", "Lcom/company/attendance/data/local/AttendanceRecordEntity;", "(Lcom/company/attendance/data/local/AttendanceRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpiredRecords", "expiry", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAbsentDaysCount", "", "startDate", "Lkotlinx/datetime/LocalDate;", "endDate", "(Ljava/lang/String;Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceRecordForDate", "date", "(Ljava/lang/String;Lkotlinx/datetime/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceRecordsForPeriod", "Lkotlinx/coroutines/flow/Flow;", "", "getAttendanceRecordsForPeriodSync", "getAttendanceRecordsPaginated", "limit", "offset", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHalfDaysCount", "getHolidayDaysCount", "getLateDaysCount", "getPresentDaysCount", "insertAttendanceRecord", "insertAttendanceRecords", "records", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAttendanceRecord", "app_debug"})
@androidx.room.Dao()
public abstract interface AttendanceRecordDao {
    
    @androidx.room.Query(value = "SELECT * FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate ORDER BY attendance_date DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.company.attendance.data.local.AttendanceRecordEntity>> getAttendanceRecordsForPeriod(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate endDate);
    
    @androidx.room.Query(value = "SELECT * FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate ORDER BY attendance_date DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAttendanceRecordsForPeriodSync(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.attendance.data.local.AttendanceRecordEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM attendance_records WHERE employee_id = :employeeId AND attendance_date = :date")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAttendanceRecordForDate(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.local.AttendanceRecordEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM attendance_records WHERE employee_id = :employeeId ORDER BY attendance_date DESC LIMIT :limit OFFSET :offset")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAttendanceRecordsPaginated(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, int limit, int offset, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.attendance.data.local.AttendanceRecordEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAttendanceRecords(@org.jetbrains.annotations.NotNull()
    java.util.List<com.company.attendance.data.local.AttendanceRecordEntity> records, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAttendanceRecord(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.AttendanceRecordEntity record, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAttendanceRecord(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.AttendanceRecordEntity record, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAttendanceRecord(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.AttendanceRecordEntity record, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM attendance_records WHERE employee_id = :employeeId AND cached_at < :expiry")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteExpiredRecords(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, long expiry, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM attendance_records WHERE employee_id = :employeeId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllRecordsForEmployee(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = \'PRESENT\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPresentDaysCount(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = \'LATE\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLateDaysCount(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = \'HALF_DAY\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getHalfDaysCount(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = \'ABSENT\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAbsentDaysCount(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM attendance_records WHERE employee_id = :employeeId AND attendance_date BETWEEN :startDate AND :endDate AND status = \'HOLIDAY\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getHolidayDaysCount(@org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}