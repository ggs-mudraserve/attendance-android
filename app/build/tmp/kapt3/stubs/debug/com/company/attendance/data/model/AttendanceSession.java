package com.company.attendance.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000b\u0010\u0005\u001a\u00070\u0006\u00a2\u0006\u0002\b\u0007\u0012\u000b\u0010\b\u001a\u00070\t\u00a2\u0006\u0002\b\u0007\u0012\u000b\u0010\n\u001a\u00070\t\u00a2\u0006\u0002\b\u0007\u0012\r\u0010\u000b\u001a\t\u0018\u00010\t\u00a2\u0006\u0002\b\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\u000e\u0010\u001c\u001a\u00070\u0006\u00a2\u0006\u0002\b\u0007H\u00c6\u0003J\u000e\u0010\u001d\u001a\u00070\t\u00a2\u0006\u0002\b\u0007H\u00c6\u0003J\u000e\u0010\u001e\u001a\u00070\t\u00a2\u0006\u0002\b\u0007H\u00c6\u0003J\u0010\u0010\u001f\u001a\t\u0018\u00010\t\u00a2\u0006\u0002\b\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\rH\u00c6\u0003Je\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\r\b\u0002\u0010\u0005\u001a\u00070\u0006\u00a2\u0006\u0002\b\u00072\r\b\u0002\u0010\b\u001a\u00070\t\u00a2\u0006\u0002\b\u00072\r\b\u0002\u0010\n\u001a\u00070\t\u00a2\u0006\u0002\b\u00072\u000f\b\u0002\u0010\u000b\u001a\t\u0018\u00010\t\u00a2\u0006\u0002\b\u00072\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\t\u0010\"\u001a\u00020\rH\u00d6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u00d6\u0003J\t\u0010\'\u001a\u00020\rH\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\rH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00070\t\u00a2\u0006\u0002\b\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\n\u001a\u00070\t\u00a2\u0006\u0002\b\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\t\u0018\u00010\t\u00a2\u0006\u0002\b\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0005\u001a\u00070\u0006\u00a2\u0006\u0002\b\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006."}, d2 = {"Lcom/company/attendance/data/model/AttendanceSession;", "Landroid/os/Parcelable;", "id", "", "employeeId", "sessionDate", "Lkotlinx/datetime/LocalDate;", "Lkotlinx/parcelize/RawValue;", "inTime", "Lkotlinx/datetime/LocalDateTime;", "lastHeartbeat", "outTime", "missedCount", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/LocalDateTime;Lkotlinx/datetime/LocalDateTime;I)V", "getEmployeeId", "()Ljava/lang/String;", "getId", "getInTime", "()Lkotlinx/datetime/LocalDateTime;", "getLastHeartbeat", "getMissedCount", "()I", "getOutTime", "getSessionDate", "()Lkotlinx/datetime/LocalDate;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
@kotlinx.parcelize.Parcelize()
public final class AttendanceSession implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String employeeId = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.LocalDate sessionDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.LocalDateTime inTime = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.datetime.LocalDateTime lastHeartbeat = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlinx.datetime.LocalDateTime outTime = null;
    private final int missedCount = 0;
    
    public AttendanceSession(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate sessionDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime inTime, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime lastHeartbeat, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime outTime, int missedCount) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmployeeId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDate getSessionDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDateTime getInTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDateTime getLastHeartbeat() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime getOutTime() {
        return null;
    }
    
    public final int getMissedCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDate component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDateTime component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.datetime.LocalDateTime component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.datetime.LocalDateTime component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.company.attendance.data.model.AttendanceSession copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String employeeId, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate sessionDate, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime inTime, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDateTime lastHeartbeat, @org.jetbrains.annotations.Nullable()
    kotlinx.datetime.LocalDateTime outTime, int missedCount) {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
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
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
}