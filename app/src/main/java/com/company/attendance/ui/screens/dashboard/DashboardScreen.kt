package com.company.attendance.ui.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.company.attendance.R
import com.company.attendance.ui.theme.EmployeeAttendanceTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*
import javax.inject.Inject

// Extension for warning container color
val ColorScheme.warningContainer: Color
    get() = Color(0xFFFFF3C4)

val ColorScheme.onWarningContainer: Color 
    get() = Color(0xFF3E2723)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val attendanceRepository: com.company.attendance.data.repository.AttendanceRepository,
    private val authRepository: com.company.attendance.data.repository.AuthRepository,
    private val wifiMonitoringService: com.company.attendance.service.WiFiMonitoringService,
    private val permissionHandler: com.company.attendance.utils.PermissionHandler,
    private val networkUtils: com.company.attendance.utils.NetworkUtils,
    private val workManagerService: com.company.attendance.service.WorkManagerService
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()
    
    private val _sessionState = MutableStateFlow(com.company.attendance.data.model.AttendanceSessionState())
    val sessionState: StateFlow<com.company.attendance.data.model.AttendanceSessionState> = _sessionState.asStateFlow()
    
    private val _attendanceResult = MutableStateFlow<com.company.attendance.data.model.AttendanceResult?>(null)
    val attendanceResult: StateFlow<com.company.attendance.data.model.AttendanceResult?> = _attendanceResult.asStateFlow()
    
    private val _isOffline = MutableStateFlow(false)
    val isOffline: StateFlow<Boolean> = _isOffline.asStateFlow()
    
    val queuedRequests = attendanceRepository.getQueuedRequests().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    
    val queueStatus = attendanceRepository.getQueueStatus().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = com.company.attendance.service.QueueStatus()
    )
    
    val wifiStatus = wifiMonitoringService.wifiStatus.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = com.company.attendance.data.model.WiFiStatus(false, null, null, false)
    )
    
    val permissionState = wifiMonitoringService.permissionState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = com.company.attendance.data.model.WiFiPermissionState.NotRequested
    )
    
    // Timer for session duration
    private var durationUpdateJob: Job? = null
    
    init {
        loadCurrentSession()
        startDurationTimer()
        startNetworkMonitoring()
        processQueuedRequests()
    }
    
    private fun loadCurrentSession() {
        viewModelScope.launch {
            try {
                val session = attendanceRepository.getCurrentSession()
                if (session != null) {
                    _sessionState.value = com.company.attendance.data.model.AttendanceSessionState(
                        isActive = session.outTime == null,
                        sessionId = session.id,
                        inTime = session.inTime,
                        lastHeartbeat = session.lastHeartbeat,
                        status = if (session.outTime == null) 
                            com.company.attendance.data.model.SessionStatus.ACTIVE 
                        else 
                            com.company.attendance.data.model.SessionStatus.COMPLETED
                    )
                    
                    updateUiState()
                }
            } catch (e: Exception) {
                _attendanceResult.value = com.company.attendance.data.model.AttendanceResult.Error(
                    e.message ?: "Failed to load session"
                )
            }
        }
    }
    
    private fun startDurationTimer() {
        durationUpdateJob = viewModelScope.launch {
            while (true) {
                updateSessionDuration()
                delay(60000) // Update every minute
            }
        }
    }
    
    private fun updateSessionDuration() {
        val session = _sessionState.value
        if (session.isActive && session.inTime != null) {
            val now = kotlinx.datetime.Clock.System.now()
            val inTime = kotlinx.datetime.Instant.parse("${session.inTime}Z")
            val duration = now - inTime
            
            val hours = duration.inWholeHours
            val minutes = (duration.inWholeMinutes % 60)
            
            _sessionState.value = session.copy(
                currentDuration = "${hours}h ${minutes}m"
            )
            
            updateUiState()
        }
    }
    
    private fun updateUiState() {
        val session = _sessionState.value
        val wifi = wifiStatus.value
        
        _uiState.value = _uiState.value.copy(
            isMarkedIn = session.isActive,
            currentStatus = when {
                session.isActive -> "Present"
                session.status == com.company.attendance.data.model.SessionStatus.COMPLETED -> "Completed"
                else -> "Not Marked"
            },
            todayHours = session.currentDuration,
            canMarkAttendance = wifi.isApproved && permissionState.value == com.company.attendance.data.model.WiFiPermissionState.Granted
        )
    }
    
    fun markIn() {
        viewModelScope.launch {
            _attendanceResult.value = com.company.attendance.data.model.AttendanceResult.Loading
            
            try {
                val result = attendanceRepository.markIn()
                result.onSuccess { session ->
                    _sessionState.value = com.company.attendance.data.model.AttendanceSessionState(
                        isActive = true,
                        sessionId = session.id,
                        inTime = session.inTime,
                        lastHeartbeat = session.lastHeartbeat,
                        status = com.company.attendance.data.model.SessionStatus.ACTIVE
                    )
                    
                    _attendanceResult.value = com.company.attendance.data.model.AttendanceResult.Success(
                        "Attendance marked successfully"
                    )
                    
                    // Start background heartbeat work
                    workManagerService.startHeartbeatWork()
                    
                    updateUiState()
                }.onFailure { error ->
                    handleAttendanceError(error)
                }
            } catch (e: Exception) {
                handleAttendanceError(e)
            }
        }
    }
    
    fun markOut() {
        viewModelScope.launch {
            _attendanceResult.value = com.company.attendance.data.model.AttendanceResult.Loading
            
            try {
                val result = attendanceRepository.markOut()
                result.onSuccess { session ->
                    _sessionState.value = _sessionState.value.copy(
                        isActive = false,
                        status = com.company.attendance.data.model.SessionStatus.COMPLETED
                    )
                    
                    _attendanceResult.value = com.company.attendance.data.model.AttendanceResult.Success(
                        "Attendance completed successfully"
                    )
                    
                    // Stop background heartbeat work
                    workManagerService.stopHeartbeatWork()
                    
                    updateUiState()
                }.onFailure { error ->
                    handleAttendanceError(error)
                }
            } catch (e: Exception) {
                handleAttendanceError(e)
            }
        }
    }
    
    private fun handleAttendanceError(error: Throwable) {
        val message = error.message ?: "Unknown error occurred"
        
        _attendanceResult.value = when {
            message.contains("wifi", ignoreCase = true) || 
            message.contains("network", ignoreCase = true) -> {
                com.company.attendance.data.model.AttendanceResult.WiFiNotApproved
            }
            message.contains("device", ignoreCase = true) -> {
                com.company.attendance.data.model.AttendanceResult.DeviceNotRegistered
            }
            message.contains("network", ignoreCase = true) -> {
                com.company.attendance.data.model.AttendanceResult.NetworkError
            }
            else -> {
                com.company.attendance.data.model.AttendanceResult.Error(message)
            }
        }
    }
    
    fun clearResult() {
        _attendanceResult.value = null
    }
    
    fun retryRequest(requestId: Long) {
        viewModelScope.launch {
            attendanceRepository.retryRequestManually(requestId)
        }
    }
    
    fun retryCriticalRequests() {
        viewModelScope.launch {
            attendanceRepository.retryCriticalRequests()
        }
    }
    
    fun clearFailedRequests() {
        viewModelScope.launch {
            attendanceRepository.clearFailedRequests()
        }
    }
    
    fun getButtonState(): com.company.attendance.data.model.AttendanceButtonState {
        val session = _sessionState.value
        val wifi = wifiStatus.value
        val permissions = permissionState.value
        val isLoading = _attendanceResult.value is com.company.attendance.data.model.AttendanceResult.Loading
        
        val canPerformAction = wifi.isApproved && 
                              permissions == com.company.attendance.data.model.WiFiPermissionState.Granted &&
                              !isLoading
        
        return if (session.isActive) {
            com.company.attendance.data.model.AttendanceButtonState(
                isEnabled = canPerformAction,
                text = if (isLoading) "Marking Out..." else "Mark OUT",
                action = com.company.attendance.data.model.AttendanceAction.MarkOut,
                loadingText = "Marking Out..."
            )
        } else {
            com.company.attendance.data.model.AttendanceButtonState(
                isEnabled = canPerformAction,
                text = if (isLoading) "Marking In..." else "Mark IN",
                action = com.company.attendance.data.model.AttendanceAction.MarkIn,
                loadingText = "Marking In..."
            )
        }
    }
    
    private fun startNetworkMonitoring() {
        viewModelScope.launch {
            while (true) {
                val isOffline = !networkUtils.isNetworkAvailable()
                _isOffline.value = isOffline
                
                if (!isOffline) {
                    // Process queued requests when back online
                    attendanceRepository.processQueuedRequests()
                }
                
                delay(30000) // Check every 30 seconds
            }
        }
    }
    
    private fun processQueuedRequests() {
        viewModelScope.launch {
            if (networkUtils.isNetworkAvailable()) {
                attendanceRepository.processQueuedRequests()
            }
        }
    }
    
    override fun onCleared() {
        super.onCleared()
        durationUpdateJob?.cancel()
    }
}

