package com.company.attendance.utils

object Constants {
    // Supabase Configuration
    const val SUPABASE_URL = "https://vxcdvuekhfdkccjhbrhz.supabase.co"
    const val SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZ4Y2R2dWVraGZka2Njamhicmh6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDM0ODI4NjUsImV4cCI6MjA1OTA1ODg2NX0.6SnpBAEQRSYlegMFE-QMLs5tyUG1W31EGdzkLeYYI7k"
    
    // Default Server Configuration
    const val DEFAULT_SERVER_IP = "192.168.1.100"
    const val DEFAULT_SERVER_PORT = 3000
    
    // App Configuration
    const val MIN_APP_VERSION = "1.0.0"
    const val HEARTBEAT_INTERVAL_MINUTES = 30L
    const val MAX_RETRY_ATTEMPTS = 3
    const val REQUEST_TIMEOUT_SECONDS = 30L
    const val QUEUE_PROCESSING_INTERVAL_MINUTES = 15L
    
    // Time Constants (in minutes)
    const val FULL_DAY_MINUTES = 500 // 8h 20m
    const val LATE_THRESHOLD_MINUTES = 380 // 6h 20m  
    const val HALF_DAY_MINUTES = 200 // 3h 20m
    
    // Working Hours (IST)
    const val WORK_START_HOUR = 10 // 10:00 AM
    const val WORK_END_HOUR = 19 // 7:00 PM
    const val WORK_END_MINUTE = 30 // 7:30 PM
    
    // Database
    const val DATABASE_NAME = "attendance_db"
    const val DATABASE_VERSION = 3
    
    // WorkManager
    const val HEARTBEAT_WORK_NAME = "heartbeat_work"
    const val RETRY_WORK_NAME = "retry_work"
    
    // Shared Preferences
    const val PREFS_NAME = "attendance_prefs"
    const val PREF_SERVER_IP = "server_ip"
    const val PREF_SERVER_PORT = "server_port"
    const val PREF_DEVICE_UUID = "device_uuid"
    const val PREF_IS_ONBOARDED = "is_onboarded"
    const val PREF_LAST_HEARTBEAT = "last_heartbeat"
    
    // API Endpoints
    const val ENDPOINT_ONBOARD = "/onboard"
    const val ENDPOINT_IN = "/in"
    const val ENDPOINT_OUT = "/out"
    const val ENDPOINT_HEARTBEAT = "/heartbeat"
    const val ENDPOINT_ATTENDANCE = "/attendance"
    const val ENDPOINT_HEALTH = "/healthz"
    
    // Request Headers
    const val HEADER_AUTHORIZATION = "Authorization"
    const val HEADER_EVENT_ID = "X-Event-Id"
    const val HEADER_CONTENT_TYPE = "Content-Type"
    const val CONTENT_TYPE_JSON = "application/json"
    
    // Permissions
    val REQUIRED_PERMISSIONS = arrayOf(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_WIFI_STATE,
        android.Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
    )
}