package com.company.attendance.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\f\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\t\u001a\u0004\u0018\u00010\bH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\u0006\u0010\u0018\u001a\u00020\u0010H\u00a6@\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u00a6@\u00a2\u0006\u0002\u0010 J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u0016H\u00a6@\u00a2\u0006\u0002\u0010\u000eJ<\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0010H\u00a6@\u00a2\u0006\u0002\u0010%J(\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0012\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010(H\u00a6@\u00a2\u0006\u0002\u0010)R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006\u00a8\u0006*"}, d2 = {"Lcom/company/attendance/data/repository/AuthRepository;", "", "authState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/company/attendance/data/model/AuthState;", "getAuthState", "()Lkotlinx/coroutines/flow/Flow;", "currentUser", "Lcom/company/attendance/data/model/AuthUser;", "getCurrentUser", "isAuthenticated", "", "clearSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccessToken", "", "getCurrentSession", "Lcom/company/attendance/data/model/AuthSession;", "getRefreshToken", "isSessionValid", "refreshSession", "Lcom/company/attendance/data/model/AuthResult;", "resetPassword", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreSession", "saveSession", "session", "(Lcom/company/attendance/data/model/AuthSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "signUp", "firstName", "lastName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "updates", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface AuthRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.company.attendance.data.model.AuthState> getAuthState();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.company.attendance.data.model.AuthUser> getCurrentUser();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> isAuthenticated();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object signIn(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<com.company.attendance.data.model.AuthSession>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object signUp(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.Nullable()
    java.lang.String firstName, @org.jetbrains.annotations.Nullable()
    java.lang.String lastName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<com.company.attendance.data.model.AuthSession>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object signOut(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<kotlin.Unit>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resetPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<kotlin.Unit>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthSession> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<com.company.attendance.data.model.AuthSession>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object isSessionValid(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthUser> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> updates, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthResult<com.company.attendance.data.model.AuthUser>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAccessToken(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRefreshToken(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveSession(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.AuthSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object restoreSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.AuthSession> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}