package com.goranm.runningappmvvm.services

import android.content.Intent
import androidx.lifecycle.LifecycleService
import com.goranm.runningappmvvm.other.Constanst
import timber.log.Timber

class TrackingService : LifecycleService(){

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action){
                Constanst.ACTION_START_OR_RESUME_SERVICE -> {
                    Timber.d("Started or resumed service")
                }
                Constanst.ACTION_PAUSE_SERVICE -> {
                    Timber.d("Paused service")
                }
                Constanst.ACTION_STOP_SERVICE -> {
                    Timber.d("Stoped service")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

}