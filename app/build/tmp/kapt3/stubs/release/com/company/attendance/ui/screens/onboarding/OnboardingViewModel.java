package com.company.attendance.ui.screens.onboarding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0013J\u0012\u0010!\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\"\u001a\u00020\u001fJ\u0012\u0010#\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/company/attendance/ui/screens/onboarding/OnboardingViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/company/attendance/data/repository/AttendanceRepository;", "authRepository", "Lcom/company/attendance/data/repository/AuthRepository;", "deviceUtils", "Lcom/company/attendance/utils/DeviceUtils;", "preferencesManager", "Lcom/company/attendance/utils/PreferencesManager;", "(Lcom/company/attendance/data/repository/AttendanceRepository;Lcom/company/attendance/data/repository/AuthRepository;Lcom/company/attendance/utils/DeviceUtils;Lcom/company/attendance/utils/PreferencesManager;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/attendance/ui/screens/onboarding/OnboardingUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "completeOnboarding", "loadDeviceInfo", "onAccountNumberChanged", "accountNumber", "", "onBankNameChanged", "bankName", "onIfscCodeChanged", "ifscCode", "onPermissionsGranted", "granted", "", "skipBankDetails", "validateAccountNumber", "validateBankDetailsPartial", "validateBankName", "validateIfscCode", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OnboardingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AttendanceRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.DeviceUtils deviceUtils = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.PreferencesManager preferencesManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.ui.screens.onboarding.OnboardingUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.onboarding.OnboardingUiState> uiState = null;
    
    @javax.inject.Inject()
    public OnboardingViewModel(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AttendanceRepository repository, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.DeviceUtils deviceUtils, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.PreferencesManager preferencesManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.onboarding.OnboardingUiState> getUiState() {
        return null;
    }
    
    private final void loadDeviceInfo() {
    }
    
    public final void onAccountNumberChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String accountNumber) {
    }
    
    public final void onIfscCodeChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String ifscCode) {
    }
    
    public final void onBankNameChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String bankName) {
    }
    
    public final void onPermissionsGranted(boolean granted) {
    }
    
    public final void completeOnboarding() {
    }
    
    public final void skipBankDetails() {
    }
    
    private final java.lang.String validateAccountNumber(java.lang.String accountNumber) {
        return null;
    }
    
    private final java.lang.String validateIfscCode(java.lang.String ifscCode) {
        return null;
    }
    
    private final java.lang.String validateBankName(java.lang.String bankName) {
        return null;
    }
    
    public final boolean validateBankDetailsPartial() {
        return false;
    }
    
    public final void clearError() {
    }
}