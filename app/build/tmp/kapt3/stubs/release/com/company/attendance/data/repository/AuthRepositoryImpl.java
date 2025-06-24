package com.company.attendance.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0096@\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010\u001b\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001eH\u0096@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\u0006\u0010 \u001a\u00020\u0017H\u0096@\u00a2\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0096@\u00a2\u0006\u0002\u0010\u0015J\b\u0010#\u001a\u00020\u0014H\u0002J\u0016\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0019H\u0096@\u00a2\u0006\u0002\u0010&J$\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0017H\u0096@\u00a2\u0006\u0002\u0010)J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u001eH\u0096@\u00a2\u0006\u0002\u0010\u0015J8\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u00172\b\u0010-\u001a\u0004\u0018\u00010\u0017H\u0096@\u00a2\u0006\u0002\u0010.J(\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020201H\u0096@\u00a2\u0006\u0002\u00103J\f\u00104\u001a\u00020\u000f*\u000205H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/company/attendance/data/repository/AuthRepositoryImpl;", "Lcom/company/attendance/data/repository/AuthRepository;", "supabaseClient", "Lio/github/jan/supabase/SupabaseClient;", "preferencesManager", "Lcom/company/attendance/utils/PreferencesManager;", "(Lio/github/jan/supabase/SupabaseClient;Lcom/company/attendance/utils/PreferencesManager;)V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/attendance/data/model/AuthState;", "authState", "Lkotlinx/coroutines/flow/Flow;", "getAuthState", "()Lkotlinx/coroutines/flow/Flow;", "currentUser", "Lcom/company/attendance/data/model/AuthUser;", "getCurrentUser", "isAuthenticated", "", "clearSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccessToken", "", "getCurrentSession", "Lcom/company/attendance/data/model/AuthSession;", "getRefreshToken", "isSessionValid", "observeAuthState", "refreshSession", "Lcom/company/attendance/data/model/AuthResult;", "resetPassword", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreSession", "restoreSessionOnInit", "saveSession", "session", "(Lcom/company/attendance/data/model/AuthSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "signUp", "firstName", "lastName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "updates", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toAuthUser", "Lio/github/jan/supabase/gotrue/user/UserInfo;", "Companion", "app_release"})
public final class AuthRepositoryImpl implements com.company.attendance.data.repository.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final io.github.jan.supabase.SupabaseClient supabaseClient = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.PreferencesManager preferencesManager = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AuthRepository";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.data.model.AuthState> _authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.company.attendance.data.model.AuthState> authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.company.attendance.data.model.AuthUser> currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isAuthenticated = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.data.repository.AuthRepositoryImpl.Companion Companion = null;
    
    @javax.inject.Inject()
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull()
    io.github.jan.supabase.SupabaseClient supabaseClient, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.PreferencesManager preferencesManager) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.company.attendance.data.model.AuthState> getAuthState() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.company.attendance.data.model.AuthUser> getCurrentUser() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> isAuthenticated() {
        return null;
    }
    
    private final void observeAuthState() {
    }
    
    private final void restoreSessionOnInit() {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object signIn(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<com.company.attendance.data.model.AuthSession>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object signUp(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.Nullable()
    java.lang.String firstName, @org.jetbrains.annotations.Nullable()
    java.lang.String lastName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<com.company.attendance.data.model.AuthSession>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object signOut(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<kotlin.Unit>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object resetPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<kotlin.Unit>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthSession> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object refreshSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<com.company.attendance.data.model.AuthSession>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object isSessionValid(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthUser> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> updates, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<com.company.attendance.data.model.AuthUser>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getAccessToken(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getRefreshToken(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object saveSession(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.AuthSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object clearSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object restoreSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthSession> $completion) {
        return null;
    }
    
    private final com.company.attendance.data.model.AuthUser toAuthUser(io.github.jan.supabase.gotrue.user.UserInfo $this$toAuthUser) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/company/attendance/data/repository/AuthRepositoryImpl$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}