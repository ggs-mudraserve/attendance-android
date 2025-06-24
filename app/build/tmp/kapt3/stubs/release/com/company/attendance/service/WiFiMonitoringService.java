package com.company.attendance.service;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ*\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010\u00172\b\u0010,\u001a\u0004\u0018\u00010\u0017H\u0086@\u00a2\u0006\u0002\u0010-J\b\u0010.\u001a\u00020)H\u0002J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u000200H\u0082@\u00a2\u0006\u0002\u00104J\b\u00105\u001a\u000200H\u0002J\u0016\u00106\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u00107J\u0006\u00108\u001a\u000200J\u0006\u00109\u001a\u000200J\u000e\u0010:\u001a\u000200H\u0082@\u00a2\u0006\u0002\u00104J\u000e\u0010;\u001a\u000200H\u0082@\u00a2\u0006\u0002\u00104J\b\u0010<\u001a\u000200H\u0002J\u000e\u0010=\u001a\u000200H\u0082@\u00a2\u0006\u0002\u00104J\u0016\u0010>\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0002\u00107R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0014\u00a8\u0006@"}, d2 = {"Lcom/company/attendance/service/WiFiMonitoringService;", "", "context", "Landroid/content/Context;", "approvedWiFiDao", "Lcom/company/attendance/data/local/ApprovedWiFiDao;", "attendanceRepository", "Lcom/company/attendance/data/repository/AttendanceRepository;", "(Landroid/content/Context;Lcom/company/attendance/data/local/ApprovedWiFiDao;Lcom/company/attendance/data/repository/AttendanceRepository;)V", "_approvedNetworks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/company/attendance/data/model/ApprovedWiFiNetwork;", "_permissionState", "Lcom/company/attendance/data/model/WiFiPermissionState;", "_wifiStatus", "Lcom/company/attendance/data/model/WiFiStatus;", "approvedNetworks", "Lkotlinx/coroutines/flow/StateFlow;", "getApprovedNetworks", "()Lkotlinx/coroutines/flow/StateFlow;", "cachedApprovedBSSIDs", "", "", "lastServerSync", "", "locationManager", "Landroid/location/LocationManager;", "monitoringJob", "Lkotlinx/coroutines/Job;", "networkReceiver", "Landroid/content/BroadcastReceiver;", "permissionState", "getPermissionState", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "wifiManager", "Landroid/net/wifi/WifiManager;", "wifiStatus", "getWifiStatus", "addApprovedNetwork", "", "bssid", "label", "ssid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPermissions", "cleanup", "", "getCurrentWiFiValidation", "Lcom/company/attendance/data/model/WiFiValidationResult;", "loadApprovedNetworks", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerNetworkReceiver", "removeApprovedNetwork", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startMonitoring", "stopMonitoring", "syncApprovedNetworksFromServer", "syncWithServerIfNeeded", "unregisterNetworkReceiver", "updateWiFiStatus", "validateBSSID", "Companion", "app_release"})
public final class WiFiMonitoringService {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.local.ApprovedWiFiDao approvedWiFiDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AttendanceRepository attendanceRepository = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "WiFiMonitoringService";
    private static final long SCAN_INTERVAL_MS = 30000L;
    private static final long VALIDATION_CACHE_DURATION = 300000L;
    @org.jetbrains.annotations.NotNull()
    private final android.net.wifi.WifiManager wifiManager = null;
    @org.jetbrains.annotations.NotNull()
    private final android.location.LocationManager locationManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.data.model.WiFiStatus> _wifiStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.WiFiStatus> wifiStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.data.model.WiFiPermissionState> _permissionState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.WiFiPermissionState> permissionState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.company.attendance.data.model.ApprovedWiFiNetwork>> _approvedNetworks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.company.attendance.data.model.ApprovedWiFiNetwork>> approvedNetworks = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job monitoringJob;
    @org.jetbrains.annotations.Nullable()
    private android.content.BroadcastReceiver networkReceiver;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope serviceScope = null;
    private long lastServerSync = 0L;
    @org.jetbrains.annotations.NotNull()
    private java.util.Set<java.lang.String> cachedApprovedBSSIDs;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.service.WiFiMonitoringService.Companion Companion = null;
    
    @javax.inject.Inject()
    public WiFiMonitoringService(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.ApprovedWiFiDao approvedWiFiDao, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AttendanceRepository attendanceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.WiFiStatus> getWifiStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.WiFiPermissionState> getPermissionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.company.attendance.data.model.ApprovedWiFiNetwork>> getApprovedNetworks() {
        return null;
    }
    
    public final void startMonitoring() {
    }
    
    public final void stopMonitoring() {
    }
    
    private final java.lang.Object updateWiFiStatus(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object validateBSSID(java.lang.String bssid, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object loadApprovedNetworks(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object syncWithServerIfNeeded(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object syncApprovedNetworksFromServer(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final boolean checkPermissions() {
        return false;
    }
    
    private final void registerNetworkReceiver() {
    }
    
    private final void unregisterNetworkReceiver() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addApprovedNetwork(@org.jetbrains.annotations.NotNull()
    java.lang.String bssid, @org.jetbrains.annotations.Nullable()
    java.lang.String label, @org.jetbrains.annotations.Nullable()
    java.lang.String ssid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object removeApprovedNetwork(@org.jetbrains.annotations.NotNull()
    java.lang.String bssid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.model.WiFiValidationResult getCurrentWiFiValidation() {
        return null;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/company/attendance/service/WiFiMonitoringService$Companion;", "", "()V", "SCAN_INTERVAL_MS", "", "TAG", "", "VALIDATION_CACHE_DURATION", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}