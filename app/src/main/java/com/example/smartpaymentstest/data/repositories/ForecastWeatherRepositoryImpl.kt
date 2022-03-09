package com.example.smartpaymentstest.data.repositories

import com.example.smartpaymentstest.data.network.RemoteDataSource
import com.example.smartpaymentstest.data.network.model.NetworkResult
import javax.inject.Inject

class ForecastWeatherRepositoryImpl @Inject constructor(private val remoteDatasource : RemoteDataSource) : ForecastWeatherRepository {

    override suspend fun getForecastWeather(units: String, exclude: String, latitude : String, longitude : String) : NetworkResult =
        remoteDatasource.getClimate(unit = units , exclude = exclude, latitude = latitude, longitude=  longitude)


}