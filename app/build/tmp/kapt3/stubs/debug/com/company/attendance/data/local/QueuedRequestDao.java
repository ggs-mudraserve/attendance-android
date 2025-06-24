package com.company.attendance.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\u0012H\'J\u000e\u0010\u0014\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u001a\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010!\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\""}, d2 = {"Lcom/company/attendance/data/local/QueuedRequestDao;", "", "clearAllRequests", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearFailedRequests", "maxRetries", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRequest", "request", "Lcom/company/attendance/data/model/QueuedRequest;", "(Lcom/company/attendance/data/model/QueuedRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRequestById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllQueuedRequests", "Lkotlinx/coroutines/flow/Flow;", "", "getCriticalRequestCount", "getCriticalRequests", "getFailedRequestCount", "getFailedRequests", "getPendingRequestCount", "getPendingRequests", "getQueuedRequestCount", "getRequestById", "getRequestsByType", "endpoint", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRequest", "updateRequest", "app_debug"})
@androidx.room.Dao()
public abstract interface QueuedRequestDao {
    
    @androidx.room.Query(value = "SELECT * FROM queued_requests ORDER BY timestamp ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.company.attendance.data.model.QueuedRequest>> getAllQueuedRequests();
    
    @androidx.room.Query(value = "SELECT * FROM queued_requests WHERE retry_count < :maxRetries ORDER BY timestamp ASC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPendingRequests(int maxRetries, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.attendance.data.model.QueuedRequest>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM queued_requests WHERE retry_count >= :maxRetries ORDER BY timestamp ASC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFailedRequests(int maxRetries, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.attendance.data.model.QueuedRequest>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM queued_requests WHERE endpoint = :endpoint ORDER BY timestamp ASC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRequestsByType(@org.jetbrains.annotations.NotNull()
    java.lang.String endpoint, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.attendance.data.model.QueuedRequest>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM queued_requests WHERE endpoint IN (\'in\', \'out\') ORDER BY timestamp ASC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCriticalRequests(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.attendance.data.model.QueuedRequest>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM queued_requests WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRequestById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.QueuedRequest> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertRequest(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.QueuedRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateRequest(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.QueuedRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteRequest(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.QueuedRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM queued_requests WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteRequestById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM queued_requests")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearAllRequests(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM queued_requests WHERE retry_count >= :maxRetries")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearFailedRequests(int maxRetries, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM queued_requests")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getQueuedRequestCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM queued_requests WHERE retry_count < :maxRetries")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPendingRequestCount(int maxRetries, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM queued_requests WHERE retry_count >= :maxRetries")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFailedRequestCount(int maxRetries, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM queued_requests WHERE endpoint IN (\'in\', \'out\')")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCriticalRequestCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}