package com.dontsu.servicetest

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import timber.log.Timber

class MyService : Service() {

    val binder = MyBinder()

    inner class MyBinder : Binder() {
        fun getService(): MyService {
            return this@MyService
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        Timber.d("--- StartedService : action = $action")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
       return binder
    }

    override fun onDestroy() {
        Timber.d("--- Service :  서비스가 종료되었습니다.")
        super.onDestroy()
    }

    fun serviceMessage() : String {
        return "Hello Activity! I am Service!"
    }

    companion object {
        val ACTION_START = "com.dontsu.servicetest.START"
        val ACTION_RUN = "com.dontsu.servicetest.RUM"
        val ACTION_STOP = "com.dontsu.servicetest.STOP"
    }



}
