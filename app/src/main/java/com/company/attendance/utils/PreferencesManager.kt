package com.company.attendance.utils

import android.content.Context
import android.content.SharedPreferences
import com.company.attendance.utils.Constants.DEFAULT_SERVER_IP
import com.company.attendance.utils.Constants.DEFAULT_SERVER_PORT
import com.company.attendance.utils.Constants.PREFS_NAME
import com.company.attendance.utils.Constants.PREF_DEVICE_UUID
import com.company.attendance.utils.Constants.PREF_IS_ONBOARDED
import com.company.attendance.utils.Constants.PREF_LAST_HEARTBEAT
import com.company.attendance.utils.Constants.PREF_SERVER_IP
import com.company.attendance.utils.Constants.PREF_SERVER_PORT
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(context: Context) {
    
    private val sharedPreferences: SharedPreferences = 
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    
    var serverIp: String
        get() = sharedPreferences.getString(PREF_SERVER_IP, DEFAULT_SERVER_IP) ?: DEFAULT_SERVER_IP
        set(value) = sharedPreferences.edit().putString(PREF_SERVER_IP, value).apply()
    
    var serverPort: Int
        get() = sharedPreferences.getInt(PREF_SERVER_PORT, DEFAULT_SERVER_PORT)
        set(value) = sharedPreferences.edit().putInt(PREF_SERVER_PORT, value).apply()
    
    var deviceUuid: String?
        get() = sharedPreferences.getString(PREF_DEVICE_UUID, null)
        set(value) = sharedPreferences.edit().putString(PREF_DEVICE_UUID, value).apply()
    
    var isOnboarded: Boolean
        get() = sharedPreferences.getBoolean(PREF_IS_ONBOARDED, false)
        set(value) = sharedPreferences.edit().putBoolean(PREF_IS_ONBOARDED, value).apply()
    
    var lastHeartbeat: Long
        get() = sharedPreferences.getLong(PREF_LAST_HEARTBEAT, 0L)
        set(value) = sharedPreferences.edit().putLong(PREF_LAST_HEARTBEAT, value).apply()
    
    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}