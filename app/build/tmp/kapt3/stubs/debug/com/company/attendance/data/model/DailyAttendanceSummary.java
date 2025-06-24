package com.company.attendance.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003JI\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/company/attendance/data/model/DailyAttendanceSummary;", "", "date", "Lkotlinx/datetime/LocalDate;", "totalMinutes", "", "status", "Lcom/company/attendance/data/model/AttendanceStatus;", "inTime", "Lkotlinx/datetime/LocalTime;", "outTime", "breakDuration", "(Lkotlinx/datetime/LocalDate;ILcom/company/attendance/data/model/AttendanceStatus;Lkotlinx/datetime/LocalTime;Lkotlinx/datetime/LocalTime;I)V", "getBreakDuration", "()I", "getDate", "()Lkotlinx/datetime/LocalDate;", "getInTime", "()Lkotlinx/datetime/LocalTime;", "getOutTime", "getStatus", "()Lcom/company/attendance/data/model/AttendanceStatus;", "getTotalMinutes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class DailyAttendanceSummary {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.LocalDate date = null;
    private final int totalMinutes = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.company.attendance.data.model.AttendanceStatus status = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlinx.datetime.LocalTime inTime = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlinx.datetime.LocalTime outTime = null;
    private final int breakDuration = 0;
    
    public DailyAttendanceSummary(@org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate date, int totalMinutes, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.AttendanceStatus status, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalTime inTime, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalTime outTime, int breakDuration) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDate getDate() {
        return null;
    }
    
    public final int getTotalMinutes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.model.AttendanceStatus getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalTime getInTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalTime getOutTime() {
        return null;
    }
    
    public final int getBreakDuration() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDate component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.model.AttendanceStatus component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalTime component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalTime component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.model.DailyAttendanceSummary copy(@org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate date, int totalMinutes, @org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.AttendanceStatus status, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalTime inTime, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalTime outTime, int breakDuration) {
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