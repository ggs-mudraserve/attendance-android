package com.company.attendance.ui.screens.login;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0012J\u0006\u0010\u001c\u001a\u00020\u0012J\u0006\u0010\u001d\u001a\u00020\u0012J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006 "}, d2 = {"Lcom/company/attendance/ui/screens/login/EnhancedLoginViewModel;", "Landroidx/lifecycle/ViewModel;", "authRepository", "Lcom/company/attendance/data/repository/AuthRepository;", "attendanceRepository", "Lcom/company/attendance/data/repository/AttendanceRepository;", "(Lcom/company/attendance/data/repository/AuthRepository;Lcom/company/attendance/data/repository/AttendanceRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/attendance/ui/screens/login/EnhancedLoginUiState;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/company/attendance/data/model/AuthState;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "checkExistingSession", "", "clearError", "clearResetPasswordSuccess", "observeAuthState", "onEmailChanged", "email", "", "onPasswordChanged", "password", "refreshSession", "resetPassword", "signIn", "validateEmail", "validatePassword", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class EnhancedLoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AttendanceRepository attendanceRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.ui.screens.login.EnhancedLoginUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.login.EnhancedLoginUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.AuthState> authState = null;
    
    @javax.inject.Inject()
    public EnhancedLoginViewModel(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AttendanceRepository attendanceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.login.EnhancedLoginUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.AuthState> getAuthState() {
        return null;
    }
    
    private final void observeAuthState() {
    }
    
    private final void checkExistingSession() {
    }
    
    public final void onEmailChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void onPasswordChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public final void signIn() {
    }
    
    public final void resetPassword() {
    }
    
    public final void clearError() {
    }
    
    public final void clearResetPasswordSuccess() {
    }
    
    public final void refreshSession() {
    }
    
    private final java.lang.String validateEmail(java.lang.String email) {
        return null;
    }
    
    private final java.lang.String validatePassword(java.lang.String password) {
        return null;
    }
}