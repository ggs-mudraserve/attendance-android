package com.company.attendance

import android.app.Application
import android.util.Log
import com.company.attendance.utils.NotificationUtils
import com.company.attendance.utils.SessionManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AttendanceApplication : Application() {
    
    companion object {
        private const val TAG = "AttendanceApplication"
    }
    
    @Inject
    lateinit var sessionManager: SessionManager
    
    @Inject
    lateinit var wifiMonitoringService: com.company.attendance.service.WiFiMonitoringService
    
    @Inject
    lateinit var workManagerService: com.company.attendance.service.WorkManagerService
    
    private var isInitialized = false
    
    override fun onCreate() {
        super.onCreate()
        
        if (isInitialized) {
            Log.w(TAG, "Application already initialized, skipping")
            return
        }
        
        Log.i(TAG, "Starting application initialization")
        
        try {
            // Create notification channels first (this is safe and required)
            NotificationUtils.createNotificationChannels(this)
            Log.d(TAG, "Notification channels created successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to create notification channels", e)
        }
        
        // Check if dependencies are injected before using them
        try {
            if (::sessionManager.isInitialized) {
                sessionManager.startSessionMonitoring()
                Log.d(TAG, "Session monitoring started successfully")
            } else {
                Log.w(TAG, "SessionManager not injected, skipping session monitoring")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to start session monitoring", e)
        }
        
        try {
            if (::wifiMonitoringService.isInitialized) {
                wifiMonitoringService.startMonitoring()
                Log.d(TAG, "Wi-Fi monitoring started successfully")
            } else {
                Log.w(TAG, "WiFiMonitoringService not injected, skipping Wi-Fi monitoring")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to start Wi-Fi monitoring", e)
        }
        
        try {
            if (::workManagerService.isInitialized) {
                workManagerService.initializeBackgroundWork()
                Log.d(TAG, "Background work initialized successfully")
            } else {
                Log.w(TAG, "WorkManagerService not injected, skipping background work")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to initialize background work", e)
        }
        
        isInitialized = true
        Log.i(TAG, "Application initialization completed successfully")
    }
    
    override fun onTerminate() {
        super.onTerminate()
        
        try {
            if (::sessionManager.isInitialized) {
                sessionManager.cleanup()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error during SessionManager cleanup", e)
        }
        
        try {
            if (::wifiMonitoringService.isInitialized) {
                wifiMonitoringService.cleanup()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error during WiFiMonitoringService cleanup", e)
        }
        
        try {
            if (::workManagerService.isInitialized) {
                workManagerService.cancelAllWork()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error during WorkManagerService cleanup", e)
        }
        
        Log.i(TAG, "Application termination completed")
    }
}