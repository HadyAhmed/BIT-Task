package com.hadi.bit_task.app

import android.app.Application
import com.hadi.bit_task.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree


class BitApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}