package com.company.attendance.di

import android.content.Context
import androidx.room.Room
import com.company.attendance.data.local.AttendanceDatabase
import com.company.attendance.data.local.QueuedRequestDao
import com.company.attendance.data.remote.AttendanceApiService
import com.company.attendance.data.repository.AttendanceRepository
import com.company.attendance.data.repository.AttendanceRepositoryImpl
import com.company.attendance.utils.Constants
import com.company.attendance.utils.DeviceUtils
import com.company.attendance.utils.PreferencesManager
import com.company.attendance.utils.WiFiValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
// Temporarily removing Supabase modules until configuration is resolved
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return try {
            createSupabaseClient(
                supabaseUrl = Constants.SUPABASE_URL,
                supabaseKey = Constants.SUPABASE_ANON_KEY
            ) {
                install(io.github.jan.supabase.gotrue.Auth)
                install(io.github.jan.supabase.postgrest.Postgrest)
            }
        } catch (e: Exception) {
            android.util.Log.e("AppModule", "Failed to create Supabase client", e)
            // Return a minimal client for testing
            createSupabaseClient(
                supabaseUrl = "https://example.supabase.co",
                supabaseKey = "fake-key"
            ) {
                // Empty builder for fallback
            }
        }
    }
    
    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: com.company.attendance.network.AuthInterceptor
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(Constants.REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(Constants.REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(Constants.REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .build()
    }
    
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        preferencesManager: PreferencesManager
    ): Retrofit {
        val baseUrl = "http://${preferencesManager.serverIp}:${preferencesManager.serverPort}/"
        
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    @Provides
    @Singleton
    fun provideAttendanceApiService(retrofit: Retrofit): AttendanceApiService {
        return retrofit.create(AttendanceApiService::class.java)
    }
    
    @Provides
    @Singleton
    fun provideAttendanceDatabase(@ApplicationContext context: Context): AttendanceDatabase {
        return Room.databaseBuilder(
            context,
            AttendanceDatabase::class.java,
            Constants.DATABASE_NAME
        ).fallbackToDestructiveMigration() // Add migration strategy for version change
        .build()
    }
    
    @Provides
    @Singleton
    fun provideQueuedRequestDao(database: AttendanceDatabase): QueuedRequestDao {
        return database.queuedRequestDao()
    }
    
    @Provides
    @Singleton
    fun provideApprovedWiFiDao(database: AttendanceDatabase): com.company.attendance.data.local.ApprovedWiFiDao {
        return database.approvedWiFiDao()
    }
    
    @Provides
    @Singleton
    fun providePreferencesManager(@ApplicationContext context: Context): PreferencesManager {
        return PreferencesManager(context)
    }
    
    @Provides
    @Singleton
    fun provideDeviceUtils(@ApplicationContext context: Context): DeviceUtils {
        return DeviceUtils(context)
    }
    
    @Provides
    @Singleton
    fun providePermissionHandler(@ApplicationContext context: Context): com.company.attendance.utils.PermissionHandler {
        return com.company.attendance.utils.PermissionHandler(context)
    }
    
    @Provides
    @Singleton
    fun provideWiFiMonitoringService(
        @ApplicationContext context: Context,
        approvedWiFiDao: com.company.attendance.data.local.ApprovedWiFiDao
    ): com.company.attendance.service.WiFiMonitoringService {
        return com.company.attendance.service.WiFiMonitoringService(context, approvedWiFiDao)
    }
    
    @Provides
    @Singleton
    fun provideWiFiValidator(
        @ApplicationContext context: Context,
        wifiMonitoringService: com.company.attendance.service.WiFiMonitoringService
    ): WiFiValidator {
        return WiFiValidator(context, wifiMonitoringService)
    }
    
    @Provides
    @Singleton
    fun provideSessionManager(
        authRepository: com.company.attendance.data.repository.AuthRepository
    ): com.company.attendance.utils.SessionManager {
        return com.company.attendance.utils.SessionManager(authRepository)
    }
    
    @Provides
    @Singleton
    fun provideAuthInterceptor(
        sessionManager: com.company.attendance.utils.SessionManager
    ): com.company.attendance.network.AuthInterceptor {
        return com.company.attendance.network.AuthInterceptor(sessionManager)
    }
    
    @Provides
    @Singleton
    fun provideNavigationHelper(): com.company.attendance.utils.NavigationHelper {
        return com.company.attendance.utils.NavigationHelper
    }
    
    @Provides
    @Singleton
    fun provideNotificationUtils(@ApplicationContext context: Context): com.company.attendance.utils.NotificationUtils {
        return com.company.attendance.utils.NotificationUtils(context)
    }
    
    @Provides
    @Singleton
    fun provideWorkManagerService(
        @ApplicationContext context: Context,
        notificationUtils: com.company.attendance.utils.NotificationUtils
    ): com.company.attendance.service.WorkManagerService {
        return com.company.attendance.service.WorkManagerService(context, notificationUtils)
    }
    
    @Provides
    @Singleton
    fun provideAuthRepository(
        supabaseClient: SupabaseClient,
        preferencesManager: PreferencesManager
    ): com.company.attendance.data.repository.AuthRepository {
        return com.company.attendance.data.repository.AuthRepositoryImpl(
            supabaseClient = supabaseClient,
            preferencesManager = preferencesManager
        )
    }
    
    @Provides
    @Singleton
    fun provideAttendanceRecordDao(database: AttendanceDatabase): com.company.attendance.data.local.AttendanceRecordDao {
        return database.attendanceRecordDao()
    }
    
    @Provides
    @Singleton
    fun provideNetworkUtils(@ApplicationContext context: Context): com.company.attendance.utils.NetworkUtils {
        return com.company.attendance.utils.NetworkUtils(context)
    }
    
    @Provides
    @Singleton
    fun provideGson(): com.google.gson.Gson {
        return com.google.gson.Gson()
    }
    
    @Provides
    @Singleton
    fun provideRequestQueueManager(
        queuedRequestDao: QueuedRequestDao,
        apiService: AttendanceApiService,
        supabaseClient: SupabaseClient,
        networkUtils: com.company.attendance.utils.NetworkUtils,
        gson: com.google.gson.Gson
    ): com.company.attendance.service.RequestQueueManager {
        return com.company.attendance.service.RequestQueueManager(
            queuedRequestDao = queuedRequestDao,
            apiService = apiService,
            supabaseClient = supabaseClient,
            networkUtils = networkUtils,
            gson = gson
        )
    }
    
    @Provides
    @Singleton
    fun provideAttendanceRepository(
        supabaseClient: SupabaseClient,
        apiService: AttendanceApiService,
        queuedRequestDao: QueuedRequestDao,
        preferencesManager: PreferencesManager,
        deviceUtils: DeviceUtils,
        wifiValidator: WiFiValidator,
        wifiMonitoringService: com.company.attendance.service.WiFiMonitoringService,
        requestQueueManager: com.company.attendance.service.RequestQueueManager,
        attendanceRecordDao: com.company.attendance.data.local.AttendanceRecordDao
    ): AttendanceRepository {
        return AttendanceRepositoryImpl(
            supabaseClient = supabaseClient,
            apiService = apiService,
            queuedRequestDao = queuedRequestDao,
            preferencesManager = preferencesManager,
            deviceUtils = deviceUtils,
            wifiValidator = wifiValidator,
            wifiMonitoringService = wifiMonitoringService,
            requestQueueManager = requestQueueManager,
            attendanceRecordDao = attendanceRecordDao
        )
    }
}