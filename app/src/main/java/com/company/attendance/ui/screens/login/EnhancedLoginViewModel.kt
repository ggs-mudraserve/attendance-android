package com.company.attendance.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.attendance.data.model.*
import com.company.attendance.data.repository.AuthRepository
import com.company.attendance.data.repository.AttendanceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EnhancedLoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val attendanceRepository: AttendanceRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(EnhancedLoginUiState())
    val uiState: StateFlow<EnhancedLoginUiState> = _uiState.asStateFlow()
    
    // Observe auth state changes
    val authState = authRepository.authState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = AuthState.Loading
    )
    
    init {
        observeAuthState()
        checkExistingSession()
    }
    
    private fun observeAuthState() {
        viewModelScope.launch {
            authRepository.authState.collect { state ->
                when (state) {
                    is AuthState.Loading -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = true,
                            error = null
                        )
                    }
                    is AuthState.Authenticated -> {
                        // Check if user needs onboarding
                        val isOnboarded = attendanceRepository.isDeviceOnboarded()
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            isAuthenticated = true,
                            isFirstTime = !isOnboarded,
                            error = null,
                            user = state.user
                        )
                    }
                    is AuthState.Unauthenticated -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            isAuthenticated = false,
                            isFirstTime = false,
                            error = null,
                            user = null
                        )
                    }
                    is AuthState.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            isAuthenticated = false,
                            error = state.message
                        )
                    }
                }
            }
        }
    }
    
    private fun checkExistingSession() {
        viewModelScope.launch {
            try {
                val isValid = authRepository.isSessionValid()
                if (!isValid) {
                    // Try to refresh session
                    authRepository.refreshSession()
                }
            } catch (e: Exception) {
                // Session check failed, will be handled by auth state observer
            }
        }
    }
    
    fun onEmailChanged(email: String) {
        _uiState.value = _uiState.value.copy(
            email = email.trim(),
            emailError = null
        )
    }
    
    fun onPasswordChanged(password: String) {
        _uiState.value = _uiState.value.copy(
            password = password,
            passwordError = null
        )
    }
    
    fun signIn() {
        val currentState = _uiState.value
        
        // Validate inputs
        val emailError = validateEmail(currentState.email)
        val passwordError = validatePassword(currentState.password)
        
        if (emailError != null || passwordError != null) {
            _uiState.value = currentState.copy(
                emailError = emailError,
                passwordError = passwordError
            )
            return
        }
        
        viewModelScope.launch {
            _uiState.value = currentState.copy(
                isLoading = true,
                error = null
            )
            
            when (val result = authRepository.signIn(currentState.email, currentState.password)) {
                is AuthResult.Success -> {
                    // Success will be handled by auth state observer
                }
                is AuthResult.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
                is AuthResult.Loading -> {
                    // Already handled above
                }
            }
        }
    }
    
    fun resetPassword() {
        val email = _uiState.value.email
        if (email.isBlank()) {
            _uiState.value = _uiState.value.copy(
                emailError = "Enter your email address first"
            )
            return
        }
        
        viewModelScope.launch {
            when (val result = authRepository.resetPassword(email)) {
                is AuthResult.Success -> {
                    _uiState.value = _uiState.value.copy(
                        showResetPasswordSuccess = true
                    )
                }
                is AuthResult.Error -> {
                    _uiState.value = _uiState.value.copy(
                        error = result.message
                    )
                }
                is AuthResult.Loading -> {
                    // Handle loading if needed
                }
            }
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
    
    fun clearResetPasswordSuccess() {
        _uiState.value = _uiState.value.copy(showResetPasswordSuccess = false)
    }
    
    fun refreshSession() {
        viewModelScope.launch {
            authRepository.refreshSession()
        }
    }
    
    private fun validateEmail(email: String): String? {
        return when {
            email.isBlank() -> "Email is required"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid email format"
            else -> null
        }
    }
    
    private fun validatePassword(password: String): String? {
        return when {
            password.isBlank() -> "Password is required"
            password.length < 6 -> "Password must be at least 6 characters"
            else -> null
        }
    }
}

data class EnhancedLoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isAuthenticated: Boolean = false,
    val isFirstTime: Boolean = false,
    val user: AuthUser? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val error: String? = null,
    val showResetPasswordSuccess: Boolean = false
)