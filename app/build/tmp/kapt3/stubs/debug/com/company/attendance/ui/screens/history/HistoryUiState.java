package com.company.attendance.ui.screens.history;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010#\u001a\u00020\u000bH\u00c6\u0003J\t\u0010$\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\'\u001a\u00020\u000bH\u00c6\u0003Jo\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001J\t\u0010,\u001a\u00020\u000eH\u00d6\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006-"}, d2 = {"Lcom/company/attendance/ui/screens/history/HistoryUiState;", "", "selectedYear", "", "selectedMonth", "attendanceRecords", "", "Lcom/company/attendance/data/model/AttendanceRecord;", "summary", "Lcom/company/attendance/data/repository/AttendanceSummary;", "isLoading", "", "isRefreshing", "error", "", "selectedDayRecord", "showMonthPicker", "(IILjava/util/List;Lcom/company/attendance/data/repository/AttendanceSummary;ZZLjava/lang/String;Lcom/company/attendance/data/model/AttendanceRecord;Z)V", "getAttendanceRecords", "()Ljava/util/List;", "getError", "()Ljava/lang/String;", "()Z", "getSelectedDayRecord", "()Lcom/company/attendance/data/model/AttendanceRecord;", "getSelectedMonth", "()I", "getSelectedYear", "getShowMonthPicker", "getSummary", "()Lcom/company/attendance/data/repository/AttendanceSummary;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class HistoryUiState {
    private final int selectedYear = 0;
    private final int selectedMonth = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.company.attendance.data.model.AttendanceRecord> attendanceRecords = null;
    @org.jetbrains.annotations.Nullable()
    private final com.company.attendance.data.repository.AttendanceSummary summary = null;
    private final boolean isLoading = false;
    private final boolean isRefreshing = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    @org.jetbrains.annotations.Nullable()
    private final com.company.attendance.data.model.AttendanceRecord selectedDayRecord = null;
    private final boolean showMonthPicker = false;
    
    public HistoryUiState(int selectedYear, int selectedMonth, @org.jetbrains.annotations.NotNull()
    java.util.List<com.company.attendance.data.model.AttendanceRecord> attendanceRecords, @org.jetbrains.annotations.Nullable()
    com.company.attendance.data.repository.AttendanceSummary summary, boolean isLoading, boolean isRefreshing, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.Nullable()
    com.company.attendance.data.model.AttendanceRecord selectedDayRecord, boolean showMonthPicker) {
        super();
    }
    
    public final int getSelectedYear() {
        return 0;
    }
    
    public final int getSelectedMonth() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.company.attendance.data.model.AttendanceRecord> getAttendanceRecords() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.company.attendance.data.repository.AttendanceSummary getSummary() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final boolean isRefreshing() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.company.attendance.data.model.AttendanceRecord getSelectedDayRecord() {
        return null;
    }
    
    public final boolean getShowMonthPicker() {
        return false;
    }
    
    public HistoryUiState() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.company.attendance.data.model.AttendanceRecord> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.company.attendance.data.repository.AttendanceSummary component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.company.attendance.data.model.AttendanceRecord component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.ui.screens.history.HistoryUiState copy(int selectedYear, int selectedMonth, @org.jetbrains.annotations.NotNull()
    java.util.List<com.company.attendance.data.model.AttendanceRecord> attendanceRecords, @org.jetbrains.annotations.Nullable()
    com.company.attendance.data.repository.AttendanceSummary summary, boolean isLoading, boolean isRefreshing, @org.jetbrains.annotations.Nullable()
    java.lang.String error, @org.jetbrains.annotations.Nullable()
    com.company.attendance.data.model.AttendanceRecord selectedDayRecord, boolean showMonthPicker) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}