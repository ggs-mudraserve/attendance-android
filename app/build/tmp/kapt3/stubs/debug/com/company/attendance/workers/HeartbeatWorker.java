package com.company.attendance.workers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B;\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/company/attendance/workers/HeartbeatWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "attendanceRepository", "Lcom/company/attendance/data/repository/AttendanceRepository;", "preferencesManager", "Lcom/company/attendance/utils/PreferencesManager;", "wifiMonitoringService", "Lcom/company/attendance/service/WiFiMonitoringService;", "notificationUtils", "Lcom/company/attendance/utils/NotificationUtils;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/company/attendance/data/repository/AttendanceRepository;Lcom/company/attendance/utils/PreferencesManager;Lcom/company/attendance/service/WiFiMonitoringService;Lcom/company/attendance/utils/NotificationUtils;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
@androidx.hilt.work.HiltWorker()
public final class HeartbeatWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AttendanceRepository attendanceRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.PreferencesManager preferencesManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.service.WiFiMonitoringService wifiMonitoringService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.NotificationUtils notificationUtils = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_NAME = "heartbeat_work";
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.workers.HeartbeatWorker.Companion Companion = null;
    
    @dagger.assisted.AssistedInject()
    public HeartbeatWorker(@dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AttendanceRepository attendanceRepository, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.PreferencesManager preferencesManager, @org.jetbrains.annotations.NotNull()
    com.company.attendance.service.WiFiMonitoringService wifiMonitoringService, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.NotificationUtils notificationUtils) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/company/attendance/workers/HeartbeatWorker$Companion;", "", "()V", "WORK_NAME", "", "createOneTimeWorkRequest", "Landroidx/work/OneTimeWorkRequest;", "createPeriodicWorkRequest", "Landroidx/work/PeriodicWorkRequest;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.work.PeriodicWorkRequest createPeriodicWorkRequest() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.work.OneTimeWorkRequest createOneTimeWorkRequest() {
            return null;
        }
    }
}