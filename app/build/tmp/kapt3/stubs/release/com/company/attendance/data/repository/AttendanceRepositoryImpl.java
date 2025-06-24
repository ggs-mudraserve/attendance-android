package com.company.attendance.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BO\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0082@\u00a2\u0006\u0002\u0010\"J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b&\u0010\'J\u000e\u0010(\u001a\u00020\u001dH\u0096@\u00a2\u0006\u0002\u0010\'J\"\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0 0$H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b+\u0010\'J2\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0$2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u00101J,\u00102\u001a\b\u0012\u0004\u0012\u0002030$2\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u0004\u0018\u00010\u0019H\u0096@\u00a2\u0006\u0002\u0010\'J\u0010\u00109\u001a\u0004\u0018\u00010\u0017H\u0096@\u00a2\u0006\u0002\u0010\'J2\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0$2\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020%H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b;\u00107J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0016J\u0014\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0 0@H\u0016J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020C0$H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bD\u0010\'J\b\u0010E\u001a\u00020FH\u0016J\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00170$H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bH\u0010\'J\u000e\u0010I\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010\'J\u000e\u0010K\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010\'J\u000e\u0010L\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010\'J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00190$H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bN\u0010\'J\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00190$H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bP\u0010\'J&\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00170$2\b\u0010R\u001a\u0004\u0018\u00010SH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bT\u0010UJ\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020%0$H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bW\u0010\'J0\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\u00172\u0006\u0010Z\u001a\u00020\u00172\b\u0010[\u001a\u0004\u0018\u00010\u00172\u0006\u0010\\\u001a\u00020\u0017H\u0082@\u00a2\u0006\u0002\u0010]J\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020%0$H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b_\u0010\'J\u0016\u0010`\u001a\u00020J2\u0006\u0010a\u001a\u00020AH\u0082@\u00a2\u0006\u0002\u0010bJ$\u0010c\u001a\b\u0012\u0004\u0012\u00020J0$2\u0006\u0010d\u001a\u00020eH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bf\u0010gJ&\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00170$2\b\u0010i\u001a\u0004\u0018\u00010\u0017H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bj\u0010kJ,\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00170$2\u0006\u0010m\u001a\u00020\u00172\u0006\u0010n\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bo\u0010pJ\u001c\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001d0$H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\br\u0010\'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006s"}, d2 = {"Lcom/company/attendance/data/repository/AttendanceRepositoryImpl;", "Lcom/company/attendance/data/repository/AttendanceRepository;", "supabaseClient", "Lio/github/jan/supabase/SupabaseClient;", "apiService", "Lcom/company/attendance/data/remote/AttendanceApiService;", "queuedRequestDao", "Lcom/company/attendance/data/local/QueuedRequestDao;", "preferencesManager", "Lcom/company/attendance/utils/PreferencesManager;", "deviceUtils", "Lcom/company/attendance/utils/DeviceUtils;", "wifiValidator", "Lcom/company/attendance/utils/WiFiValidator;", "wifiMonitoringService", "Lcom/company/attendance/service/WiFiMonitoringService;", "requestQueueManager", "Lcom/company/attendance/service/RequestQueueManager;", "attendanceRecordDao", "Lcom/company/attendance/data/local/AttendanceRecordDao;", "(Lio/github/jan/supabase/SupabaseClient;Lcom/company/attendance/data/remote/AttendanceApiService;Lcom/company/attendance/data/local/QueuedRequestDao;Lcom/company/attendance/utils/PreferencesManager;Lcom/company/attendance/utils/DeviceUtils;Lcom/company/attendance/utils/WiFiValidator;Lcom/company/attendance/service/WiFiMonitoringService;Lcom/company/attendance/service/RequestQueueManager;Lcom/company/attendance/data/local/AttendanceRecordDao;)V", "approvedBSSIDs", "", "", "currentSession", "Lcom/company/attendance/data/model/AttendanceSession;", "gson", "Lcom/google/gson/Gson;", "cacheAttendanceRecords", "", "userId", "records", "", "Lcom/company/attendance/data/model/AttendanceRecord;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearFailedRequests", "Lkotlin/Result;", "", "clearFailedRequests-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearQueue", "getApprovedWiFiNetworks", "Lcom/company/attendance/data/model/ApprovedWiFiNetwork;", "getApprovedWiFiNetworks-IoAF18A", "getAttendanceForDateRange", "startDate", "Lkotlinx/datetime/LocalDate;", "endDate", "getAttendanceForDateRange-0E7RQCE", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceSummary", "Lcom/company/attendance/data/repository/AttendanceSummary;", "year", "month", "getAttendanceSummary-0E7RQCE", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentSession", "getCurrentUser", "getMonthlyAttendance", "getMonthlyAttendance-0E7RQCE", "getQueueStatus", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/company/attendance/service/QueueStatus;", "getQueuedRequests", "Lkotlinx/coroutines/flow/Flow;", "Lcom/company/attendance/data/model/QueuedRequest;", "getUserProfile", "Lcom/company/attendance/data/model/Profile;", "getUserProfile-IoAF18A", "getWiFiInfo", "Lcom/company/attendance/utils/WiFiInfo;", "healthCheck", "healthCheck-IoAF18A", "isDeviceOnboarded", "", "isOnApprovedWiFi", "isUserLoggedIn", "markIn", "markIn-IoAF18A", "markOut", "markOut-IoAF18A", "onboardDevice", "bankDetails", "Lcom/company/attendance/data/repository/BankDetails;", "onboardDevice-gIAlu-s", "(Lcom/company/attendance/data/repository/BankDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processQueuedRequests", "processQueuedRequests-IoAF18A", "queueRequest", "endpoint", "method", "body", "eventId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryCriticalRequests", "retryCriticalRequests-IoAF18A", "retryRequest", "request", "(Lcom/company/attendance/data/model/QueuedRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryRequestManually", "requestId", "", "retryRequestManually-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendHeartbeat", "sessionId", "sendHeartbeat-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "email", "password", "signIn-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "signOut-IoAF18A", "app_release"})
public final class AttendanceRepositoryImpl implements com.company.attendance.data.repository.AttendanceRepository {
    @org.jetbrains.annotations.NotNull()
    private final io.github.jan.supabase.SupabaseClient supabaseClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.remote.AttendanceApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.local.QueuedRequestDao queuedRequestDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.PreferencesManager preferencesManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.DeviceUtils deviceUtils = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.WiFiValidator wifiValidator = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.service.WiFiMonitoringService wifiMonitoringService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.service.RequestQueueManager requestQueueManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.local.AttendanceRecordDao attendanceRecordDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.Set<java.lang.String> approvedBSSIDs;
    @org.jetbrains.annotations.Nullable()
    private com.company.attendance.data.model.AttendanceSession currentSession;
    
    @javax.inject.Inject()
    public AttendanceRepositoryImpl(@org.jetbrains.annotations.NotNull()
    io.github.jan.supabase.SupabaseClient supabaseClient, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.remote.AttendanceApiService apiService, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.QueuedRequestDao queuedRequestDao, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.PreferencesManager preferencesManager, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.DeviceUtils deviceUtils, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.WiFiValidator wifiValidator, @org.jetbrains.annotations.NotNull()
    com.company.attendance.service.WiFiMonitoringService wifiMonitoringService, @org.jetbrains.annotations.NotNull()
    com.company.attendance.service.RequestQueueManager requestQueueManager, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.AttendanceRecordDao attendanceRecordDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object isUserLoggedIn(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object isDeviceOnboarded(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object cacheAttendanceRecords(java.lang.String userId, java.util.List<com.company.attendance.data.model.AttendanceRecord> records, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AttendanceSession> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object isOnApprovedWiFi(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.company.attendance.utils.WiFiInfo getWiFiInfo() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.company.attendance.data.model.QueuedRequest>> getQueuedRequests() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object clearQueue(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<com.company.attendance.service.QueueStatus> getQueueStatus() {
        return null;
    }
    
    private final java.lang.Object queueRequest(java.lang.String endpoint, java.lang.String method, java.lang.String body, java.lang.String eventId, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object retryRequest(com.company.attendance.data.model.QueuedRequest request, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}