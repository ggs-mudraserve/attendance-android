package com.company.attendance.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a`\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a(\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0003\u001a4\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006#"}, d2 = {"onWarningContainer", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/material3/ColorScheme;", "getOnWarningContainer", "(Landroidx/compose/material3/ColorScheme;)J", "warningContainer", "getWarningContainer", "QueueStatusCard", "", "queueStatus", "Lcom/company/attendance/service/QueueStatus;", "queuedRequests", "", "Lcom/company/attendance/data/model/QueuedRequest;", "isOffline", "", "onRetryRequest", "Lkotlin/Function1;", "", "onRetryCritical", "Lkotlin/Function0;", "onClearFailed", "modifier", "Landroidx/compose/ui/Modifier;", "QueuedRequestItem", "request", "onRetry", "StatusChip", "label", "", "count", "", "color", "StatusChip-9LQNqLg", "(Ljava/lang/String;IJLandroidx/compose/ui/Modifier;)V", "app_debug"})
public final class QueueStatusCardKt {
    
    public static final long getWarningContainer(@org.jetbrains.annotations.NotNull()
    androidx.compose.material3.ColorScheme $this$warningContainer) {
        return 0L;
    }
    
    public static final long getOnWarningContainer(@org.jetbrains.annotations.NotNull()
    androidx.compose.material3.ColorScheme $this$onWarningContainer) {
        return 0L;
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void QueueStatusCard(@org.jetbrains.annotations.NotNull()
    com.company.attendance.service.QueueStatus queueStatus, @org.jetbrains.annotations.NotNull()
    java.util.List<com.company.attendance.data.model.QueuedRequest> queuedRequests, boolean isOffline, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onRetryRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetryCritical, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClearFailed, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void QueuedRequestItem(com.company.attendance.data.model.QueuedRequest request, kotlin.jvm.functions.Function0<kotlin.Unit> onRetry, androidx.compose.ui.Modifier modifier) {
    }
}