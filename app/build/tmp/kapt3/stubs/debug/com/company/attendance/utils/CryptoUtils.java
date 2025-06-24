package com.company.attendance.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/company/attendance/utils/CryptoUtils;", "", "()V", "HMAC_ALGORITHM", "", "SHARED_SECRET", "bytesToHex", "bytes", "", "generateEventId", "deviceUuid", "timestamp", "", "generateHMAC", "data", "key", "sha256Hash", "input", "app_debug"})
public final class CryptoUtils {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String HMAC_ALGORITHM = "HmacSHA256";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SHARED_SECRET = "your_shared_secret_here";
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.utils.CryptoUtils INSTANCE = null;
    
    private CryptoUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateEventId(@org.jetbrains.annotations.NotNull()
    java.lang.String deviceUuid, long timestamp) {
        return null;
    }
    
    private final java.lang.String generateHMAC(java.lang.String data, java.lang.String key) {
        return null;
    }
    
    private final java.lang.String bytesToHex(byte[] bytes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sha256Hash(@org.jetbrains.annotations.NotNull()
    java.lang.String input) {
        return null;
    }
}