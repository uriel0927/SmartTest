package com.example.smartpaymentstest.data.network

import com.example.smartpaymentstest.data.network.model.Daily
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiForecast {

    @GET("onecall")
    suspend fun  getForecastWeather(@Query("lat")  latitude : String,
                            @Query("lon")  longitude : String,
                            @Query("appid")  apiKey : String,
                            @Query("exclude")  exclude  : String,
                            @Query("units")  units  : String): Daily


}