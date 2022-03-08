package com.example.smartpaymentstest.data.network


import com.example.smartpaymentstest.BuildConfig
import com.example.smartpaymentstest.data.network.model.ApiListResponse
import com.example.smartpaymentstest.data.network.model.Daily
import com.example.smartpaymentstest.data.network.model.Forecast
import com.example.smartpaymentstest.data.network.model.NetworkResult
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiForecast: ApiForecast) :
    RemoteDataSource() {

    override suspend fun getClimate(
        exclude: String,
        latitude: String,
        longitude: String
    ): NetworkResult =
        safeApiCall {
            apiForecast.getForecastWeather(
                latitude = latitude,
                longitude = longitude,
                apiKey = BuildConfig.APIKEY,
                exclude = exclude
            )
        }
}