package com.example.generationckmm.android.presentation

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.example.generationckmm.android.utils.ApplicationContextSingleton
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class AppApplication : Application(), LifecycleObserver {
    override fun onCreate() {
        super.onCreate()
        ApplicationContextSingleton.initialize(application = this)
    }
}