package com.company.attendance.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u0011H\'J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u001b\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\u0018H\u00a7@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\""}, d2 = {"Lcom/company/attendance/data/local/ApprovedWiFiDao;", "", "clearAllNetworks", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deactivateAllNetworks", "deleteNetwork", "network", "Lcom/company/attendance/data/model/ApprovedWiFiNetwork;", "(Lcom/company/attendance/data/model/ApprovedWiFiNetwork;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNetworkByBSSID", "bssid", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllApprovedBSSIDs", "", "getAllApprovedNetworks", "Lkotlinx/coroutines/flow/Flow;", "getAllApprovedNetworksSync", "getApprovedNetworkCount", "", "getNetworkByBSSID", "getStaleNetworks", "threshold", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertNetwork", "insertNetworks", "networks", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastValidated", "timestamp", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNetwork", "app_release"})
@androidx.room.Dao()
public abstract interface ApprovedWiFiDao {
    
    @androidx.room.Query(value = "SELECT * FROM approved_wifi_networks WHERE is_active = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.company.attendance.data.model.ApprovedWiFiNetwork>> getAllApprovedNetworks();
    
    @androidx.room.Query(value = "SELECT * FROM approved_wifi_networks WHERE is_active = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllApprovedNetworksSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.attendance.data.model.ApprovedWiFiNetwork>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM approved_wifi_networks WHERE bssid = :bssid AND is_active = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNetworkByBSSID(@org.jetbrains.annotations.NotNull()
    java.lang.String bssid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.company.attendance.data.model.ApprovedWiFiNetwork> $completion);
    
    @androidx.room.Query(value = "SELECT bssid FROM approved_wifi_networks WHERE is_active = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllApprovedBSSIDs(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNetwork(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.ApprovedWiFiNetwork network, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNetworks(@org.jetbrains.annotations.NotNull()
    java.util.List<com.company.attendance.data.model.ApprovedWiFiNetwork> networks, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateNetwork(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.ApprovedWiFiNetwork network, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNetwork(@org.jetbrains.annotations.NotNull()
    com.company.attendance.data.model.ApprovedWiFiNetwork network, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM approved_wifi_networks WHERE bssid = :bssid")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNetworkByBSSID(@org.jetbrains.annotations.NotNull()
    java.lang.String bssid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM approved_wifi_networks")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearAllNetworks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE approved_wifi_networks SET is_active = 0")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deactivateAllNetworks(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE approved_wifi_networks SET last_validated = :timestamp WHERE bssid = :bssid")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLastValidated(@org.jetbrains.annotations.NotNull()
    java.lang.String bssid, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM approved_wifi_networks WHERE is_active = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getApprovedNetworkCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM approved_wifi_networks WHERE last_validated < :threshold")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStaleNetworks(long threshold, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.company.attendance.data.model.ApprovedWiFiNetwork>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}