package com.company.attendance.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "approved_wifi_networks")
data class ApprovedWiFiNetwork(
    @PrimaryKey
    val bssid: String,
    val label: String?,
    val ssid: String?,
    @ColumnInfo(name = "last_validated")
    val lastValidated: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "is_active")
    val isActive: Boolean = true
) : Parcelable

@Parcelize
data class WiFiStatus(
    val isConnected: Boolean,
    val ssid: String?,
    val bssid: String?,
    val isApproved: Boolean,
    val signalStrength: Int = 0,
    val frequency: Int = 0,
    val lastChecked: Long = System.currentTimeMillis(),
    val reason: String? = null
) : Parcelable

data class WiFiValidationResult(
    val isValid: Boolean,
    val bssid: String?,
    val reason: String?,
    val approvedNetwork: ApprovedWiFiNetwork? = null
)

sealed class WiFiPermissionState {
    object Granted : WiFiPermissionState()
    object Denied : WiFiPermissionState()
    object PermanentlyDenied : WiFiPermissionState()
    object NotRequested : WiFiPermissionState()
}

data class WiFiNetworkScanResult(
    val bssid: String,
    val ssid: String?,
    val signalStrength: Int,
    val frequency: Int,
    val capabilities: String
)