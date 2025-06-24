package com.company.attendance.utils

import android.util.Log
import com.company.attendance.data.repository.AuthRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    private val authRepository: AuthRepository
) {
    companion object {
        private const val TAG = "SessionManager"
        private const val REFRESH_THRESHOLD_MINUTES = 5L // Refresh 5 minutes before expiry
        private const val CHECK_INTERVAL_MINUTES = 1L // Check every minute
    }
    
    private var refreshJob: Job? = null
    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    
    fun startSessionMonitoring() {
        refreshJob?.cancel()
        refreshJob = coroutineScope.launch {
            while (isActive) {
                try {
                    checkAndRefreshSession()
                } catch (e: Exception) {
                    Log.e(TAG, "Error in session monitoring", e)
                }
                delay(CHECK_INTERVAL_MINUTES * 60 * 1000) // Check every minute
            }
        }
    }
    
    fun stopSessionMonitoring() {
        refreshJob?.cancel()
        refreshJob = null
    }
    
    private suspend fun checkAndRefreshSession() {
        try {
            val isAuthenticated = authRepository.isAuthenticated.first()
            if (!isAuthenticated) {
                Log.d(TAG, "User not authenticated, skipping session check")
                return
            }
            
            val session = authRepository.getCurrentSession()
            if (session == null) {
                Log.d(TAG, "No active session found")
                return
            }
            
            val currentTime = System.currentTimeMillis() / 1000
            val timeUntilExpiry = session.expiresAt - currentTime
            val refreshThreshold = REFRESH_THRESHOLD_MINUTES * 60
            
            Log.d(TAG, "Session expires in ${timeUntilExpiry}s, threshold: ${refreshThreshold}s")
            
            if (timeUntilExpiry <= refreshThreshold) {
                Log.i(TAG, "Session approaching expiry, refreshing...")
                val result = authRepository.refreshSession()
                when (result) {
                    is com.company.attendance.data.model.AuthResult.Success -> {
                        Log.i(TAG, "Session refreshed successfully")
                    }
                    is com.company.attendance.data.model.AuthResult.Error -> {
                        Log.e(TAG, "Session refresh failed: ${result.message}")
                    }
                    else -> {
                        Log.w(TAG, "Unexpected refresh result: $result")
                    }
                }
            } else {
                Log.d(TAG, "Session still valid, no refresh needed")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error checking session", e)
        }
    }
    
    suspend fun refreshSessionIfNeeded(): Boolean {
        return try {
            val session = authRepository.getCurrentSession()
            if (session == null) return false
            
            val currentTime = System.currentTimeMillis() / 1000
            val isExpired = currentTime >= session.expiresAt
            
            if (isExpired) {
                Log.i(TAG, "Session expired, attempting refresh...")
                val result = authRepository.refreshSession()
                result is com.company.attendance.data.model.AuthResult.Success
            } else {
                true // Session is still valid
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error refreshing session", e)
            false
        }
    }
    
    suspend fun ensureValidSession(): String? {
        return try {
            val isValid = refreshSessionIfNeeded()
            if (isValid) {
                authRepository.getAccessToken()
            } else {
                null
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error ensuring valid session", e)
            null
        }
    }
    
    fun cleanup() {
        stopSessionMonitoring()
        coroutineScope.cancel()
    }
}