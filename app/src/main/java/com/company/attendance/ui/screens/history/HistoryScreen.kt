package com.company.attendance.ui.screens.history

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.company.attendance.R
import com.company.attendance.data.model.AttendanceRecord
import com.company.attendance.data.model.AttendanceStatus
import com.company.attendance.data.repository.AttendanceRepository
import com.company.attendance.data.repository.AttendanceSummary
import com.company.attendance.ui.theme.EmployeeAttendanceTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val attendanceRepository: AttendanceRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HistoryUiState())
    val uiState: StateFlow<HistoryUiState> = _uiState.asStateFlow()
    
    private val currentDate = LocalDate(2024, 6, 23) // Current date
    
    init {
        loadCurrentMonth()
    }
    
    private fun loadCurrentMonth() {
        _uiState.value = _uiState.value.copy(
            selectedYear = currentDate.year,
            selectedMonth = currentDate.monthNumber
        )
        loadAttendanceData()
    }
    
    fun selectMonth(year: Int, month: Int) {
        _uiState.value = _uiState.value.copy(
            selectedYear = year,
            selectedMonth = month,
            isLoading = true
        )
        loadAttendanceData()
    }
    
    fun refreshData() {
        _uiState.value = _uiState.value.copy(isRefreshing = true)
        loadAttendanceData(forceRefresh = true)
    }
    
    fun showDayDetails(record: AttendanceRecord) {
        _uiState.value = _uiState.value.copy(selectedDayRecord = record)
    }
    
    fun hideDayDetails() {
        _uiState.value = _uiState.value.copy(selectedDayRecord = null)
    }
    
    private fun loadAttendanceData(forceRefresh: Boolean = false) {
        val year = _uiState.value.selectedYear
        val month = _uiState.value.selectedMonth
        
        viewModelScope.launch {
            try {
                // Load attendance records
                val attendanceResult = attendanceRepository.getMonthlyAttendance(year, month)
                val summaryResult = attendanceRepository.getAttendanceSummary(year, month)
                
                if (attendanceResult.isSuccess && summaryResult.isSuccess) {
                    _uiState.value = _uiState.value.copy(
                        attendanceRecords = attendanceResult.getOrDefault(emptyList()),
                        summary = summaryResult.getOrNull(),
                        isLoading = false,
                        isRefreshing = false,
                        error = null
                    )
                } else {
                    val error = attendanceResult.exceptionOrNull()?.message 
                        ?: summaryResult.exceptionOrNull()?.message 
                        ?: "Failed to load attendance data"
                    
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        isRefreshing = false,
                        error = error
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isRefreshing = false,
                    error = e.message ?: "Unknown error occurred"
                )
            }
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
    
    fun getMonthName(month: Int): String {
        val monthNames = arrayOf(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        )
        return monthNames[month - 1]
    }
}

data class HistoryUiState(
    val selectedYear: Int = 2024,
    val selectedMonth: Int = 6,
    val attendanceRecords: List<AttendanceRecord> = emptyList(),
    val summary: AttendanceSummary? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String? = null,
    val selectedDayRecord: AttendanceRecord? = null,
    val showMonthPicker: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    viewModel: HistoryViewModel,
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    
    // Show error dialog
    uiState.error?.let { error ->
        AlertDialog(
            onDismissRequest = { viewModel.clearError() },
            title = { Text("Error") },
            text = { Text(error) },
            confirmButton = {
                TextButton(onClick = { viewModel.clearError() }) {
                    Text("OK")
                }
            }
        )
    }
    
    // Show day details dialog
    uiState.selectedDayRecord?.let { record ->
        DayDetailsDialog(
            record = record,
            onDismiss = { viewModel.hideDayDetails() }
        )
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.history_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.refreshData() }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                // Month Selector
                item {
                    MonthSelectorCard(
                        selectedYear = uiState.selectedYear,
                        selectedMonth = uiState.selectedMonth,
                        onMonthSelected = viewModel::selectMonth,
                        getMonthName = viewModel::getMonthName
                    )
                }
                
                // Summary Card
                item {
                    uiState.summary?.let { summary ->
                        SummaryCard(summary = summary)
                    }
                }
                
                // Attendance List
                if (uiState.attendanceRecords.isNotEmpty()) {
                    items(uiState.attendanceRecords) { record ->
                        AttendanceRecordItem(
                            record = record,
                            onClick = { viewModel.showDayDetails(record) }
                        )
                    }
                } else if (!uiState.isLoading) {
                    item {
                        EmptyStateCard()
                    }
                }
            }
            
            // Loading indicator
            if (uiState.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            
            // Pull to refresh indicator
            if (uiState.isRefreshing) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun MonthSelectorCard(
    selectedYear: Int,
    selectedMonth: Int,
    onMonthSelected: (Int, Int) -> Unit,
    getMonthName: (Int) -> String,
    modifier: Modifier = Modifier
) {
    var showPicker by remember { mutableStateOf(false) }
    
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showPicker = true }
                .padding(16.dp)
        ) {
            Text(
                text = "Selected Month",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${getMonthName(selectedMonth)} $selectedYear",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Select month",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
    
    if (showPicker) {
        MonthYearPickerDialog(
            selectedYear = selectedYear,
            selectedMonth = selectedMonth,
            onDismiss = { showPicker = false },
            onSelected = { year, month ->
                onMonthSelected(year, month)
                showPicker = false
            },
            getMonthName = getMonthName
        )
    }
}

@Composable
private fun SummaryCard(
    summary: AttendanceSummary,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Monthly Summary",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Attendance percentage
            Text(
                text = "${summary.attendancePercentage.toInt()}%",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                color = when {
                    summary.attendancePercentage >= 90 -> Color(0xFF4CAF50)
                    summary.attendancePercentage >= 75 -> Color(0xFFFF9800)
                    else -> Color(0xFFF44336)
                },
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            
            Text(
                text = "Attendance Rate",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Summary stats grid
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SummaryStatItem(
                    label = "Present",
                    count = summary.presentDays,
                    color = Color(0xFF4CAF50)
                )
                SummaryStatItem(
                    label = "Late",
                    count = summary.lateDays,
                    color = Color(0xFFFF9800)
                )
                SummaryStatItem(
                    label = "Half Day",
                    count = summary.halfDays,
                    color = Color(0xFF2196F3)
                )
                SummaryStatItem(
                    label = "Absent",
                    count = summary.absentDays,
                    color = Color(0xFFF44336)
                )
            }
        }
    }
}

@Composable
private fun SummaryStatItem(
    label: String,
    count: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = color
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun AttendanceRecordItem(
    record: AttendanceRecord,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dateFormat = remember { SimpleDateFormat("MMM dd, EEE", Locale.getDefault()) }
    val timeFormat = remember { SimpleDateFormat("HH:mm", Locale.getDefault()) }
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
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
                    text = dateFormat.format(Date(record.attendanceDate.toEpochDays() * 24L * 60L * 60L * 1000L)),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium
                )
                
                if (record.inTime != null || record.outTime != null) {
                    val timeText = buildString {
                        if (record.inTime != null) {
                            append("In: ${record.inTime.time}")
                        }
                        if (record.outTime != null) {
                            if (isNotEmpty()) append(" • ")
                            append("Out: ${record.outTime.time}")
                        }
                    }
                    
                    Text(
                        text = timeText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                Text(
                    text = "${record.totalMinutes / 60}h ${record.totalMinutes % 60}m",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            StatusChip(status = record.status)
        }
    }
}

@Composable
private fun StatusChip(
    status: AttendanceStatus,
    modifier: Modifier = Modifier
) {
    val (text, color) = when (status) {
        AttendanceStatus.PRESENT -> "Present" to Color(0xFF4CAF50)
        AttendanceStatus.LATE -> "Late" to Color(0xFFFF9800)
        AttendanceStatus.HALF_DAY -> "Half Day" to Color(0xFF2196F3)
        AttendanceStatus.ABSENT -> "Absent" to Color(0xFFF44336)
        AttendanceStatus.HOLIDAY -> "Holiday" to Color(0xFF9C27B0)
    }
    
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        color = color.copy(alpha = 0.1f)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = color,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
private fun EmptyStateCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.EventNote,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "No attendance records found",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            
            Text(
                text = "Attendance data will appear here once available",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun MonthYearPickerDialog(
    selectedYear: Int,
    selectedMonth: Int,
    onDismiss: () -> Unit,
    onSelected: (Int, Int) -> Unit,
    getMonthName: (Int) -> String
) {
    val currentYear = 2024
    val years = (currentYear - 2..currentYear).toList()
    val months = (1..12).toList()
    
    var tempYear by remember { mutableStateOf(selectedYear) }
    var tempMonth by remember { mutableStateOf(selectedMonth) }
    
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Select Month",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Year selector
                Text(
                    text = "Year",
                    style = MaterialTheme.typography.titleMedium
                )
                
                LazyColumn(
                    modifier = Modifier.height(120.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(years) { year ->
                        TextButton(
                            onClick = { tempYear = year },
                            colors = ButtonDefaults.textButtonColors(
                                contentColor = if (year == tempYear) 
                                    MaterialTheme.colorScheme.primary 
                                else MaterialTheme.colorScheme.onSurface
                            )
                        ) {
                            Text(
                                text = year.toString(),
                                fontWeight = if (year == tempYear) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Month selector
                Text(
                    text = "Month",
                    style = MaterialTheme.typography.titleMedium
                )
                
                LazyColumn(
                    modifier = Modifier.height(200.dp)
                ) {
                    items(months) { month ->
                        TextButton(
                            onClick = { tempMonth = month },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.textButtonColors(
                                contentColor = if (month == tempMonth) 
                                    MaterialTheme.colorScheme.primary 
                                else MaterialTheme.colorScheme.onSurface
                            )
                        ) {
                            Text(
                                text = getMonthName(month),
                                fontWeight = if (month == tempMonth) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    Button(onClick = { onSelected(tempYear, tempMonth) }) {
                        Text("OK")
                    }
                }
            }
        }
    }
}

@Composable
private fun DayDetailsDialog(
    record: AttendanceRecord,
    onDismiss: () -> Unit
) {
    val dateFormat = remember { SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.getDefault()) }
    
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Day Details",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = dateFormat.format(Date(record.attendanceDate.toEpochDays() * 24L * 60L * 60L * 1000L)),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Status
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Status:",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                    StatusChip(status = record.status)
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Times
                if (record.inTime != null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Check In:",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = record.inTime.time.toString(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(8.dp))
                }
                
                if (record.outTime != null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Check Out:",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = record.outTime.time.toString(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(8.dp))
                }
                
                // Total hours
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total Hours:",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "${record.totalMinutes / 60}h ${record.totalMinutes % 60}m",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Close")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    EmployeeAttendanceTheme {
        // Preview with mock
    }
}