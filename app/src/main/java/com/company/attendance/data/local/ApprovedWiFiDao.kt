package com.company.attendance.data.local

import androidx.room.*
import com.company.attendance.data.model.ApprovedWiFiNetwork
import kotlinx.coroutines.flow.Flow

@Dao
interface ApprovedWiFiDao {
    
    @Query("SELECT * FROM approved_wifi_networks WHERE is_active = 1")
    fun getAllApprovedNetworks(): Flow<List<ApprovedWiFiNetwork>>
    
    @Query("SELECT * FROM approved_wifi_networks WHERE is_active = 1")
    suspend fun getAllApprovedNetworksSync(): List<ApprovedWiFiNetwork>
    
    @Query("SELECT * FROM approved_wifi_networks WHERE bssid = :bssid AND is_active = 1")
    suspend fun getNetworkByBSSID(bssid: String): ApprovedWiFiNetwork?
    
    @Query("SELECT bssid FROM approved_wifi_networks WHERE is_active = 1")
    suspend fun getAllApprovedBSSIDs(): List<String>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNetwork(network: ApprovedWiFiNetwork)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNetworks(networks: List<ApprovedWiFiNetwork>)
    
    @Update
    suspend fun updateNetwork(network: ApprovedWiFiNetwork)
    
    @Delete
    suspend fun deleteNetwork(network: ApprovedWiFiNetwork)
    
    @Query("DELETE FROM approved_wifi_networks WHERE bssid = :bssid")
    suspend fun deleteNetworkByBSSID(bssid: String)
    
    @Query("DELETE FROM approved_wifi_networks")
    suspend fun clearAllNetworks()
    
    @Query("UPDATE approved_wifi_networks SET is_active = 0")
    suspend fun deactivateAllNetworks()
    
    @Query("UPDATE approved_wifi_networks SET last_validated = :timestamp WHERE bssid = :bssid")
    suspend fun updateLastValidated(bssid: String, timestamp: Long = System.currentTimeMillis())
    
    @Query("SELECT COUNT(*) FROM approved_wifi_networks WHERE is_active = 1")
    suspend fun getApprovedNetworkCount(): Int
    
    @Query("SELECT * FROM approved_wifi_networks WHERE last_validated < :threshold")
    suspend fun getStaleNetworks(threshold: Long): List<ApprovedWiFiNetwork>
}