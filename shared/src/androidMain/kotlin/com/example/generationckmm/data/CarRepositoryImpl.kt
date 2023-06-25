package com.example.generationckmm.data

import com.example.generationckmm.data.source.LocalFileDataSource
import com.example.generationckmm.data.wrappers.NoMatchingExceptionException
import com.example.generationckmm.data.wrappers.unwrapResponse
import com.example.generationckmm.domain.models.Car
import com.example.generationckmm.domain.repository.CarRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


class CarRepositoryImpl(
    private val localDataSource: LocalFileDataSource,
    private val dispatcher: CoroutineDispatcher
) : CarRepository {

    override suspend fun doSearchByColorAndPrice(color: String, price: String): List<Car> =
        withContext(dispatcher) {
            //read file
            val carsList = unwrapResponse(localDataSource.readFileToJson())
            //filter conditions
            if (color.isEmpty() && price.isEmpty()) {
                carsList.ifEmpty { throw NoMatchingExceptionException }
                return@withContext carsList
            }
            val filteredByPrice: MutableList<Car> = carsList.toMutableList()
            if (price.isNotEmpty()) {
                filteredByPrice.clear()
                filteredByPrice.addAll(
                    carsList.filter {
                        it.unit_price <= price.toDouble()
                    }
                )
            }
            val filteredByColor = filteredByPrice.filter {
                it.color.lowercase().contains(color.lowercase())
            }
            if (filteredByColor.isEmpty()) {
                throw NoMatchingExceptionException
            }
            return@withContext filteredByColor
        }
}
