package com.company.attendance.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.company.attendance.data.model.WiFiPermissionState
import com.company.attendance.data.model.WiFiStatus

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun WiFiStatusCard(
    wifiStatus: WiFiStatus,
    permissionState: WiFiPermissionState,
    onPermissionClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = when {
                permissionState != WiFiPermissionState.Granted -> MaterialTheme.colorScheme.errorContainer
                wifiStatus.isApproved -> MaterialTheme.colorScheme.primaryContainer
                wifiStatus.isConnected -> MaterialTheme.colorScheme.tertiaryContainer
                else -> MaterialTheme.colorScheme.surfaceVariant
            }
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = when {
                            permissionState != WiFiPermissionState.Granted -> Icons.Default.LocationOff
                            wifiStatus.isApproved -> Icons.Default.Wifi
                            wifiStatus.isConnected -> Icons.Default.WifiTethering
                            else -> Icons.Default.WifiOff
                        },
                        contentDescription = null,
                        tint = when {
                            permissionState != WiFiPermissionState.Granted -> MaterialTheme.colorScheme.onErrorContainer
                            wifiStatus.isApproved -> MaterialTheme.colorScheme.onPrimaryContainer
                            wifiStatus.isConnected -> MaterialTheme.colorScheme.onTertiaryContainer
                            else -> MaterialTheme.colorScheme.onSurfaceVariant
                        }
                    )
                    
                    Text(
                        text = "Wi-Fi Status",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )
                }
                
                // Signal Strength Indicator
                if (wifiStatus.isConnected && wifiStatus.signalStrength > 0) {
                    WiFiSignalIndicator(
                        strength = wifiStatus.signalStrength,
                        maxStrength = 4
                    )
                }
            }
            
            // Status Information
            AnimatedContent(
                targetState = Triple(permissionState, wifiStatus.isConnected, wifiStatus.isApproved),
                transitionSpec = { fadeIn() with fadeOut() }
            ) { (permission, connected, approved) ->
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    when {
                        permission != WiFiPermissionState.Granted -> {
                            PermissionRequiredContent(
                                permissionState = permission,
                                onPermissionClick = onPermissionClick,
                                onSettingsClick = onSettingsClick
                            )
                        }
                        !connected -> {
                            NotConnectedContent()
                        }
                        approved -> {
                            ApprovedNetworkContent(wifiStatus = wifiStatus)
                        }
                        else -> {
                            UnapprovedNetworkContent(wifiStatus = wifiStatus)
                        }
                    }
                }
            }
            
            // Network Details (if connected)
            if (wifiStatus.isConnected && permissionState == WiFiPermissionState.Granted) {
                NetworkDetailsSection(wifiStatus = wifiStatus)
            }
        }
    }
}

@Composable
private fun PermissionRequiredContent(
    permissionState: WiFiPermissionState,
    onPermissionClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = when (permissionState) {
                WiFiPermissionState.Denied -> "Location Permission Required"
                WiFiPermissionState.PermanentlyDenied -> "Permission Blocked"
                else -> "Setup Required"
            },
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onErrorContainer
        )
        
        Text(
            text = when (permissionState) {
                WiFiPermissionState.Denied -> "Location access is needed to detect office Wi-Fi networks for attendance validation."
                WiFiPermissionState.PermanentlyDenied -> "Please enable location permission in app settings to use attendance features."
                else -> "We need location permission to validate your presence at the office."
            },
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onErrorContainer
        )
        
        val (buttonText, onClick) = when (permissionState) {
            WiFiPermissionState.PermanentlyDenied -> "Open Settings" to onSettingsClick
            else -> "Grant Permission" to onPermissionClick
        }
        
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onError
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(buttonText)
        }
    }
}

@Composable
private fun NotConnectedContent() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = "Not Connected to Wi-Fi",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Medium
        )
        
        Text(
            text = "Please connect to office Wi-Fi to mark attendance.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ApprovedNetworkContent(wifiStatus: WiFiStatus) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(20.dp)
            )
            
            Text(
                text = "Connected to Approved Network",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        
        Text(
            text = "You can mark attendance from this network.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
private fun UnapprovedNetworkContent(wifiStatus: WiFiStatus) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier.size(20.dp)
            )
            
            Text(
                text = "Unapproved Network",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }
        
        Text(
            text = wifiStatus.reason ?: "This network is not approved for attendance marking.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onTertiaryContainer
        )
    }
}

@Composable
private fun NetworkDetailsSection(wifiStatus: WiFiStatus) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Divider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
        
        Text(
            text = "Network Details",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        wifiStatus.ssid?.let { ssid ->
            DetailRow(label = "Network", value = ssid)
        }
        
        wifiStatus.bssid?.let { bssid ->
            DetailRow(label = "BSSID", value = bssid.take(17)) // Show first 17 chars
        }
        
        if (wifiStatus.frequency > 0) {
            DetailRow(label = "Frequency", value = "${wifiStatus.frequency} MHz")
        }
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun WiFiSignalIndicator(
    strength: Int,
    maxStrength: Int
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        repeat(maxStrength) { index ->
            Box(
                modifier = Modifier
                    .width(3.dp)
                    .height((4 + index * 2).dp)
            ) {
                Divider(
                    color = if (index < strength) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                    },
                    thickness = 3.dp
                )
            }
        }
    }
}