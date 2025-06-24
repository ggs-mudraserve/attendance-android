package com.company.attendance;

@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/company/attendance/AttendanceApplication;", "Landroid/app/Application;", "()V", "isInitialized", "", "sessionManager", "Lcom/company/attendance/utils/SessionManager;", "getSessionManager", "()Lcom/company/attendance/utils/SessionManager;", "setSessionManager", "(Lcom/company/attendance/utils/SessionManager;)V", "wifiMonitoringService", "Lcom/company/attendance/service/WiFiMonitoringService;", "getWifiMonitoringService", "()Lcom/company/attendance/service/WiFiMonitoringService;", "setWifiMonitoringService", "(Lcom/company/attendance/service/WiFiMonitoringService;)V", "workManagerService", "Lcom/company/attendance/service/WorkManagerService;", "getWorkManagerService", "()Lcom/company/attendance/service/WorkManagerService;", "setWorkManagerService", "(Lcom/company/attendance/service/WorkManagerService;)V", "onCreate", "", "onTerminate", "Companion", "app_debug"})
public final class AttendanceApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AttendanceApplication";
    @javax.inject.Inject()
    public com.company.attendance.utils.SessionManager sessionManager;
    @javax.inject.Inject()
    public com.company.attendance.service.WiFiMonitoringService wifiMonitoringService;
    @javax.inject.Inject()
    public com.company.attendance.service.WorkManagerService workManagerService;
    private boolean isInitialized = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.AttendanceApplication.Companion Companion = null;
    
    public AttendanceApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.utils.SessionManager getSessionManager() {
        return null;
    }
    
    public final void setSessionManager(@org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.SessionManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.service.WiFiMonitoringService getWifiMonitoringService() {
        return null;
    }
    
    public final void setWifiMonitoringService(@org.jetbrains.annotations.NotNull()
    com.company.attendance.service.WiFiMonitoringService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.service.WorkManagerService getWorkManagerService() {
        return null;
    }
    
    public final void setWorkManagerService(@org.jetbrains.annotations.NotNull()
    com.company.attendance.service.WorkManagerService p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onTerminate() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/company/attendance/AttendanceApplication$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}