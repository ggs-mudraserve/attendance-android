package com.company.attendance.service;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ0\u0010\u000b\u001a,\u0012(\u0012&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00100\r0\fJ0\u0010\u0011\u001a,\u0012(\u0012&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00100\r0\fJ\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/company/attendance/service/WorkManagerService;", "", "context", "Landroid/content/Context;", "notificationUtils", "Lcom/company/attendance/utils/NotificationUtils;", "(Landroid/content/Context;Lcom/company/attendance/utils/NotificationUtils;)V", "workManager", "Landroidx/work/WorkManager;", "cancelAllWork", "", "getHeartbeatWorkInfo", "Landroidx/lifecycle/LiveData;", "", "Landroidx/work/WorkInfo;", "kotlin.jvm.PlatformType", "", "getRetryWorkInfo", "initializeBackgroundWork", "retryQueuedRequestsNow", "sendImmediateHeartbeat", "startHeartbeatWork", "startRetryWork", "stopHeartbeatWork", "stopRetryWork", "app_debug"})
public final class WorkManagerService {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.NotificationUtils notificationUtils = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.work.WorkManager workManager = null;
    
    @javax.inject.Inject()
    public WorkManagerService(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.NotificationUtils notificationUtils) {
        super();
    }
    
    /**
     * Start periodic heartbeat for active session
     */
    public final void startHeartbeatWork() {
    }
    
    /**
     * Stop heartbeat work when session ends
     */
    public final void stopHeartbeatWork() {
    }
    
    /**
     * Send immediate heartbeat
     */
    public final void sendImmediateHeartbeat() {
    }
    
    /**
     * Start periodic retry of queued requests
     */
    public final void startRetryWork() {
    }
    
    /**
     * Stop periodic retry work
     */
    public final void stopRetryWork() {
    }
    
    /**
     * Retry queued requests immediately
     */
    public final void retryQueuedRequestsNow() {
    }
    
    /**
     * Get work info for heartbeat work
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<androidx.work.WorkInfo>> getHeartbeatWorkInfo() {
        return null;
    }
    
    /**
     * Get work info for retry work
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<androidx.work.WorkInfo>> getRetryWorkInfo() {
        return null;
    }
    
    /**
     * Cancel all background work
     */
    public final void cancelAllWork() {
    }
    
    /**
     * Initialize background work on app startup
     */
    public final void initializeBackgroundWork() {
    }
}