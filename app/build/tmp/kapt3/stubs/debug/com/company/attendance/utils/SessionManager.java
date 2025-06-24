package com.company.attendance.utils;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\nH\u0082@\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\nJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/company/attendance/utils/SessionManager;", "", "authRepository", "Lcom/company/attendance/data/repository/AuthRepository;", "(Lcom/company/attendance/data/repository/AuthRepository;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "refreshJob", "Lkotlinx/coroutines/Job;", "checkAndRefreshSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "ensureValidSession", "", "refreshSessionIfNeeded", "", "startSessionMonitoring", "stopSessionMonitoring", "Companion", "app_debug"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "SessionManager";
    private static final long REFRESH_THRESHOLD_MINUTES = 5L;
    private static final long CHECK_INTERVAL_MINUTES = 1L;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job refreshJob;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.utils.SessionManager.Companion Companion = null;
    
    @javax.inject.Inject()
    public SessionManager(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AuthRepository authRepository) {
        super();
    }
    
    public final void startSessionMonitoring() {
    }
    
    public final void stopSessionMonitoring() {
    }
    
    private final java.lang.Object checkAndRefreshSession(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshSessionIfNeeded(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object ensureValidSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    public final void cleanup() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/company/attendance/utils/SessionManager$Companion;", "", "()V", "CHECK_INTERVAL_MINUTES", "", "REFRESH_THRESHOLD_MINUTES", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}