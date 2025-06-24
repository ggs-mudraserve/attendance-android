package com.company.attendance.data.remote

import com.company.attendance.data.model.ApiResponse
import com.company.attendance.data.model.AttendanceRecord
import com.company.attendance.data.model.AttendanceSession
import com.company.attendance.data.model.HeartbeatRequest
import com.company.attendance.data.model.OnboardingRequest
import retrofit2.Response
import retrofit2.http.*

interface AttendanceApiService {
    
    @POST("onboard")
    suspend fun onboard(
        @Header("Authorization") authorization: String,
        @Header("X-Event-Id") eventId: String,
        @Body request: OnboardingRequest
    ): Response<ApiResponse<String>>
    
    @POST("in")
    suspend fun markIn(
        @Header("Authorization") authorization: String,
        @Header("X-Event-Id") eventId: String
    ): Response<ApiResponse<AttendanceSession>>
    
    @POST("out")
    suspend fun markOut(
        @Header("Authorization") authorization: String,
        @Header("X-Event-Id") eventId: String
    ): Response<ApiResponse<AttendanceSession>>
    
    @POST("heartbeat")
    suspend fun sendHeartbeat(
        @Header("Authorization") authorization: String,
        @Header("X-Event-Id") eventId: String,
        @Body request: HeartbeatRequest
    ): Response<ApiResponse<String>>
    
    @GET("attendance/{year}/{month}")
    suspend fun getMonthlyAttendance(
        @Header("Authorization") authorization: String,
        @Path("year") year: Int,
        @Path("month") month: Int
    ): Response<ApiResponse<List<AttendanceRecord>>>
    
    @GET("healthz")
    suspend fun healthCheck(): Response<ApiResponse<String>>
}