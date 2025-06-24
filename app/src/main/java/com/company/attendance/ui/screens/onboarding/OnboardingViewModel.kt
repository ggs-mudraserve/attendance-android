package com.company.attendance.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.attendance.data.repository.AttendanceRepository
import com.company.attendance.data.repository.BankDetails
import com.company.attendance.utils.DeviceUtils
import com.company.attendance.utils.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val repository: AttendanceRepository,
    private val authRepository: com.company.attendance.data.repository.AuthRepository,
    private val deviceUtils: DeviceUtils,
    private val preferencesManager: PreferencesManager
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()
    
    init {
        loadDeviceInfo()
    }
    
    private fun loadDeviceInfo() {
        val deviceUuid = preferencesManager.deviceUuid 
            ?: deviceUtils.generateDeviceUuid().also { 
                preferencesManager.deviceUuid = it 
            }
        
        _uiState.value = _uiState.value.copy(
            deviceUuid = deviceUuid,
            appVersion = deviceUtils.getAppVersion()
        )
    }
    
    fun onAccountNumberChanged(accountNumber: String) {
        // Filter to only allow digits
        val filteredNumber = accountNumber.filter { it.isDigit() }
        
        _uiState.value = _uiState.value.copy(
            accountNumber = filteredNumber,
            accountNumberError = null
        )
        
        // Real-time validation feedback
        if (filteredNumber.isNotEmpty() && filteredNumber.length < 9) {
            _uiState.value = _uiState.value.copy(
                accountNumberError = "Must be at least 9 digits"
            )
        } else if (filteredNumber.length > 18) {
            _uiState.value = _uiState.value.copy(
                accountNumberError = "Cannot exceed 18 digits"
            )
        }
    }
    
    fun onIfscCodeChanged(ifscCode: String) {
        // Filter to only allow alphanumeric characters and convert to uppercase
        val filteredCode = ifscCode.filter { it.isLetterOrDigit() }.uppercase().take(11)
        
        _uiState.value = _uiState.value.copy(
            ifscCode = filteredCode,
            ifscCodeError = null
        )
        
        // Real-time validation feedback
        if (filteredCode.isNotEmpty()) {
            when {
                filteredCode.length < 11 -> {
                    _uiState.value = _uiState.value.copy(
                        ifscCodeError = "IFSC must be 11 characters (${11 - filteredCode.length} more needed)"
                    )
                }
                filteredCode.length == 11 -> {
                    val ifscPattern = "^[A-Z]{4}0[A-Z0-9]{6}$".toRegex()
                    if (!ifscPattern.matches(filteredCode)) {
                        _uiState.value = _uiState.value.copy(
                            ifscCodeError = "Invalid format. Should be like HDFC0001234"
                        )
                    }
                }
            }
        }
    }
    
    fun onBankNameChanged(bankName: String) {
        // Filter to only allow letters, spaces, and common punctuation, and limit length
        val filteredName = bankName.filter { it.isLetter() || it.isWhitespace() || it in ".,'-" }
            .take(50)
            .replace(Regex("\\s+"), " ") // Replace multiple spaces with single space
        
        _uiState.value = _uiState.value.copy(
            bankName = filteredName,
            bankNameError = null
        )
        
        // Real-time validation feedback
        if (filteredName.isNotEmpty() && filteredName.length < 2) {
            _uiState.value = _uiState.value.copy(
                bankNameError = "Bank name must be at least 2 characters"
            )
        }
    }
    
    fun onPermissionsGranted(granted: Boolean) {
        _uiState.value = _uiState.value.copy(
            permissionsGranted = granted,
            permissionError = if (!granted) "Location permission is required for Wi-Fi validation" else null
        )
    }
    
    fun completeOnboarding() {
        val currentState = _uiState.value
        
        if (!currentState.permissionsGranted) {
            _uiState.value = currentState.copy(
                permissionError = "Please grant location permission to continue"
            )
            return
        }
        
        // Validate bank details if provided
        val bankDetails = if (currentState.accountNumber.isNotBlank() ||
                            currentState.ifscCode.isNotBlank() ||
                            currentState.bankName.isNotBlank()) {
            
            val accountError = validateAccountNumber(currentState.accountNumber)
            val ifscError = validateIfscCode(currentState.ifscCode)
            val bankNameError = validateBankName(currentState.bankName)
            
            if (accountError != null || ifscError != null || bankNameError != null) {
                _uiState.value = currentState.copy(
                    accountNumberError = accountError,
                    ifscCodeError = ifscError,
                    bankNameError = bankNameError
                )
                return
            }
            
            BankDetails(
                accountNumber = currentState.accountNumber,
                ifscCode = currentState.ifscCode,
                bankName = currentState.bankName
            )
        } else {
            null
        }
        
        viewModelScope.launch {
            _uiState.value = currentState.copy(
                isLoading = true,
                error = null
            )
            
            repository.onboardDevice(bankDetails)
                .onSuccess { message ->
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        isCompleted = true
                    )
                }
                .onFailure { error ->
                    val errorMessage = when {
                        error.message?.contains("device already bound", ignoreCase = true) == true ||
                        error.message?.contains("device_id", ignoreCase = true) == true -> {
                            "This device is already registered to another employee. Please contact your administrator."
                        }
                        error.message?.contains("network", ignoreCase = true) == true -> {
                            "Network error. Please check your connection and try again."
                        }
                        error.message?.contains("unauthorized", ignoreCase = true) == true -> {
                            "Authentication expired. Please log in again."
                        }
                        else -> error.message ?: "Device registration failed. Please try again."
                    }
                    
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = errorMessage,
                        isDeviceAlreadyBound = error.message?.contains("device already bound", ignoreCase = true) == true
                    )
                }
        }
    }
    
    fun skipBankDetails() {
        val currentState = _uiState.value
        
        // Allow skipping to settings even without permissions for server configuration
        _uiState.value = currentState.copy(
            isLoading = false,
            isCompleted = true,
            error = null
        )
    }
    
    fun skipToSettings() {
        val currentState = _uiState.value
        
        // Mark as completed to proceed to settings
        _uiState.value = currentState.copy(
            isLoading = false,
            isCompleted = true,
            isSkippedToSettings = true,
            error = null
        )
    }
    
    private fun validateAccountNumber(accountNumber: String): String? {
        return when {
            accountNumber.isBlank() -> "Account number is required"
            accountNumber.length < 9 -> "Account number must be at least 9 digits"
            accountNumber.length > 18 -> "Account number cannot exceed 18 digits"
            !accountNumber.all { it.isDigit() } -> "Account number must contain only digits"
            else -> null
        }
    }
    
    private fun validateIfscCode(ifscCode: String): String? {
        val ifscPattern = "^[A-Z]{4}0[A-Z0-9]{6}$".toRegex()
        return when {
            ifscCode.isBlank() -> "IFSC code is required"
            ifscCode.length != 11 -> "IFSC code must be exactly 11 characters"
            !ifscPattern.matches(ifscCode) -> "Invalid IFSC code format (e.g., HDFC0001234)"
            else -> null
        }
    }
    
    private fun validateBankName(bankName: String): String? {
        return when {
            bankName.isBlank() -> "Bank name is required"
            bankName.length < 2 -> "Bank name must be at least 2 characters"
            bankName.length > 50 -> "Bank name cannot exceed 50 characters"
            !bankName.all { it.isLetter() || it.isWhitespace() } -> "Bank name can only contain letters and spaces"
            else -> null
        }
    }
    
    fun validateBankDetailsPartial(): Boolean {
        val state = _uiState.value
        val hasAnyBankField = state.accountNumber.isNotBlank() || 
                             state.ifscCode.isNotBlank() || 
                             state.bankName.isNotBlank()
        
        if (!hasAnyBankField) return true // All empty is valid
        
        // If any field is filled, all must be filled and valid
        val accountError = validateAccountNumber(state.accountNumber)
        val ifscError = validateIfscCode(state.ifscCode)
        val bankNameError = validateBankName(state.bankName)
        
        return accountError == null && ifscError == null && bankNameError == null
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}

data class OnboardingUiState(
    val accountNumber: String = "",
    val ifscCode: String = "",
    val bankName: String = "",
    val deviceUuid: String = "",
    val appVersion: String = "",
    val permissionsGranted: Boolean = false,
    val isLoading: Boolean = false,
    val isCompleted: Boolean = false,
    val isDeviceAlreadyBound: Boolean = false,
    val isSkippedToSettings: Boolean = false,
    val accountNumberError: String? = null,
    val ifscCodeError: String? = null,
    val bankNameError: String? = null,
    val permissionError: String? = null,
    val error: String? = null
)