package com.company.attendance.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/company/attendance/data/local/AttendanceDatabase;", "Landroidx/room/RoomDatabase;", "()V", "approvedWiFiDao", "Lcom/company/attendance/data/local/ApprovedWiFiDao;", "attendanceRecordDao", "Lcom/company/attendance/data/local/AttendanceRecordDao;", "queuedRequestDao", "Lcom/company/attendance/data/local/QueuedRequestDao;", "app_release"})
@androidx.room.Database(entities = {com.company.attendance.data.model.QueuedRequest.class, com.company.attendance.data.model.ApprovedWiFiNetwork.class, com.company.attendance.data.local.AttendanceRecordEntity.class}, version = 3, exportSchema = false)
@androidx.room.TypeConverters(value = {com.company.attendance.data.local.Converters.class})
public abstract class AttendanceDatabase extends androidx.room.RoomDatabase {
    
    public AttendanceDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.attendance.data.local.QueuedRequestDao queuedRequestDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.attendance.data.local.ApprovedWiFiDao approvedWiFiDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.company.attendance.data.local.AttendanceRecordDao attendanceRecordDao();
}