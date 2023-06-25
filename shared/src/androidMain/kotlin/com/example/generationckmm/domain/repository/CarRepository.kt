package com.example.generationckmm.domain.repository

import com.example.generationckmm.domain.models.Car


interface CarRepository {
    suspend fun doSearchByColorAndPrice(color: String, price: String): List<Car>
}





