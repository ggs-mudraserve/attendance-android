package com.company.attendance.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/company/attendance/data/model/SessionStatus;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "ACTIVE", "COMPLETED", "MISSED_HEARTBEAT", "app_release"})
public enum SessionStatus {
    /*public static final*/ NOT_STARTED /* = new NOT_STARTED() */,
    /*public static final*/ ACTIVE /* = new ACTIVE() */,
    /*public static final*/ COMPLETED /* = new COMPLETED() */,
    /*public static final*/ MISSED_HEARTBEAT /* = new MISSED_HEARTBEAT() */;
    
    SessionStatus() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.company.attendance.data.model.SessionStatus> getEntries() {
        return null;
    }
}