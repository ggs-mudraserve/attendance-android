package com.company.attendance.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.company.attendance.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationUtils @Inject constructor(
    private val context: Context
) {
    
    companion object {
        const val CHANNEL_ID_HEARTBEAT = "heartbeat_channel"
        const val CHANNEL_ID_HEARTBEAT_STATUS = "heartbeat_status_channel"
        const val NOTIFICATION_ID_HEARTBEAT = 1001
        const val NOTIFICATION_ID_HEARTBEAT_SUCCESS = 1002
        const val NOTIFICATION_ID_HEARTBEAT_ERROR = 1003
        
        fun createNotificationChannels(context: Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                
                // Heartbeat service channel
                val heartbeatChannel = NotificationChannel(
                    CHANNEL_ID_HEARTBEAT,
                    context.getString(R.string.notification_channel_heartbeat),
                    NotificationManager.IMPORTANCE_LOW
                ).apply {
                    description = "Ongoing notification for attendance monitoring"
                    setShowBadge(false)
                }
                
                // Heartbeat status channel
                val statusChannel = NotificationChannel(
                    CHANNEL_ID_HEARTBEAT_STATUS,
                    "Heartbeat Status",
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description = "Notifications for heartbeat success/failure status"
                    setShowBadge(true)
                }
                
                notificationManager.createNotificationChannels(listOf(heartbeatChannel, statusChannel))
            }
        }
    }
    
    fun createHeartbeatNotification(): android.app.Notification {
        return NotificationCompat.Builder(context, CHANNEL_ID_HEARTBEAT)
            .setContentTitle(context.getString(R.string.notification_heartbeat_title))
            .setContentText(context.getString(R.string.notification_heartbeat_text))
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .setSilent(true)
            .setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
            .build()
    }
    
    fun showHeartbeatSuccessNotification(title: String, message: String) {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID_HEARTBEAT_STATUS)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
            
        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID_HEARTBEAT_SUCCESS, notification)
    }
    
    fun showHeartbeatErrorNotification(title: String, message: String) {
        val notification = NotificationCompat.Builder(context, CHANNEL_ID_HEARTBEAT_STATUS)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setStyle(NotificationCompat.BigTextStyle().bigText(message))
            .build()
            
        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID_HEARTBEAT_ERROR, notification)
    }
    
    fun dismissHeartbeatNotifications() {
        NotificationManagerCompat.from(context).apply {
            cancel(NOTIFICATION_ID_HEARTBEAT_SUCCESS)
            cancel(NOTIFICATION_ID_HEARTBEAT_ERROR)
        }
    }
}