package com.company.attendance;

@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/company/attendance/AttendanceApplication;", "Landroid/app/Application;", "()V", "sessionManager", "Lcom/company/attendance/utils/SessionManager;", "getSessionManager", "()Lcom/company/attendance/utils/SessionManager;", "setSessionManager", "(Lcom/company/attendance/utils/SessionManager;)V", "wifiMonitoringService", "Lcom/company/attendance/service/WiFiMonitoringService;", "getWifiMonitoringService", "()Lcom/company/attendance/service/WiFiMonitoringService;", "setWifiMonitoringService", "(Lcom/company/attendance/service/WiFiMonitoringService;)V", "workManagerService", "Lcom/company/attendance/service/WorkManagerService;", "getWorkManagerService", "()Lcom/company/attendance/service/WorkManagerService;", "setWorkManagerService", "(Lcom/company/attendance/service/WorkManagerService;)V", "onCreate", "", "onTerminate", "app_release"})
public final class AttendanceApplication extends android.app.Application {
    @javax.inject.Inject()
    public com.company.attendance.utils.SessionManager sessionManager;
    @javax.inject.Inject()
    public com.company.attendance.service.WiFiMonitoringService wifiMonitoringService;
    @javax.inject.Inject()
    public com.company.attendance.service.WorkManagerService workManagerService;
    
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
}