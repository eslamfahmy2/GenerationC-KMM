package com.example.generationckmm.data.source

import android.content.res.AssetManager
import com.google.gson.Gson
import com.example.generationckmm.data.wrappers.JsResponseWrapper
import com.example.generationckmm.data.wrappers.fromJson
import com.example.generationckmm.domain.models.Car
import javax.inject.Inject


const val FILE_SUCCESS_NAME = "cars-success.json"
const val FILE_FAIL_NAME = "cars-fail.json"

interface LocalFileDataSource {
    suspend fun readFileToJson(): JsResponseWrapper<List<Car>>
}

class LocalFileImpl @Inject constructor(
    private val assetManager: AssetManager
) : LocalFileDataSource {

    override suspend fun readFileToJson(): JsResponseWrapper<List<Car>> {
        //read file
        val rawData = assetManager.open(FILE_SUCCESS_NAME)
            .bufferedReader()
            .use { it.readText() }
        //convert text to json
        return Gson().fromJson<JsResponseWrapper<List<Car>>>(rawData)
    }

}