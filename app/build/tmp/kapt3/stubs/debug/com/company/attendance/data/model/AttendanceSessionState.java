package com.company.attendance.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u000bH\u00c6\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/company/attendance/data/model/AttendanceSessionState;", "", "isActive", "", "sessionId", "", "inTime", "Lkotlinx/datetime/LocalDateTime;", "lastHeartbeat", "currentDuration", "status", "Lcom/company/attendance/data/model/SessionStatus;", "(ZLjava/lang/String;Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/LocalDateTime;Ljava/lang/String;Lcom/company/attendance/data/model/SessionStatus;)V", "getCurrentDuration", "()Ljava/lang/String;", "getInTime", "()Lkotlinx/datetime/LocalDateTime;", "()Z", "getLastHeartbeat", "getSessionId", "getStatus", "()Lcom/company/attendance/data/model/SessionStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class AttendanceSessionState {
    private final boolean isActive = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String sessionId = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlinx.datetime.LocalDateTime inTime = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlinx.datetime.LocalDateTime lastHeartbeat = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currentDuration = null;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.model.SessionStatus status = null;
    
    public AttendanceSessionState(boolean isActive, @org.jetbrains.annotations.Nullable()
    java.lang.String sessionId, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime inTime, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime lastHeartbeat, @org.jetbrains.annotations.NotNull()
    java.lang.String currentDuration, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.SessionStatus status) {
        super();
    }
    
    public final boolean isActive() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSessionId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime getInTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime getLastHeartbeat() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentDuration() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.model.SessionStatus getStatus() {
        return null;
    }
    
    public AttendanceSessionState() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.model.SessionStatus component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.model.AttendanceSessionState copy(boolean isActive, @org.jetbrains.annotations.Nullable()
    java.lang.String sessionId, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime inTime, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime lastHeartbeat, @org.jetbrains.annotations.NotNull()
    java.lang.String currentDuration, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.SessionStatus status) {
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