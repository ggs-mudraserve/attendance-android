package com.company.attendance.data.repository

import com.company.attendance.data.model.*
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    
    // Authentication State
    val authState: Flow<AuthState>
    val currentUser: Flow<AuthUser?>
    val isAuthenticated: Flow<Boolean>
    
    // Authentication Actions
    suspend fun signIn(email: String, password: String): AuthResult<AuthSession>
    suspend fun signUp(email: String, password: String, firstName: String? = null, lastName: String? = null): AuthResult<AuthSession>
    suspend fun signOut(): AuthResult<Unit>
    suspend fun resetPassword(email: String): AuthResult<Unit>
    
    // Session Management
    suspend fun getCurrentSession(): AuthSession?
    suspend fun refreshSession(): AuthResult<AuthSession>
    suspend fun isSessionValid(): Boolean
    
    // User Management
    suspend fun getCurrentUser(): AuthUser?
    suspend fun updateUser(updates: Map<String, Any>): AuthResult<AuthUser>
    
    // Token Management
    suspend fun getAccessToken(): String?
    suspend fun getRefreshToken(): String?
    
    // Session Persistence
    suspend fun saveSession(session: AuthSession)
    suspend fun clearSession()
    suspend fun restoreSession(): AuthSession?
}