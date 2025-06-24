package com.company.attendance.ui.screens.settings;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/company/attendance/ui/screens/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "preferencesManager", "Lcom/company/attendance/utils/PreferencesManager;", "deviceUtils", "Lcom/company/attendance/utils/DeviceUtils;", "(Lcom/company/attendance/utils/PreferencesManager;Lcom/company/attendance/utils/DeviceUtils;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/attendance/ui/screens/settings/SettingsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "clearSaveSuccess", "loadSettings", "onServerIpChanged", "ip", "", "onServerPortChanged", "port", "saveSettings", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.PreferencesManager preferencesManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.DeviceUtils deviceUtils = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.ui.screens.settings.SettingsUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.settings.SettingsUiState> uiState = null;
    
    @javax.inject.Inject()
    public SettingsViewModel(@org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.PreferencesManager preferencesManager, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.DeviceUtils deviceUtils) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.settings.SettingsUiState> getUiState() {
        return null;
    }
    
    private final void loadSettings() {
    }
    
    public final void onServerIpChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String ip) {
    }
    
    public final void onServerPortChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String port) {
    }
    
    public final void saveSettings() {
    }
    
    public final void clearError() {
    }
    
    public final void clearSaveSuccess() {
    }
}