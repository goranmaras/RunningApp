package com.goranm.runningappmvvm.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.goranm.runningappmvvm.R
import com.goranm.runningappmvvm.other.Constanst
import com.goranm.runningappmvvm.other.Constanst.ACTION_SHOW_TRACKING_FRAGMENT
import com.goranm.runningappmvvm.other.Constanst.NOTIFICATION_CHANNEL_ID
import com.goranm.runningappmvvm.other.Constanst.NOTIFICATION_CHANNEL_NAME
import com.goranm.runningappmvvm.other.Constanst.NOTIFICATION_ID
import com.goranm.runningappmvvm.ui.MainActivity
import timber.log.Timber

class TrackingService : LifecycleService(){

    var isFirstRun = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action){
                Constanst.ACTION_START_OR_RESUME_SERVICE -> {
                    if (isFirstRun){
                        startForegroundService()
                        isFirstRun = false
                    }else{
                        Timber.d("Resuming service...")
                    }
                }
                Constanst.ACTION_PAUSE_SERVICE -> {
                    Timber.d("Paused service")
                }
                Constanst.ACTION_STOP_SERVICE -> {
                    Timber.d("Stopped service")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForegroundService(){

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotifyChannel(notificationManager)
        }

        val notifyBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
            .setContentTitle("Running App")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingIntent())

        startForeground(NOTIFICATION_ID, notifyBuilder.build())
    }

    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
        this,0,
        Intent(this,MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        },
        FLAG_UPDATE_CURRENT
    )

    private fun createNotifyChannel(notificationManager: NotificationManager){
        val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)

    }

}