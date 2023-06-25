package com.example.generationckmm.android.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


//generic function to decode jason from desired class type
inline fun <reified T> Gson.fromJson(json: String): T =
    fromJson(json, object : TypeToken<T>() {}.type)
