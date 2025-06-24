package com.company.attendance.service

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import android.os.Build
import android.util.Log
import androidx.core.content.ContextCompat
import com.company.attendance.data.local.ApprovedWiFiDao
import com.company.attendance.data.model.*
// Removed AttendanceRepository to break circular dependency
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WiFiMonitoringService @Inject constructor(
    private val context: Context,
    private val approvedWiFiDao: ApprovedWiFiDao
) {
    companion object {
        private const val TAG = "WiFiMonitoringService"
        private const val SCAN_INTERVAL_MS = 30000L // 30 seconds
        private const val VALIDATION_CACHE_DURATION = 5 * 60 * 1000L // 5 minutes
    }
    
    private val wifiManager: WifiManager? = try {
        context.applicationContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
    } catch (e: Exception) {
        Log.e(TAG, "Failed to get WifiManager", e)
        null
    }
    
    private val locationManager: LocationManager? = try {
        context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager
    } catch (e: Exception) {
        Log.e(TAG, "Failed to get LocationManager", e)
        null
    }
    
    private val _wifiStatus = MutableStateFlow(WiFiStatus(false, null, null, false))
    val wifiStatus: StateFlow<WiFiStatus> = _wifiStatus.asStateFlow()
    
    private val _permissionState = MutableStateFlow<WiFiPermissionState>(WiFiPermissionState.NotRequested)
    val permissionState: StateFlow<WiFiPermissionState> = _permissionState.asStateFlow()
    
    private val _approvedNetworks = MutableStateFlow<List<ApprovedWiFiNetwork>>(emptyList())
    val approvedNetworks: StateFlow<List<ApprovedWiFiNetwork>> = _approvedNetworks.asStateFlow()
    
    private var monitoringJob: Job? = null
    private var networkReceiver: BroadcastReceiver? = null
    private val serviceScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    
    private var lastServerSync = 0L
    private var cachedApprovedBSSIDs = setOf<String>()
    
    fun startMonitoring() {
        if (monitoringJob?.isActive == true) return
        
        if (wifiManager == null) {
            Log.e(TAG, "Cannot start monitoring - WifiManager is null")
            return
        }
        
        Log.i(TAG, "Starting Wi-Fi monitoring service")
        
        monitoringJob = serviceScope.launch {
            // Load cached approved networks
            loadApprovedNetworks()
            
            // Start periodic monitoring
            while (isActive) {
                try {
                    updateWiFiStatus()
                    syncWithServerIfNeeded()
                } catch (e: Exception) {
                    Log.e(TAG, "Error in monitoring loop", e)
                }
                delay(SCAN_INTERVAL_MS)
            }
        }
        
        registerNetworkReceiver()
        checkPermissions()
    }
    
    fun stopMonitoring() {
        Log.i(TAG, "Stopping Wi-Fi monitoring service")
        monitoringJob?.cancel()
        unregisterNetworkReceiver()
    }
    
    private suspend fun updateWiFiStatus() {
        val hasPermissions = checkPermissions()
        
        if (!hasPermissions) {
            _wifiStatus.value = WiFiStatus(false, null, null, false, reason = "Location permission required")
            return
        }
        
        if (wifiManager?.isWifiEnabled != true) {
            _wifiStatus.value = WiFiStatus(false, null, null, false, reason = "Wi-Fi is disabled or unavailable")
            return
        }
        
        val connectionInfo = wifiManager.connectionInfo
        val isConnected = connectionInfo.networkId != -1
        
        if (!isConnected) {
            _wifiStatus.value = WiFiStatus(false, null, null, false, reason = "Not connected to Wi-Fi")
            return
        }
        
        val bssid = connectionInfo.bssid?.takeIf { it != "02:00:00:00:00:00" }
        val ssid = connectionInfo.ssid?.removeSurrounding("\"")
        val signalStrength = WifiManager.calculateSignalLevel(connectionInfo.rssi, 5)
        val frequency = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectionInfo.frequency
        } else 0
        
        // Check if network is approved
        val isApproved = bssid?.let { validateBSSID(it) } ?: false
        val reason = if (!isApproved) "Network not approved for attendance" else null
        
        _wifiStatus.value = WiFiStatus(
            isConnected = isConnected,
            ssid = ssid,
            bssid = bssid,
            isApproved = isApproved,
            signalStrength = signalStrength,
            frequency = frequency,
            reason = reason
        )
        
        Log.d(TAG, "Wi-Fi status updated: SSID=$ssid, BSSID=$bssid, Approved=$isApproved")
    }
    
    private suspend fun validateBSSID(bssid: String): Boolean {
        // First check local cache
        if (cachedApprovedBSSIDs.contains(bssid.uppercase())) {
            // Update last validated timestamp
            approvedWiFiDao.updateLastValidated(bssid.uppercase())
            return true
        }
        
        // Check database
        val approvedNetwork = approvedWiFiDao.getNetworkByBSSID(bssid.uppercase())
        if (approvedNetwork != null) {
            cachedApprovedBSSIDs = cachedApprovedBSSIDs + bssid.uppercase()
            approvedWiFiDao.updateLastValidated(bssid.uppercase())
            return true
        }
        
        return false
    }
    
    private suspend fun loadApprovedNetworks() {
        try {
            val networks = approvedWiFiDao.getAllApprovedNetworksSync()
            _approvedNetworks.value = networks
            cachedApprovedBSSIDs = networks.map { it.bssid.uppercase() }.toSet()
            Log.i(TAG, "Loaded ${networks.size} approved networks from cache")
        } catch (e: Exception) {
            Log.e(TAG, "Error loading approved networks", e)
        }
    }
    
    private suspend fun syncWithServerIfNeeded() {
        val now = System.currentTimeMillis()
        if (now - lastServerSync < VALIDATION_CACHE_DURATION) return
        
        try {
            // This would call the server API to get updated wifi_allowed table
            // For now, we'll implement this as a placeholder
            syncApprovedNetworksFromServer()
            lastServerSync = now
        } catch (e: Exception) {
            Log.e(TAG, "Error syncing with server", e)
        }
    }
    
    private suspend fun syncApprovedNetworksFromServer() {
        try {
            // TODO: Implement API call to fetch wifi_allowed table
            // val response = attendanceRepository.getApprovedWiFiNetworks()
            // For now, this is a placeholder that would be implemented
            // when the server API endpoints are available
            
            Log.d(TAG, "Server sync placeholder - would fetch wifi_allowed table")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to sync approved networks from server", e)
        }
    }
    
    private fun checkPermissions(): Boolean {
        val hasLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        
        val isLocationEnabled = locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) == true ||
                locationManager?.isProviderEnabled(LocationManager.NETWORK_PROVIDER) == true
        
        val permissionState = when {
            !hasLocationPermission -> WiFiPermissionState.Denied
            !isLocationEnabled -> WiFiPermissionState.Denied
            else -> WiFiPermissionState.Granted
        }
        
        _permissionState.value = permissionState
        return permissionState == WiFiPermissionState.Granted
    }
    
    private fun registerNetworkReceiver() {
        if (networkReceiver != null) return
        
        networkReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when (intent?.action) {
                    WifiManager.NETWORK_STATE_CHANGED_ACTION,
                    WifiManager.WIFI_STATE_CHANGED_ACTION -> {
                        serviceScope.launch {
                            delay(1000) // Small delay to ensure connection info is updated
                            updateWiFiStatus()
                        }
                    }
                }
            }
        }
        
        val filter = IntentFilter().apply {
            addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
            addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        }
        
        context.registerReceiver(networkReceiver, filter)
        Log.d(TAG, "Network receiver registered")
    }
    
    private fun unregisterNetworkReceiver() {
        networkReceiver?.let {
            try {
                context.unregisterReceiver(it)
                networkReceiver = null
                Log.d(TAG, "Network receiver unregistered")
            } catch (e: Exception) {
                Log.e(TAG, "Error unregistering network receiver", e)
            }
        }
    }
    
    suspend fun addApprovedNetwork(bssid: String, label: String?, ssid: String?): Boolean {
        return try {
            val network = ApprovedWiFiNetwork(
                bssid = bssid.uppercase(),
                label = label,
                ssid = ssid,
                lastValidated = System.currentTimeMillis()
            )
            
            approvedWiFiDao.insertNetwork(network)
            cachedApprovedBSSIDs = cachedApprovedBSSIDs + bssid.uppercase()
            
            // Update networks list
            loadApprovedNetworks()
            
            Log.i(TAG, "Added approved network: $bssid")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Error adding approved network", e)
            false
        }
    }
    
    suspend fun removeApprovedNetwork(bssid: String): Boolean {
        return try {
            approvedWiFiDao.deleteNetworkByBSSID(bssid.uppercase())
            cachedApprovedBSSIDs = cachedApprovedBSSIDs - bssid.uppercase()
            
            // Update networks list
            loadApprovedNetworks()
            
            Log.i(TAG, "Removed approved network: $bssid")
            true
        } catch (e: Exception) {
            Log.e(TAG, "Error removing approved network", e)
            false
        }
    }
    
    fun getCurrentWiFiValidation(): WiFiValidationResult {
        val status = _wifiStatus.value
        
        return WiFiValidationResult(
            isValid = status.isApproved,
            bssid = status.bssid,
            reason = status.reason,
            approvedNetwork = status.bssid?.let { bssid ->
                _approvedNetworks.value.find { it.bssid.equals(bssid, ignoreCase = true) }
            }
        )
    }
    
    fun cleanup() {
        stopMonitoring()
        serviceScope.cancel()
    }
}