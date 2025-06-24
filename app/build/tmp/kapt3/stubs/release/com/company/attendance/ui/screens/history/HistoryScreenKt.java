package com.company.attendance.ui.screens.history;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001a\u001e\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\u0012\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001a\u001e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\b\u0010\u000f\u001a\u00020\u0001H\u0007\u001aP\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001aT\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180\u0017H\u0003\u001a\u001a\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001a\u001a\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001a4\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\'\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006("}, d2 = {"AttendanceRecordItem", "", "record", "Lcom/company/attendance/data/model/AttendanceRecord;", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "DayDetailsDialog", "onDismiss", "EmptyStateCard", "HistoryScreen", "viewModel", "Lcom/company/attendance/ui/screens/history/HistoryViewModel;", "onBackClick", "HistoryScreenPreview", "MonthSelectorCard", "selectedYear", "", "selectedMonth", "onMonthSelected", "Lkotlin/Function2;", "getMonthName", "Lkotlin/Function1;", "", "MonthYearPickerDialog", "onSelected", "StatusChip", "status", "Lcom/company/attendance/data/model/AttendanceStatus;", "SummaryCard", "summary", "Lcom/company/attendance/data/repository/AttendanceSummary;", "SummaryStatItem", "label", "count", "color", "Landroidx/compose/ui/graphics/Color;", "SummaryStatItem-9LQNqLg", "(Ljava/lang/String;IJLandroidx/compose/ui/Modifier;)V", "app_release"})
public final class HistoryScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void HistoryScreen(@org.jetbrains.annotations.NotNull()
    com.company.attendance.ui.screens.history.HistoryViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MonthSelectorCard(int selectedYear, int selectedMonth, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onMonthSelected, kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.String> getMonthName, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void SummaryCard(com.company.attendance.data.repository.AttendanceSummary summary, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AttendanceRecordItem(com.company.attendance.data.model.AttendanceRecord record, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StatusChip(com.company.attendance.data.model.AttendanceStatus status, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void EmptyStateCard(androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MonthYearPickerDialog(int selectedYear, int selectedMonth, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onSelected, kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.String> getMonthName) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DayDetailsDialog(com.company.attendance.data.model.AttendanceRecord record, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable()
    public static final void HistoryScreenPreview() {
    }
}