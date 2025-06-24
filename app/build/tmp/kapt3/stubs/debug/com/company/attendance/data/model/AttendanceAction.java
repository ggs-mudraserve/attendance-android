package com.company.attendance.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/company/attendance/data/model/AttendanceAction;", "", "()V", "MarkIn", "MarkOut", "SendHeartbeat", "Lcom/company/attendance/data/model/AttendanceAction$MarkIn;", "Lcom/company/attendance/data/model/AttendanceAction$MarkOut;", "Lcom/company/attendance/data/model/AttendanceAction$SendHeartbeat;", "app_debug"})
public abstract class AttendanceAction {
    
    private AttendanceAction() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/company/attendance/data/model/AttendanceAction$MarkIn;", "Lcom/company/attendance/data/model/AttendanceAction;", "()V", "app_debug"})
    public static final class MarkIn extends com.company.attendance.data.model.AttendanceAction {
        @org.jetbrains.annotations.NotNull()
        public static final com.company.attendance.data.model.AttendanceAction.MarkIn INSTANCE = null;
        
        private MarkIn() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/company/attendance/data/model/AttendanceAction$MarkOut;", "Lcom/company/attendance/data/model/AttendanceAction;", "()V", "app_debug"})
    public static final class MarkOut extends com.company.attendance.data.model.AttendanceAction {
        @org.jetbrains.annotations.NotNull()
        public static final com.company.attendance.data.model.AttendanceAction.MarkOut INSTANCE = null;
        
        private MarkOut() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/company/attendance/data/model/AttendanceAction$SendHeartbeat;", "Lcom/company/attendance/data/model/AttendanceAction;", "()V", "app_debug"})
    public static final class SendHeartbeat extends com.company.attendance.data.model.AttendanceAction {
        @org.jetbrains.annotations.NotNull()
        public static final com.company.attendance.data.model.AttendanceAction.SendHeartbeat INSTANCE = null;
        
        private SendHeartbeat() {
        }
    }
}