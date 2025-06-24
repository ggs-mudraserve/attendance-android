package com.company.attendance.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ.\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0012J.\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u0012J8\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00a2\u0006\u0002\u0010\u0017J8\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0015\u001a\u00020\u0019H\u00a7@\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/company/attendance/data/remote/AttendanceApiService;", "", "getMonthlyAttendance", "Lretrofit2/Response;", "Lcom/company/attendance/data/model/ApiResponse;", "", "Lcom/company/attendance/data/model/AttendanceRecord;", "authorization", "", "year", "", "month", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "healthCheck", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markIn", "Lcom/company/attendance/data/model/AttendanceSession;", "eventId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markOut", "onboard", "request", "Lcom/company/attendance/data/model/OnboardingRequest;", "(Ljava/lang/String;Ljava/lang/String;Lcom/company/attendance/data/model/OnboardingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendHeartbeat", "Lcom/company/attendance/data/model/HeartbeatRequest;", "(Ljava/lang/String;Ljava/lang/String;Lcom/company/attendance/data/model/HeartbeatRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AttendanceApiService {
    
    @retrofit2.http.POST(value = "onboard")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object onboard(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @retrofit2.http.Header(value = "X-Event-Id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.OnboardingRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.company.attendance.data.model.ApiResponse<java.lang.String>>> $completion);
    
    @retrofit2.http.POST(value = "in")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markIn(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @retrofit2.http.Header(value = "X-Event-Id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.company.attendance.data.model.ApiResponse<com.company.attendance.data.model.AttendanceSession>>> $completion);
    
    @retrofit2.http.POST(value = "out")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markOut(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @retrofit2.http.Header(value = "X-Event-Id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.company.attendance.data.model.ApiResponse<com.company.attendance.data.model.AttendanceSession>>> $completion);
    
    @retrofit2.http.POST(value = "heartbeat")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendHeartbeat(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @retrofit2.http.Header(value = "X-Event-Id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String eventId, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.HeartbeatRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.company.attendance.data.model.ApiResponse<java.lang.String>>> $completion);
    
    @retrofit2.http.GET(value = "attendance/{year}/{month}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMonthlyAttendance(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String authorization, @retrofit2.http.Path(value = "year")
    int year, @retrofit2.http.Path(value = "month")
    int month, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.company.attendance.data.model.ApiResponse<java.util.List<com.company.attendance.data.model.AttendanceRecord>>>> $completion);
    
    @retrofit2.http.GET(value = "healthz")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object healthCheck(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.company.attendance.data.model.ApiResponse<java.lang.String>>> $completion);
}