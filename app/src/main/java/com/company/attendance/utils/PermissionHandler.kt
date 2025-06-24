package com.company.attendance.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.company.attendance.data.model.WiFiPermissionState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PermissionHandler @Inject constructor(
    private val context: Context
) {
    
    companion object {
        const val LOCATION_PERMISSION_REQUEST_CODE = 1001
        const val WIFI_PERMISSIONS_REQUEST_CODE = 1002
        
        val REQUIRED_WIFI_PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
    
    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    private val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
    
    /**
     * Check if all Wi-Fi related permissions are granted
     */
    fun hasAllWiFiPermissions(): Boolean {
        return REQUIRED_WIFI_PERMISSIONS.all { permission ->
            ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
        }
    }
    
    /**
     * Check location permission specifically
     */
    fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }
    
    /**
     * Check if location services are enabled
     */
    fun isLocationEnabled(): Boolean {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }
    
    /**
     * Get comprehensive Wi-Fi permission state
     */
    fun getWiFiPermissionState(): WiFiPermissionState {
        val hasPermissions = hasAllWiFiPermissions()
        val isLocationEnabled = isLocationEnabled()
        
        return when {
            !hasPermissions -> {
                if (shouldShowLocationRationale()) {
                    WiFiPermissionState.Denied
                } else {
                    WiFiPermissionState.PermanentlyDenied
                }
            }
            !isLocationEnabled -> WiFiPermissionState.Denied
            else -> WiFiPermissionState.Granted
        }
    }
    
    /**
     * Check if we should show permission rationale
     */
    private fun shouldShowLocationRationale(): Boolean {
        return if (context is Activity) {
            ActivityCompat.shouldShowRequestPermissionRationale(
                context, Manifest.permission.ACCESS_FINE_LOCATION
            )
        } else false
    }
    
    /**
     * Request Wi-Fi related permissions
     */
    fun requestWiFiPermissions(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            REQUIRED_WIFI_PERMISSIONS,
            WIFI_PERMISSIONS_REQUEST_CODE
        )
    }
    
    /**
     * Handle permission request results
     */
    fun handlePermissionResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ): PermissionResult {
        if (requestCode != WIFI_PERMISSIONS_REQUEST_CODE) {
            return PermissionResult.NotHandled
        }
        
        val allGranted = grantResults.all { it == PackageManager.PERMISSION_GRANTED }
        
        return when {
            allGranted -> PermissionResult.Granted
            shouldShowLocationRationale() -> PermissionResult.Denied
            else -> PermissionResult.PermanentlyDenied
        }
    }
    
    /**
     * Open app settings for permanent permission denial
     */
    fun openAppSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", context.packageName, null)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }
    
    /**
     * Open location settings
     */
    fun openLocationSettings() {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }
    
    /**
     * Get user-friendly permission explanation
     */
    fun getPermissionExplanation(state: WiFiPermissionState): PermissionExplanation {
        return when (state) {
            WiFiPermissionState.Granted -> PermissionExplanation(
                title = "Permissions Granted",
                message = "All required permissions are available.",
                actionText = null,
                action = null
            )
            WiFiPermissionState.Denied -> PermissionExplanation(
                title = "Location Permission Required",
                message = "Location permission is needed to detect office Wi-Fi networks for attendance validation. This ensures you're physically present at the office when marking attendance.",
                actionText = "Grant Permission",
                action = PermissionAction.REQUEST_PERMISSION
            )
            WiFiPermissionState.PermanentlyDenied -> PermissionExplanation(
                title = "Permission Blocked",
                message = "Location permission has been permanently denied. Please enable it in app settings to use attendance features.",
                actionText = "Open Settings",
                action = PermissionAction.OPEN_SETTINGS
            )
            WiFiPermissionState.NotRequested -> PermissionExplanation(
                title = "Setup Required",
                message = "We need location permission to validate your presence at the office through Wi-Fi detection.",
                actionText = "Continue",
                action = PermissionAction.REQUEST_PERMISSION
            )
        }
    }
    
    /**
     * Get missing permissions list
     */
    fun getMissingPermissions(): List<String> {
        return REQUIRED_WIFI_PERMISSIONS.filter { permission ->
            ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED
        }
    }
    
    /**
     * Check if battery optimization is ignored for this app
     */
    fun isBatteryOptimizationIgnored(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            powerManager.isIgnoringBatteryOptimizations(context.packageName)
        } else {
            true // Battery optimization not applicable on older versions
        }
    }
    
    /**
     * Check if battery optimization should be disabled
     */
    fun shouldRequestBatteryOptimization(): Boolean {
        return !isBatteryOptimizationIgnored()
    }
    
    /**
     * Request battery optimization exemption
     */
    fun requestBatteryOptimizationExemption(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldRequestBatteryOptimization()) {
            val intent = Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS).apply {
                data = Uri.parse("package:${context.packageName}")
            }
            
            try {
                activity.startActivity(intent)
            } catch (e: Exception) {
                // If the specific intent fails, open general battery optimization settings
                openBatteryOptimizationSettings()
            }
        }
    }
    
    /**
     * Open battery optimization settings page
     */
    fun openBatteryOptimizationSettings() {
        val intent = Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            // Fallback to general app settings if battery optimization settings not available
            openAppSettings()
        }
    }
    
    /**
     * Get battery optimization explanation
     */
    fun getBatteryOptimizationExplanation(): PermissionExplanation {
        return if (isBatteryOptimizationIgnored()) {
            PermissionExplanation(
                title = "Battery Optimization Disabled",
                message = "Background heartbeat service can run without interruption.",
                actionText = null,
                action = null
            )
        } else {
            PermissionExplanation(
                title = "Battery Optimization Required",
                message = "To ensure continuous attendance monitoring, please disable battery optimization for this app. This allows the heartbeat service to run reliably in the background.",
                actionText = "Disable Optimization",
                action = PermissionAction.REQUEST_BATTERY_EXEMPTION
            )
        }
    }
}

enum class PermissionResult {
    Granted,
    Denied,
    PermanentlyDenied,
    NotHandled
}

enum class PermissionAction {
    REQUEST_PERMISSION,
    OPEN_SETTINGS,
    OPEN_LOCATION_SETTINGS,
    REQUEST_BATTERY_EXEMPTION
}

data class PermissionExplanation(
    val title: String,
    val message: String,
    val actionText: String?,
    val action: PermissionAction?
)