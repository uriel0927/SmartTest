package com.example.smartpaymentstest.data.repositories

import com.example.smartpaymentstest.data.network.model.ApiListResponse
import com.example.smartpaymentstest.data.network.model.Daily
import com.example.smartpaymentstest.data.network.model.NetworkResult

interface ForecastWeatherRepository {

    suspend fun getForecastWeather(exclude: String, latitude : String, longitude : String) : NetworkResult

}