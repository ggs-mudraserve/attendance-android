package com.company.attendance.utils;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/company/attendance/utils/NotificationUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createHeartbeatNotification", "Landroid/app/Notification;", "dismissHeartbeatNotifications", "", "showHeartbeatErrorNotification", "title", "", "message", "showHeartbeatSuccessNotification", "Companion", "app_release"})
public final class NotificationUtils {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID_HEARTBEAT = "heartbeat_channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID_HEARTBEAT_STATUS = "heartbeat_status_channel";
    public static final int NOTIFICATION_ID_HEARTBEAT = 1001;
    public static final int NOTIFICATION_ID_HEARTBEAT_SUCCESS = 1002;
    public static final int NOTIFICATION_ID_HEARTBEAT_ERROR = 1003;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.utils.NotificationUtils.Companion Companion = null;
    
    @javax.inject.Inject()
    public NotificationUtils(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Notification createHeartbeatNotification() {
        return null;
    }
    
    public final void showHeartbeatSuccessNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showHeartbeatErrorNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void dismissHeartbeatNotifications() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/company/attendance/utils/NotificationUtils$Companion;", "", "()V", "CHANNEL_ID_HEARTBEAT", "", "CHANNEL_ID_HEARTBEAT_STATUS", "NOTIFICATION_ID_HEARTBEAT", "", "NOTIFICATION_ID_HEARTBEAT_ERROR", "NOTIFICATION_ID_HEARTBEAT_SUCCESS", "createNotificationChannels", "", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void createNotificationChannels(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
    }
}