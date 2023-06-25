package com.example.generationckmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform