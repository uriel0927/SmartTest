package com.example.smartpaymentstest.domain

import com.example.smartpaymentstest.data.network.model.Daily
import com.example.smartpaymentstest.data.network.model.NetworkErrorType
import com.example.smartpaymentstest.data.repositories.ForecastWeatherRepository
import com.example.smartpaymentstest.domain.model.ResultUseCase
import javax.inject.Inject

class GetForecastWeatherUseCase @Inject constructor(private val repository: ForecastWeatherRepository) {

    suspend operator fun invoke(latitude: String, longitude: String): ResultUseCase {
        val result = repository.getForecastWeather(
            units = "metric",
            exclude = "hourly,minutely,alerts,current",
            latitude = latitude,
            longitude = longitude
        )

        return if (result.isError) {
            val error = result.requiredError
            ResultUseCase.Failure(error.type)
        } else {
            ResultUseCase.Success(result.requiredResult)
        }

    }

}