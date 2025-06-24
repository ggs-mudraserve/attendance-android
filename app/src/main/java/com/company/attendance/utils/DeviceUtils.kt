package com.company.attendance.utils

import android.content.Context
import android.provider.Settings
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeviceUtils @Inject constructor(
    private val context: Context
) {
    
    fun generateDeviceUuid(): String {
        val androidId = Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ANDROID_ID
        )
        
        return if (androidId.isNotBlank() && androidId != "9774d56d682e549c") {
            UUID.nameUUIDFromBytes(androidId.toByteArray()).toString()
        } else {
            UUID.randomUUID().toString()
        }
    }
    
    fun getAppVersion(): String {
        return try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            packageInfo.versionName ?: "Unknown"
        } catch (e: Exception) {
            "Unknown"
        }
    }
    
    fun getAppVersionCode(): Long {
        return try {
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            packageInfo.longVersionCode
        } catch (e: Exception) {
            0L
        }
    }
}