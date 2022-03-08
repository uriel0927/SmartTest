package com.example.smartpaymentstest.domain

import com.example.smartpaymentstest.data.network.model.Daily
import com.example.smartpaymentstest.data.repositories.ForecastWeatherRepository
import javax.inject.Inject

class GetForecastWeatherUseCase @Inject constructor(private val repository: ForecastWeatherRepository) {


    suspend operator fun invoke(latitude : String, longitude : String) : Daily?{
        val result = repository.getForecastWeather(exclude = "hourly,minutely,alerts,current", latitude =latitude , longitude = longitude )

        if(result.isError){
            return null
        }else{
            return result.requiredResult

        }


    }

}