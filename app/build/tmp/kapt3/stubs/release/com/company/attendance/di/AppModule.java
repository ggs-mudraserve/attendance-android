package com.company.attendance.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007JP\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000fH\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0007J\u0018\u0010&\u001a\u00020\'2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0012\u0010(\u001a\u00020\u001a2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\b\u0010)\u001a\u00020*H\u0007J\b\u0010+\u001a\u00020,H\u0007J\u0012\u0010-\u001a\u00020.2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020#H\u0007J\u0012\u00102\u001a\u0002032\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0012\u00104\u001a\u00020\u00182\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J0\u00106\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020*H\u0007J\u0018\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u0002002\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020\'H\u0007J\b\u0010=\u001a\u00020\u0013H\u0007J\"\u0010>\u001a\u00020\u001e2\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0011H\u0007J\u001a\u0010A\u001a\u00020\u001c2\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007\u00a8\u0006B"}, d2 = {"Lcom/company/attendance/di/AppModule;", "", "()V", "provideApprovedWiFiDao", "Lcom/company/attendance/data/local/ApprovedWiFiDao;", "database", "Lcom/company/attendance/data/local/AttendanceDatabase;", "provideAttendanceApiService", "Lcom/company/attendance/data/remote/AttendanceApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideAttendanceDatabase", "context", "Landroid/content/Context;", "provideAttendanceRecordDao", "Lcom/company/attendance/data/local/AttendanceRecordDao;", "provideAttendanceRepository", "Lcom/company/attendance/data/repository/AttendanceRepository;", "supabaseClient", "Lio/github/jan/supabase/SupabaseClient;", "apiService", "queuedRequestDao", "Lcom/company/attendance/data/local/QueuedRequestDao;", "preferencesManager", "Lcom/company/attendance/utils/PreferencesManager;", "deviceUtils", "Lcom/company/attendance/utils/DeviceUtils;", "wifiValidator", "Lcom/company/attendance/utils/WiFiValidator;", "wifiMonitoringService", "Lcom/company/attendance/service/WiFiMonitoringService;", "requestQueueManager", "Lcom/company/attendance/service/RequestQueueManager;", "attendanceRecordDao", "provideAuthInterceptor", "Lcom/company/attendance/network/AuthInterceptor;", "sessionManager", "Lcom/company/attendance/utils/SessionManager;", "provideAuthRepository", "Lcom/company/attendance/data/repository/AuthRepository;", "provideDeviceUtils", "provideGson", "Lcom/google/gson/Gson;", "provideNavigationHelper", "Lcom/company/attendance/utils/NavigationHelper;", "provideNetworkUtils", "Lcom/company/attendance/utils/NetworkUtils;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "authInterceptor", "providePermissionHandler", "Lcom/company/attendance/utils/PermissionHandler;", "providePreferencesManager", "provideQueuedRequestDao", "provideRequestQueueManager", "networkUtils", "gson", "provideRetrofit", "okHttpClient", "provideSessionManager", "authRepository", "provideSupabaseClient", "provideWiFiMonitoringService", "approvedWiFiDao", "attendanceRepository", "provideWiFiValidator", "app_release"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final io.github.jan.supabase.SupabaseClient provideSupabaseClient() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull()
    com.company.attendance.network.AuthInterceptor authInterceptor) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.PreferencesManager preferencesManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.remote.AttendanceApiService provideAttendanceApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.local.AttendanceDatabase provideAttendanceDatabase(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.local.QueuedRequestDao provideQueuedRequestDao(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.AttendanceDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.local.ApprovedWiFiDao provideApprovedWiFiDao(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.AttendanceDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.utils.PreferencesManager providePreferencesManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.utils.DeviceUtils provideDeviceUtils(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.utils.PermissionHandler providePermissionHandler(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.service.WiFiMonitoringService provideWiFiMonitoringService(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.ApprovedWiFiDao approvedWiFiDao, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AttendanceRepository attendanceRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.utils.WiFiValidator provideWiFiValidator(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.company.attendance.service.WiFiMonitoringService wifiMonitoringService) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.utils.SessionManager provideSessionManager(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AuthRepository authRepository) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.network.AuthInterceptor provideAuthInterceptor(@org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.SessionManager sessionManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.utils.NavigationHelper provideNavigationHelper() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.repository.AuthRepository provideAuthRepository(@org.jetbrains.annotations.NotNull()
    io.github.jan.supabase.SupabaseClient supabaseClient, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.PreferencesManager preferencesManager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.local.AttendanceRecordDao provideAttendanceRecordDao(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.AttendanceDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.utils.NetworkUtils provideNetworkUtils(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.service.RequestQueueManager provideRequestQueueManager(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.QueuedRequestDao queuedRequestDao, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.remote.AttendanceApiService apiService, @org.jetbrains.annotations.NotNull()
    io.github.jan.supabase.SupabaseClient supabaseClient, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.NetworkUtils networkUtils, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.repository.AttendanceRepository provideAttendanceRepository(@org.jetbrains.annotations.NotNull()
    io.github.jan.supabase.SupabaseClient supabaseClient, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.remote.AttendanceApiService apiService, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.QueuedRequestDao queuedRequestDao, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.PreferencesManager preferencesManager, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.DeviceUtils deviceUtils, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.WiFiValidator wifiValidator, @org.jetbrains.annotations.NotNull()
    com.company.attendance.service.WiFiMonitoringService wifiMonitoringService, @org.jetbrains.annotations.NotNull()
    com.company.attendance.service.RequestQueueManager requestQueueManager, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.local.AttendanceRecordDao attendanceRecordDao) {
        return null;
    }
}