package com.company.attendance.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.company.attendance.data.model.QueuedRequest
import com.company.attendance.service.QueueStatus
import java.text.SimpleDateFormat
import java.util.*

// Extension for warning container color
val ColorScheme.warningContainer: Color
    get() = Color(0xFFFFF3C4)

val ColorScheme.onWarningContainer: Color 
    get() = Color(0xFF3E2723)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QueueStatusCard(
    queueStatus: QueueStatus,
    queuedRequests: List<QueuedRequest>,
    isOffline: Boolean,
    onRetryRequest: (Long) -> Unit,
    onRetryCritical: () -> Unit,
    onClearFailed: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    
    // Only show if there are queued requests or offline
    if (queueStatus.totalRequests == 0 && !isOffline) return
    
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = when {
                queueStatus.criticalRequests > 0 -> MaterialTheme.colorScheme.errorContainer
                queueStatus.failedRequests > 0 -> MaterialTheme.colorScheme.warningContainer
                queueStatus.pendingRequests > 0 -> MaterialTheme.colorScheme.primaryContainer
                else -> MaterialTheme.colorScheme.surfaceVariant
            }
        )
    ) {
        Column(
            modifier = Modifier
                .animateContentSize()
                .padding(16.dp)
        ) {
            // Header
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
                            isOffline -> Icons.Default.CloudOff
                            queueStatus.criticalRequests > 0 -> Icons.Default.Error
                            queueStatus.failedRequests > 0 -> Icons.Default.Warning
                            queueStatus.pendingRequests > 0 -> Icons.Default.CloudQueue
                            else -> Icons.Default.CloudDone
                        },
                        contentDescription = null,
                        tint = when {
                            queueStatus.criticalRequests > 0 -> MaterialTheme.colorScheme.onErrorContainer
                            queueStatus.failedRequests > 0 -> MaterialTheme.colorScheme.onWarningContainer
                            else -> MaterialTheme.colorScheme.onPrimaryContainer
                        }
                    )
                    
                    Column {
                        Text(
                            text = when {
                                isOffline -> "Offline Mode"
                                queueStatus.criticalRequests > 0 -> "Critical Requests Pending"
                                queueStatus.failedRequests > 0 -> "Some Requests Failed"
                                queueStatus.pendingRequests > 0 -> "Requests Queued"
                                else -> "All Requests Synced"
                            },
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Medium
                        )
                        
                        if (queueStatus.totalRequests > 0) {
                            Text(
                                text = "${queueStatus.pendingRequests} pending, ${queueStatus.failedRequests} failed",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
                
                IconButton(onClick = { isExpanded = !isExpanded }) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = if (isExpanded) "Collapse" else "Expand"
                    )
                }
            }
            
            // Status indicators
            if (queueStatus.totalRequests > 0) {
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    if (queueStatus.criticalRequests > 0) {
                        StatusChip(
                            label = "Critical",
                            count = queueStatus.criticalRequests,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    
                    if (queueStatus.pendingRequests > 0) {
                        StatusChip(
                            label = "Pending",
                            count = queueStatus.pendingRequests,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    
                    if (queueStatus.failedRequests > 0) {
                        StatusChip(
                            label = "Failed",
                            count = queueStatus.failedRequests,
                            color = MaterialTheme.colorScheme.onWarningContainer
                        )
                    }
                }
            }
            
            // Expanded content
            if (isExpanded) {
                Spacer(modifier = Modifier.height(16.dp))
                
                // Action buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (queueStatus.criticalRequests > 0) {
                        OutlinedButton(
                            onClick = onRetryCritical,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Retry Critical")
                        }
                    }
                    
                    if (queueStatus.failedRequests > 0) {
                        OutlinedButton(
                            onClick = onClearFailed,
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = MaterialTheme.colorScheme.error
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Clear Failed")
                        }
                    }
                }
                
                // Request list
                if (queuedRequests.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text(
                        text = "Queued Requests",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Medium
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.heightIn(max = 200.dp)
                    ) {
                        items(queuedRequests.take(10)) { request ->
                            QueuedRequestItem(
                                request = request,
                                onRetry = { onRetryRequest(request.id) }
                            )
                        }
                        
                        if (queuedRequests.size > 10) {
                            item {
                                Text(
                                    text = "... and ${queuedRequests.size - 10} more",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StatusChip(
    label: String,
    count: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        color = color.copy(alpha = 0.1f)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = color
            )
            Text(
                text = count.toString(),
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }
    }
}

@Composable
private fun QueuedRequestItem(
    request: QueuedRequest,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dateFormat = remember { SimpleDateFormat("HH:mm:ss", Locale.getDefault()) }
    
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = request.endpoint.uppercase(),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = when (request.endpoint) {
                            "in", "out" -> MaterialTheme.colorScheme.error
                            "onboard" -> MaterialTheme.colorScheme.primary
                            else -> MaterialTheme.colorScheme.onSurface
                        }
                    )
                    
                    if (request.retryCount > 0) {
                        Surface(
                            shape = MaterialTheme.shapes.extraSmall,
                            color = MaterialTheme.colorScheme.errorContainer
                        ) {
                            Text(
                                text = "Retry ${request.retryCount}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onErrorContainer,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
                
                Text(
                    text = dateFormat.format(Date(request.timestamp)),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            if (request.retryCount < 3) {
                IconButton(onClick = onRetry) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Retry",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}