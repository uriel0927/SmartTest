package com.example.smartpaymentstest.data.network


import com.example.smartpaymentstest.data.network.model.NetworkResult
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiForecast: ApiForecast) :
    RemoteDataSource() {

    override suspend fun getClimate(
        units: String,
        exclude: String,
        latitude: String,
        longitude: String
    ): NetworkResult =
        safeApiCall {
            apiForecast.getForecastWeather(
                latitude = latitude,
                longitude = longitude,
                apiKey = "9da845bea0d45be2eb6fe09088705c79",
                exclude = exclude,
                units = units
            )
        }
}