package com.company.attendance.data.model

import kotlinx.datetime.Instant

data class AuthUser(
    val id: String,
    val email: String,
    val emailVerified: Boolean = false,
    val createdAt: Instant? = null,
    val lastSignInAt: Instant? = null
)

data class AuthSession(
    val accessToken: String,
    val refreshToken: String,
    val expiresAt: Long,
    val user: AuthUser
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class SignUpRequest(
    val email: String,
    val password: String,
    val firstName: String? = null,
    val lastName: String? = null
)

sealed class AuthState {
    object Loading : AuthState()
    object Unauthenticated : AuthState()
    data class Authenticated(val user: AuthUser, val session: AuthSession) : AuthState()
    data class Error(val message: String, val exception: Throwable? = null) : AuthState()
}

sealed class AuthResult<out T> {
    data class Success<T>(val data: T) : AuthResult<T>()
    data class Error(val message: String, val exception: Throwable? = null) : AuthResult<Nothing>()
    object Loading : AuthResult<Nothing>()
}

data class AuthError(
    val code: String,
    override val message: String,
    val details: String? = null
) : Exception(message)