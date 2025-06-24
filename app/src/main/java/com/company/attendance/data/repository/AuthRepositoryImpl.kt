package com.company.attendance.data.repository

import android.util.Log
import com.company.attendance.data.model.*
import com.company.attendance.utils.PreferencesManager
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient,
    private val preferencesManager: PreferencesManager
) : AuthRepository {
    
    companion object {
        private const val TAG = "AuthRepository"
    }
    
    private val _authState = MutableStateFlow<AuthState>(AuthState.Loading)
    override val authState: Flow<AuthState> = _authState.asStateFlow()
    
    override val currentUser: Flow<AuthUser?> = authState.map { state ->
        when (state) {
            is AuthState.Authenticated -> state.user
            else -> null
        }
    }
    
    override val isAuthenticated: Flow<Boolean> = authState.map { state ->
        state is AuthState.Authenticated
    }
    
    init {
        observeAuthState()
        restoreSessionOnInit()
    }
    
    private fun observeAuthState() {
        supabaseClient.auth.sessionStatus.onEach { status ->
            Log.d(TAG, "Session status changed: $status")
            when (status) {
                is SessionStatus.Authenticated -> {
                    val session = status.session
                    val authUser = session.user?.toAuthUser()
                    if (authUser != null) {
                        val authSession = AuthSession(
                            accessToken = session.accessToken,
                            refreshToken = session.refreshToken ?: "",
                            expiresAt = session.expiresAt?.epochSeconds ?: (System.currentTimeMillis() / 1000 + 3600),
                            user = authUser
                        )
                        saveSession(authSession)
                        _authState.value = AuthState.Authenticated(authUser, authSession)
                    } else {
                        _authState.value = AuthState.Error("Invalid user data")
                    }
                }
                is SessionStatus.LoadingFromStorage -> {
                    _authState.value = AuthState.Loading
                }
                is SessionStatus.NotAuthenticated -> {
                    clearSession()
                    _authState.value = AuthState.Unauthenticated
                }
                is SessionStatus.NetworkError -> {
                    _authState.value = AuthState.Error("Network error")
                }
            }
        }.launchIn(GlobalScope)
    }
    
    private fun restoreSessionOnInit() {
        GlobalScope.launch {
            try {
                // Supabase will automatically restore session from storage
                // We just need to wait for the session status to update
                Log.d(TAG, "Initializing session restoration")
            } catch (e: Exception) {
                Log.e(TAG, "Error restoring session", e)
                _authState.value = AuthState.Unauthenticated
            }
        }
    }
    
    override suspend fun signIn(email: String, password: String): AuthResult<AuthSession> {
        return try {
            _authState.value = AuthState.Loading
            
            supabaseClient.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            
            // Session will be updated via observeAuthState
            val currentState = _authState.value
            if (currentState is AuthState.Authenticated) {
                AuthResult.Success(currentState.session)
            } else {
                AuthResult.Error("Authentication failed")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Sign in error", e)
            val errorMessage = when {
                e.message?.contains("Invalid login credentials") == true -> "Invalid email or password"
                e.message?.contains("Email not confirmed") == true -> "Please verify your email address"
                e.message?.contains("Too many requests") == true -> "Too many login attempts. Please try again later"
                else -> e.message ?: "Authentication failed"
            }
            _authState.value = AuthState.Error(errorMessage, e)
            AuthResult.Error(errorMessage, e)
        }
    }
    
    override suspend fun signUp(email: String, password: String, firstName: String?, lastName: String?): AuthResult<AuthSession> {
        return try {
            _authState.value = AuthState.Loading
            
            supabaseClient.auth.signUpWith(Email) {
                this.email = email
                this.password = password
                data = buildJsonObject {
                    firstName?.let { put("first_name", it) }
                    lastName?.let { put("last_name", it) }
                }
            }
            
            val currentState = _authState.value
            if (currentState is AuthState.Authenticated) {
                AuthResult.Success(currentState.session)
            } else {
                AuthResult.Error("Sign up failed")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Sign up error", e)
            val errorMessage = when {
                e.message?.contains("User already registered") == true -> "Email already registered"
                e.message?.contains("Password should be at least") == true -> "Password must be at least 6 characters"
                e.message?.contains("Unable to validate email") == true -> "Invalid email address"
                else -> e.message ?: "Sign up failed"
            }
            _authState.value = AuthState.Error(errorMessage, e)
            AuthResult.Error(errorMessage, e)
        }
    }
    
    override suspend fun signOut(): AuthResult<Unit> {
        return try {
            supabaseClient.auth.signOut()
            clearSession()
            _authState.value = AuthState.Unauthenticated
            AuthResult.Success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Sign out error", e)
            AuthResult.Error(e.message ?: "Sign out failed", e)
        }
    }
    
    override suspend fun resetPassword(email: String): AuthResult<Unit> {
        return try {
            supabaseClient.auth.resetPasswordForEmail(email)
            AuthResult.Success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Reset password error", e)
            AuthResult.Error(e.message ?: "Password reset failed", e)
        }
    }
    
    override suspend fun getCurrentSession(): AuthSession? {
        return try {
            val session = supabaseClient.auth.currentSessionOrNull()
            session?.let {
                val authUser = it.user?.toAuthUser()
                if (authUser != null) {
                    AuthSession(
                        accessToken = it.accessToken,
                        refreshToken = it.refreshToken ?: "",
                        expiresAt = it.expiresAt?.epochSeconds ?: (System.currentTimeMillis() / 1000 + 3600),
                        user = authUser
                    )
                } else null
            }
        } catch (e: Exception) {
            Log.e(TAG, "Get current session error", e)
            null
        }
    }
    
    override suspend fun refreshSession(): AuthResult<AuthSession> {
        return try {
            supabaseClient.auth.refreshCurrentSession()
            val session = supabaseClient.auth.currentSessionOrNull() ?: throw Exception("No session after refresh")
            val authUser = session.user?.toAuthUser()
            if (authUser != null) {
                val authSession = AuthSession(
                    accessToken = session.accessToken,
                    refreshToken = session.refreshToken ?: "",
                    expiresAt = session.expiresAt?.epochSeconds ?: (System.currentTimeMillis() / 1000 + 3600),
                    user = authUser
                )
                saveSession(authSession)
                _authState.value = AuthState.Authenticated(authUser, authSession)
                AuthResult.Success(authSession)
            } else {
                AuthResult.Error("Invalid session data")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Refresh session error", e)
            _authState.value = AuthState.Unauthenticated
            AuthResult.Error(e.message ?: "Session refresh failed", e)
        }
    }
    
    override suspend fun isSessionValid(): Boolean {
        return try {
            val session = getCurrentSession()
            session != null && System.currentTimeMillis() / 1000 < session.expiresAt
        } catch (e: Exception) {
            Log.e(TAG, "Session validation error", e)
            false
        }
    }
    
    override suspend fun getCurrentUser(): AuthUser? {
        return try {
            supabaseClient.auth.currentUserOrNull()?.toAuthUser()
        } catch (e: Exception) {
            Log.e(TAG, "Get current user error", e)
            null
        }
    }
    
    override suspend fun updateUser(updates: Map<String, Any>): AuthResult<AuthUser> {
        return try {
            val updatedUser = supabaseClient.auth.modifyUser {
                data = buildJsonObject {
                updates.forEach { (key, value) ->
                    put(key, value.toString())
                }
            }
            }
            val authUser = updatedUser.toAuthUser()
            
            // Update current state
            val currentState = _authState.value
            if (currentState is AuthState.Authenticated) {
                val updatedSession = currentState.session.copy(user = authUser)
                saveSession(updatedSession)
                _authState.value = AuthState.Authenticated(authUser, updatedSession)
            }
            
            AuthResult.Success(authUser)
        } catch (e: Exception) {
            Log.e(TAG, "Update user error", e)
            AuthResult.Error(e.message ?: "User update failed", e)
        }
    }
    
    override suspend fun getAccessToken(): String? {
        return try {
            supabaseClient.auth.currentAccessTokenOrNull()
        } catch (e: Exception) {
            Log.e(TAG, "Get access token error", e)
            null
        }
    }
    
    override suspend fun getRefreshToken(): String? {
        return try {
            supabaseClient.auth.currentSessionOrNull()?.refreshToken
        } catch (e: Exception) {
            Log.e(TAG, "Get refresh token error", e)
            null
        }
    }
    
    override suspend fun saveSession(session: AuthSession) {
        try {
            // Supabase handles session persistence automatically
            Log.d(TAG, "Session saved for user: ${session.user.email}")
        } catch (e: Exception) {
            Log.e(TAG, "Save session error", e)
        }
    }
    
    override suspend fun clearSession() {
        try {
            // Clear any additional local data if needed
            Log.d(TAG, "Session cleared")
        } catch (e: Exception) {
            Log.e(TAG, "Clear session error", e)
        }
    }
    
    override suspend fun restoreSession(): AuthSession? {
        return getCurrentSession()
    }
    
    private fun io.github.jan.supabase.gotrue.user.UserInfo.toAuthUser(): AuthUser {
        return AuthUser(
            id = this.id,
            email = this.email ?: "",
            emailVerified = this.emailConfirmedAt != null,
            createdAt = this.createdAt,
            lastSignInAt = this.lastSignInAt
        )
    }
}