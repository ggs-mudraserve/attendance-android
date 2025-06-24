package com.company.attendance.ui.screens.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u000201J\u0006\u00103\u001a\u000204J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000201H\u0002J\u0006\u00109\u001a\u000201J\u0006\u0010:\u001a\u000201J\b\u0010;\u001a\u000201H\u0014J\b\u0010<\u001a\u000201H\u0002J\u0006\u0010=\u001a\u000201J\u000e\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0002J\b\u0010D\u001a\u000201H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0&0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006E"}, d2 = {"Lcom/company/attendance/ui/screens/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "attendanceRepository", "Lcom/company/attendance/data/repository/AttendanceRepository;", "authRepository", "Lcom/company/attendance/data/repository/AuthRepository;", "wifiMonitoringService", "Lcom/company/attendance/service/WiFiMonitoringService;", "permissionHandler", "Lcom/company/attendance/utils/PermissionHandler;", "networkUtils", "Lcom/company/attendance/utils/NetworkUtils;", "workManagerService", "Lcom/company/attendance/service/WorkManagerService;", "(Lcom/company/attendance/data/repository/AttendanceRepository;Lcom/company/attendance/data/repository/AuthRepository;Lcom/company/attendance/service/WiFiMonitoringService;Lcom/company/attendance/utils/PermissionHandler;Lcom/company/attendance/utils/NetworkUtils;Lcom/company/attendance/service/WorkManagerService;)V", "_attendanceResult", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/attendance/data/model/AttendanceResult;", "_isOffline", "", "_sessionState", "Lcom/company/attendance/data/model/AttendanceSessionState;", "_uiState", "Lcom/company/attendance/ui/screens/dashboard/DashboardUiState;", "attendanceResult", "Lkotlinx/coroutines/flow/StateFlow;", "getAttendanceResult", "()Lkotlinx/coroutines/flow/StateFlow;", "durationUpdateJob", "Lkotlinx/coroutines/Job;", "isOffline", "permissionState", "Lcom/company/attendance/data/model/WiFiPermissionState;", "getPermissionState", "queueStatus", "Lcom/company/attendance/service/QueueStatus;", "getQueueStatus", "queuedRequests", "", "Lcom/company/attendance/data/model/QueuedRequest;", "getQueuedRequests", "sessionState", "getSessionState", "uiState", "getUiState", "wifiStatus", "Lcom/company/attendance/data/model/WiFiStatus;", "getWifiStatus", "clearFailedRequests", "", "clearResult", "getButtonState", "Lcom/company/attendance/data/model/AttendanceButtonState;", "handleAttendanceError", "error", "", "loadCurrentSession", "markIn", "markOut", "onCleared", "processQueuedRequests", "retryCriticalRequests", "retryRequest", "requestId", "", "startDurationTimer", "startNetworkMonitoring", "updateSessionDuration", "updateUiState", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AttendanceRepository attendanceRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.service.WiFiMonitoringService wifiMonitoringService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.PermissionHandler permissionHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.utils.NetworkUtils networkUtils = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.service.WorkManagerService workManagerService = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.ui.screens.dashboard.DashboardUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.dashboard.DashboardUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.data.model.AttendanceSessionState> _sessionState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.AttendanceSessionState> sessionState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.data.model.AttendanceResult> _attendanceResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.AttendanceResult> attendanceResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isOffline = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOffline = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.company.attendance.data.model.QueuedRequest>> queuedRequests = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.service.QueueStatus> queueStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.WiFiStatus> wifiStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.WiFiPermissionState> permissionState = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job durationUpdateJob;
    
    @javax.inject.Inject()
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AttendanceRepository attendanceRepository, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AuthRepository authRepository, @org.jetbrains.annotations.NotNull()
    com.company.attendance.service.WiFiMonitoringService wifiMonitoringService, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.PermissionHandler permissionHandler, @org.jetbrains.annotations.NotNull()
    com.company.attendance.utils.NetworkUtils networkUtils, @org.jetbrains.annotations.NotNull()
    com.company.attendance.service.WorkManagerService workManagerService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.dashboard.DashboardUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.AttendanceSessionState> getSessionState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.AttendanceResult> getAttendanceResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOffline() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.company.attendance.data.model.QueuedRequest>> getQueuedRequests() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.service.QueueStatus> getQueueStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.WiFiStatus> getWifiStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.data.model.WiFiPermissionState> getPermissionState() {
        return null;
    }
    
    private final void loadCurrentSession() {
    }
    
    private final void startDurationTimer() {
    }
    
    private final void updateSessionDuration() {
    }
    
    private final void updateUiState() {
    }
    
    public final void markIn() {
    }
    
    public final void markOut() {
    }
    
    private final void handleAttendanceError(java.lang.Throwable error) {
    }
    
    public final void clearResult() {
    }
    
    public final void retryRequest(long requestId) {
    }
    
    public final void retryCriticalRequests() {
    }
    
    public final void clearFailedRequests() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.model.AttendanceButtonState getButtonState() {
        return null;
    }
    
    private final void startNetworkMonitoring() {
    }
    
    private final void processQueuedRequests() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}