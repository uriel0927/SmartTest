package com.example.smartpaymentstest.data.repositories

import com.example.smartpaymentstest.data.network.model.NetworkResult

interface ForecastWeatherRepository {

    suspend fun getForecastWeather(units: String,exclude: String, latitude : String, longitude : String) : NetworkResult

}