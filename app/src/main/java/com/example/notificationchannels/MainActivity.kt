package com.example.notificationchannels

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNotificationChannels()
    }

    private fun setUpNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                "FOLLOWERS_CHANNEL_ID",
                "Followers",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.description = " This is for followers"
            val notificationManager: NotificationManager? =
                getSystemService(Context.NOTIFICATION_SERVICE) as? (NotificationManager)
            notificationManager?.createNotificationChannel(notificationChannel)

            /**
             *
             * Channel group
             *
             */

            val workGroupChannel = NotificationChannel(
                "WorkGroup_channel_id",
                "Video Call",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val workId = "personal_id"
            val workGroupName = "Personal"
            notificationManager?.createNotificationChannelGroup(
                NotificationChannelGroup(
                    workId,
                    workGroupName
                )
            )
            workGroupChannel.group = workId


        }
    }
}