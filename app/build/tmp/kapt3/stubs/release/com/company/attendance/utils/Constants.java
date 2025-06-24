package com.company.attendance.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0016X\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/company/attendance/utils/Constants;", "", "()V", "CONTENT_TYPE_JSON", "", "DATABASE_NAME", "DATABASE_VERSION", "", "DEFAULT_SERVER_IP", "DEFAULT_SERVER_PORT", "ENDPOINT_ATTENDANCE", "ENDPOINT_HEALTH", "ENDPOINT_HEARTBEAT", "ENDPOINT_IN", "ENDPOINT_ONBOARD", "ENDPOINT_OUT", "FULL_DAY_MINUTES", "HALF_DAY_MINUTES", "HEADER_AUTHORIZATION", "HEADER_CONTENT_TYPE", "HEADER_EVENT_ID", "HEARTBEAT_INTERVAL_MINUTES", "", "HEARTBEAT_WORK_NAME", "LATE_THRESHOLD_MINUTES", "MAX_RETRY_ATTEMPTS", "MIN_APP_VERSION", "PREFS_NAME", "PREF_DEVICE_UUID", "PREF_IS_ONBOARDED", "PREF_LAST_HEARTBEAT", "PREF_SERVER_IP", "PREF_SERVER_PORT", "QUEUE_PROCESSING_INTERVAL_MINUTES", "REQUEST_TIMEOUT_SECONDS", "REQUIRED_PERMISSIONS", "", "getREQUIRED_PERMISSIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "RETRY_WORK_NAME", "SUPABASE_ANON_KEY", "SUPABASE_URL", "WORK_END_HOUR", "WORK_END_MINUTE", "WORK_START_HOUR", "app_release"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUPABASE_URL = "https://vxcdvuekhfdkccjhbrhz.supabase.co";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZ4Y2R2dWVraGZka2Njamhicmh6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDU5MjQwMDAsImV4cCI6MjAyMTUwMDAwMH0.example-anon-key";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DEFAULT_SERVER_IP = "192.168.1.100";
    public static final int DEFAULT_SERVER_PORT = 3000;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MIN_APP_VERSION = "1.0.0";
    public static final long HEARTBEAT_INTERVAL_MINUTES = 30L;
    public static final int MAX_RETRY_ATTEMPTS = 3;
    public static final long REQUEST_TIMEOUT_SECONDS = 30L;
    public static final long QUEUE_PROCESSING_INTERVAL_MINUTES = 15L;
    public static final int FULL_DAY_MINUTES = 500;
    public static final int LATE_THRESHOLD_MINUTES = 380;
    public static final int HALF_DAY_MINUTES = 200;
    public static final int WORK_START_HOUR = 10;
    public static final int WORK_END_HOUR = 19;
    public static final int WORK_END_MINUTE = 30;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "attendance_db";
    public static final int DATABASE_VERSION = 3;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HEARTBEAT_WORK_NAME = "heartbeat_work";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RETRY_WORK_NAME = "retry_work";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREFS_NAME = "attendance_prefs";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_SERVER_IP = "server_ip";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_SERVER_PORT = "server_port";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEVICE_UUID = "device_uuid";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_IS_ONBOARDED = "is_onboarded";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_LAST_HEARTBEAT = "last_heartbeat";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENDPOINT_ONBOARD = "/onboard";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENDPOINT_IN = "/in";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENDPOINT_OUT = "/out";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENDPOINT_HEARTBEAT = "/heartbeat";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENDPOINT_ATTENDANCE = "/attendance";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENDPOINT_HEALTH = "/healthz";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HEADER_AUTHORIZATION = "Authorization";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HEADER_EVENT_ID = "X-Event-Id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HEADER_CONTENT_TYPE = "Content-Type";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONTENT_TYPE_JSON = "application/json";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] REQUIRED_PERMISSIONS = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_WIFI_STATE", "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"};
    @org.jetbrains.annotations.NotNull()
    public static final com.company.attendance.utils.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getREQUIRED_PERMISSIONS() {
        return null;
    }
}