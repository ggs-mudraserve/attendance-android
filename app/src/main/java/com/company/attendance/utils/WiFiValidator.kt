package com.company.attendance.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.wifi.WifiManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.company.attendance.data.model.WiFiPermissionState
import com.company.attendance.service.WiFiMonitoringService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WiFiValidator @Inject constructor(
    private val context: Context,
    private val wifiMonitoringService: WiFiMonitoringService
) {
    
    private val wifiManager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    
    fun isConnectedToWiFi(): Boolean {
        return wifiManager.isWifiEnabled && wifiManager.connectionInfo.networkId != -1
    }
    
    fun getCurrentBSSID(): String? {
        if (!isConnectedToWiFi()) return null
        
        val connectionInfo = wifiManager.connectionInfo
        return connectionInfo.bssid?.takeIf { it != "02:00:00:00:00:00" }
    }
    
    fun getCurrentSSID(): String? {
        if (!isConnectedToWiFi()) return null
        
        val connectionInfo = wifiManager.connectionInfo
        return connectionInfo.ssid?.removeSurrounding("\"")
    }
    
    @RequiresApi(Build.VERSION_CODES.S)
    fun getCurrentBSSIDSecure(): String? {
        return getCurrentBSSID()
    }
    
    fun isOnApprovedNetwork(approvedBSSIDs: Set<String>): Boolean {
        val currentBSSID = getCurrentBSSID()
        return currentBSSID != null && approvedBSSIDs.contains(currentBSSID.uppercase())
    }
    
    fun getWiFiInfo(): WiFiInfo {
        return WiFiInfo(
            isConnected = isConnectedToWiFi(),
            ssid = getCurrentSSID(),
            bssid = getCurrentBSSID()
        )
    }
    
    /**
     * Enhanced method that uses the monitoring service for validation
     */
    fun isOnApprovedNetworkEnhanced(): Boolean {
        val validation = wifiMonitoringService.getCurrentWiFiValidation()
        return validation.isValid
    }
    
    /**
     * Check all permission requirements for Wi-Fi validation
     */
    fun checkPermissions(): WiFiPermissionState {
        val hasLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        
        val hasWifiPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_WIFI_STATE
        ) == PackageManager.PERMISSION_GRANTED
        
        val isLocationEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        
        return when {
            !hasLocationPermission || !hasWifiPermission -> WiFiPermissionState.Denied
            !isLocationEnabled -> WiFiPermissionState.Denied
            else -> WiFiPermissionState.Granted
        }
    }
    
    /**
     * Get detailed validation result with reason
     */
    fun getValidationResult(): com.company.attendance.data.model.WiFiValidationResult {
        return wifiMonitoringService.getCurrentWiFiValidation()
    }
    
    /**
     * Check if location services are enabled
     */
    fun isLocationEnabled(): Boolean {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }
    
    /**
     * Get signal strength level (0-4)
     */
    fun getSignalStrength(): Int {
        if (!isConnectedToWiFi()) return 0
        val rssi = wifiManager.connectionInfo.rssi
        return WifiManager.calculateSignalLevel(rssi, 5)
    }
    
    /**
     * Get network frequency (for newer Android versions)
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getNetworkFrequency(): Int {
        if (!isConnectedToWiFi()) return 0
        return wifiManager.connectionInfo.frequency
    }
}

data class WiFiInfo(
    val isConnected: Boolean,
    val ssid: String?,
    val bssid: String?
)