data class DashboardUiState(
    val isMarkedIn: Boolean = false,
    val currentStatus: String = "Not Marked",
    val todayHours: String = "0h 0m",
    val canMarkAttendance: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    onNavigateToHistory: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val sessionState by viewModel.sessionState.collectAsStateWithLifecycle()
    val attendanceResult by viewModel.attendanceResult.collectAsStateWithLifecycle()
    val wifiStatus by viewModel.wifiStatus.collectAsStateWithLifecycle()
    val permissionState by viewModel.permissionState.collectAsStateWithLifecycle()
    val queueStatus by viewModel.queueStatus.collectAsStateWithLifecycle()
    val queuedRequests by viewModel.queuedRequests.collectAsStateWithLifecycle()
    val isOffline by viewModel.isOffline.collectAsStateWithLifecycle()
    val buttonState = viewModel.getButtonState()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.dashboard_title)) },
                actions = {
                    IconButton(onClick = onNavigateToHistory) {
                        Icon(Icons.Default.History, contentDescription = "History")
                    }
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Wi-Fi Status Card
            com.company.attendance.ui.components.WiFiStatusCard(
                wifiStatus = wifiStatus,
                permissionState = permissionState,
                onPermissionClick = { /* TODO: Handle permission request */ },
                onSettingsClick = { /* TODO: Handle settings click */ }
            )
            
            // Queue Status Card
            com.company.attendance.ui.components.QueueStatusCard(
                queueStatus = queueStatus,
                queuedRequests = queuedRequests,
                isOffline = isOffline,
                onRetryRequest = viewModel::retryRequest,
                onRetryCritical = viewModel::retryCriticalRequests,
                onClearFailed = viewModel::clearFailedRequests
            )
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.current_status),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = uiState.currentStatus,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text(
                        text = stringResource(R.string.todays_hours),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Text(
                        text = uiState.todayHours,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            
            // Session Details Card
            if (sessionState.isActive) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Active Session",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        
                        sessionState.inTime?.let { inTime ->
                            Text(
                                text = "Started at: ${inTime.time}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                        
                        Text(
                            text = "Duration: ${sessionState.currentDuration}",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Attendance Result Message
            attendanceResult?.let { result ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = when (result) {
                            is com.company.attendance.data.model.AttendanceResult.Success -> MaterialTheme.colorScheme.primaryContainer
                            is com.company.attendance.data.model.AttendanceResult.Error -> MaterialTheme.colorScheme.errorContainer
                            is com.company.attendance.data.model.AttendanceResult.WiFiNotApproved -> MaterialTheme.colorScheme.warningContainer
                            is com.company.attendance.data.model.AttendanceResult.NetworkError -> MaterialTheme.colorScheme.errorContainer
                            is com.company.attendance.data.model.AttendanceResult.DeviceNotRegistered -> MaterialTheme.colorScheme.errorContainer
                            is com.company.attendance.data.model.AttendanceResult.Loading -> MaterialTheme.colorScheme.surfaceVariant
                        }
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = when (result) {
                                    is com.company.attendance.data.model.AttendanceResult.Success -> result.message
                                    is com.company.attendance.data.model.AttendanceResult.Error -> result.message
                                    is com.company.attendance.data.model.AttendanceResult.WiFiNotApproved -> "Please connect to approved office Wi-Fi"
                                    is com.company.attendance.data.model.AttendanceResult.NetworkError -> "Network error. Please try again."
                                    is com.company.attendance.data.model.AttendanceResult.DeviceNotRegistered -> "Device not registered. Please contact admin."
                                    is com.company.attendance.data.model.AttendanceResult.Loading -> "Processing..."
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                color = when (result) {
                                    is com.company.attendance.data.model.AttendanceResult.Success -> MaterialTheme.colorScheme.onPrimaryContainer
                                    else -> MaterialTheme.colorScheme.onErrorContainer
                                }
                            )
                        }
                        
                        if (result !is com.company.attendance.data.model.AttendanceResult.Loading) {
                            IconButton(onClick = { viewModel.clearResult() }) {
                                Icon(
                                    imageVector = androidx.compose.material.icons.Icons.Default.Close,
                                    contentDescription = "Dismiss",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            // Attendance Button
            Button(
                onClick = {
                    when (buttonState.action) {
                        is com.company.attendance.data.model.AttendanceAction.MarkIn -> viewModel.markIn()
                        is com.company.attendance.data.model.AttendanceAction.MarkOut -> viewModel.markOut()
                        else -> {}
                    }
                },
                enabled = buttonState.isEnabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (buttonState.action is com.company.attendance.data.model.AttendanceAction.MarkOut) {
                        MaterialTheme.colorScheme.secondary
                    } else {
                        MaterialTheme.colorScheme.primary
                    }
                )
            ) {
                if (attendanceResult is com.company.attendance.data.model.AttendanceResult.Loading) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(16.dp),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                        Text(
                            text = buttonState.loadingText,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                } else {
                    Text(
                        text = buttonState.text,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
            
            // Help Text for Disabled Button
            if (!buttonState.isEnabled && attendanceResult !is com.company.attendance.data.model.AttendanceResult.Loading) {
                Text(
                    text = when {
                        !wifiStatus.isConnected -> "Connect to Wi-Fi to mark attendance"
                        !wifiStatus.isApproved -> "Connect to approved office Wi-Fi"
                        permissionState != com.company.attendance.data.model.WiFiPermissionState.Granted -> "Grant location permission to verify Wi-Fi"
                        else -> "Please check your connection"
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    EmployeeAttendanceTheme {
        // Preview with mock
    }
}