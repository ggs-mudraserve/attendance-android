package com.company.attendance.utils;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/company/attendance/utils/NetworkUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getNetworkType", "", "isNetworkAvailable", "", "isWiFiConnected", "app_release"})
public final class NetworkUtils {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public NetworkUtils(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Check if device has internet connectivity
     */
    public final boolean isNetworkAvailable() {
        return false;
    }
    
    /**
     * Check if device has Wi-Fi connectivity specifically
     */
    public final boolean isWiFiConnected() {
        return false;
    }
    
    /**
     * Get current network type as string
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNetworkType() {
        return null;
    }
}