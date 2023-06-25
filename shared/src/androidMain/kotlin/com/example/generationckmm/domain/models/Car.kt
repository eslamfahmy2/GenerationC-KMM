package com.example.generationckmm.domain.models

import java.io.Serializable


data class Car(
    val model: String = "",
    val plate_number: String = "",
    val brand: String = "",
    val unit_price: Double = 0.0,
    val currency: String = "",
    val color: String = "",
) : Serializable


