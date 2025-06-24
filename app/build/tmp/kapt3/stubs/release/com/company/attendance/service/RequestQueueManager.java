package com.company.attendance.service;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001cJ\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0019H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b%\u0010\u001cJH\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020(2\b\b\u0002\u0010,\u001a\u00020-H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b.\u0010/J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020$0\u0019H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b1\u0010\u001cJ\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\"H\u0082@\u00a2\u0006\u0002\u00105J$\u00106\u001a\b\u0012\u0004\u0012\u0002030\u00192\u0006\u00107\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b8\u00109J\u000e\u0010:\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010\u001cR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006;"}, d2 = {"Lcom/company/attendance/service/RequestQueueManager;", "", "queuedRequestDao", "Lcom/company/attendance/data/local/QueuedRequestDao;", "apiService", "Lcom/company/attendance/data/remote/AttendanceApiService;", "supabaseClient", "Lio/github/jan/supabase/SupabaseClient;", "networkUtils", "Lcom/company/attendance/utils/NetworkUtils;", "gson", "Lcom/google/gson/Gson;", "(Lcom/company/attendance/data/local/QueuedRequestDao;Lcom/company/attendance/data/remote/AttendanceApiService;Lio/github/jan/supabase/SupabaseClient;Lcom/company/attendance/utils/NetworkUtils;Lcom/google/gson/Gson;)V", "_queueStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/attendance/service/QueueStatus;", "queueStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getQueueStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "calculateBackoffDelay", "", "retryCount", "", "clearAllRequests", "Lkotlin/Result;", "", "clearAllRequests-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearFailedRequests", "clearFailedRequests-IoAF18A", "getQueuedRequests", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/company/attendance/data/model/QueuedRequest;", "processQueuedRequests", "Lcom/company/attendance/service/QueueProcessResult;", "processQueuedRequests-IoAF18A", "queueRequest", "endpoint", "", "method", "body", "eventId", "priority", "Lcom/company/attendance/service/RequestPriority;", "queueRequest-hUnOzRk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/company/attendance/service/RequestPriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryCriticalRequests", "retryCriticalRequests-IoAF18A", "retryRequest", "", "request", "(Lcom/company/attendance/data/model/QueuedRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryRequestManually", "requestId", "retryRequestManually-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateQueueStatus", "app_release"})
public final class RequestQueueManager {
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.local.QueuedRequestDao queuedRequestDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.remote.AttendanceApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final io.github.jan.supabase.SupabaseClient supabaseClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.NetworkUtils networkUtils = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.service.QueueStatus> _queueStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.service.QueueStatus> queueStatus = null;
    
    @javax.inject.Inject()
    public RequestQueueManager(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.QueuedRequestDao queuedRequestDao, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.remote.AttendanceApiService apiService, @org.jetbrains.annotations.NotNull()
    io.github.jan.supabase.SupabaseClient supabaseClient, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.NetworkUtils networkUtils, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.service.QueueStatus> getQueueStatus() {
        return null;
    }
    
    /**
     * Get all queued requests as a flow
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.company.attendance.data.model.QueuedRequest>> getQueuedRequests() {
        return null;
    }
    
    /**
     * Calculate exponential backoff delay with jitter
     */
    private final long calculateBackoffDelay(int retryCount) {
        return 0L;
    }
    
    /**
     * Retry a specific request
     */
    private final java.lang.Object retryRequest(com.company.attendance.data.model.QueuedRequest request, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    /**
     * Update queue status for monitoring
     */
    private final java.lang.Object updateQueueStatus(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}