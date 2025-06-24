package com.company.attendance.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0003\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\b\u0010\t\u001a\u00020\u0001H\u0003\u001a,\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0003\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0018\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0003\u001a>\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u00a8\u0006\u0018"}, d2 = {"ApprovedNetworkContent", "", "wifiStatus", "Lcom/company/attendance/data/model/WiFiStatus;", "DetailRow", "label", "", "value", "NetworkDetailsSection", "NotConnectedContent", "PermissionRequiredContent", "permissionState", "Lcom/company/attendance/data/model/WiFiPermissionState;", "onPermissionClick", "Lkotlin/Function0;", "onSettingsClick", "UnapprovedNetworkContent", "WiFiSignalIndicator", "strength", "", "maxStrength", "WiFiStatusCard", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class WiFiStatusCardKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.animation.ExperimentalAnimationApi.class})
    @androidx.compose.runtime.Composable()
    public static final void WiFiStatusCard(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.WiFiStatus wifiStatus, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.WiFiPermissionState permissionState, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPermissionClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSettingsClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void PermissionRequiredContent(com.company.attendance.data.model.WiFiPermissionState permissionState, kotlin.jvm.functions.Function0<kotlin.Unit> onPermissionClick, kotlin.jvm.functions.Function0<kotlin.Unit> onSettingsClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void NotConnectedContent() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ApprovedNetworkContent(com.company.attendance.data.model.WiFiStatus wifiStatus) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void UnapprovedNetworkContent(com.company.attendance.data.model.WiFiStatus wifiStatus) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void NetworkDetailsSection(com.company.attendance.data.model.WiFiStatus wifiStatus) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void DetailRow(java.lang.String label, java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void WiFiSignalIndicator(int strength, int maxStrength) {
    }
}