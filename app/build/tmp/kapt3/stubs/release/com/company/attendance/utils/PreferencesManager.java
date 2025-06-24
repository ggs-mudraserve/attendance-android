package com.company.attendance.utils;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\"\u001a\u00020#R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/company/attendance/utils/PreferencesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "deviceUuid", "getDeviceUuid", "()Ljava/lang/String;", "setDeviceUuid", "(Ljava/lang/String;)V", "", "isOnboarded", "()Z", "setOnboarded", "(Z)V", "", "lastHeartbeat", "getLastHeartbeat", "()J", "setLastHeartbeat", "(J)V", "serverIp", "getServerIp", "setServerIp", "", "serverPort", "getServerPort", "()I", "setServerPort", "(I)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "clear", "", "app_release"})
public final class PreferencesManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences sharedPreferences = null;
    
    @javax.inject.Inject()
    public PreferencesManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getServerIp() {
        return null;
    }
    
    public final void setServerIp(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final int getServerPort() {
        return 0;
    }
    
    public final void setServerPort(int value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDeviceUuid() {
        return null;
    }
    
    public final void setDeviceUuid(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    public final boolean isOnboarded() {
        return false;
    }
    
    public final void setOnboarded(boolean value) {
    }
    
    public final long getLastHeartbeat() {
        return 0L;
    }
    
    public final void setLastHeartbeat(long value) {
    }
    
    public final void clear() {
    }
}