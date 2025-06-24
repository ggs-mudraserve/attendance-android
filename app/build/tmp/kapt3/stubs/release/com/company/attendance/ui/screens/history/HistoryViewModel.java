package com.company.attendance.ui.screens.history;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0012\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\u0006\u0010\u0019\u001a\u00020\u000fJ\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001f"}, d2 = {"Lcom/company/attendance/ui/screens/history/HistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "attendanceRepository", "Lcom/company/attendance/data/repository/AttendanceRepository;", "(Lcom/company/attendance/data/repository/AttendanceRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/company/attendance/ui/screens/history/HistoryUiState;", "currentDate", "Lkotlinx/datetime/LocalDate;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearError", "", "getMonthName", "", "month", "", "hideDayDetails", "loadAttendanceData", "forceRefresh", "", "loadCurrentMonth", "refreshData", "selectMonth", "year", "showDayDetails", "record", "Lcom/company/attendance/data/model/AttendanceRecord;", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.repository.AttendanceRepository attendanceRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.company.attendance.ui.screens.history.HistoryUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.history.HistoryUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.LocalDate currentDate = null;
    
    @javax.inject.Inject()
    public HistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.repository.AttendanceRepository attendanceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.company.attendance.ui.screens.history.HistoryUiState> getUiState() {
        return null;
    }
    
    private final void loadCurrentMonth() {
    }
    
    public final void selectMonth(int year, int month) {
    }
    
    public final void refreshData() {
    }
    
    public final void showDayDetails(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.AttendanceRecord record) {
    }
    
    public final void hideDayDetails() {
    }
    
    private final void loadAttendanceData(boolean forceRefresh) {
    }
    
    public final void clearError() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMonthName(int month) {
        return null;
    }
}