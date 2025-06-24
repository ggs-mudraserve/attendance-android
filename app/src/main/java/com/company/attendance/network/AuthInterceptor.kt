package com.company.attendance.network

import com.company.attendance.utils.SessionManager
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    private val sessionManager: SessionManager
) : Interceptor {
    
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        
        // Skip auth for certain endpoints (health check, etc.)
        if (shouldSkipAuth(originalRequest.url.encodedPath)) {
            return chain.proceed(originalRequest)
        }
        
        // Get valid access token
        val accessToken = runBlocking {
            sessionManager.ensureValidSession()
        }
        
        if (accessToken == null) {
            // No valid token available, proceed without auth header
            // The API will return 401 and the app can handle it appropriately
            return chain.proceed(originalRequest)
        }
        
        // Add authorization header
        val authenticatedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $accessToken")
            .build()
        
        val response = chain.proceed(authenticatedRequest)
        
        // Handle 401 responses by attempting token refresh
        if (response.code == 401) {
            response.close()
            
            // Try to refresh token and retry
            val refreshedToken = runBlocking {
                sessionManager.refreshSessionIfNeeded()
                sessionManager.ensureValidSession()
            }
            
            if (refreshedToken != null && refreshedToken != accessToken) {
                // Retry with new token
                val retryRequest = originalRequest.newBuilder()
                    .header("Authorization", "Bearer $refreshedToken")
                    .build()
                
                return chain.proceed(retryRequest)
            }
        }
        
        return response
    }
    
    private fun shouldSkipAuth(path: String): Boolean {
        return path.contains("/healthz") || 
               path.contains("/public") ||
               path.contains("/auth/") // If you have auth endpoints that don't need tokens
    }
}