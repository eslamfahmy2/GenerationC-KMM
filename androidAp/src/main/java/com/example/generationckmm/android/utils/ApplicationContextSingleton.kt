package com.example.generationckmm.android.utils

import com.example.generationckmm.android.presentation.AppApplication


//@Singleton
object ApplicationContextSingleton {

    lateinit var appApplicationContext: AppApplication

    fun initialize(application: AppApplication) {
        appApplicationContext = application
    }

    fun getString(stringId: Int): String {
        return appApplicationContext.getString(stringId)
    }

    fun getString(stringId: Int, stringArgument: String): String {
        return appApplicationContext.getString(stringId, stringArgument)
    }

}