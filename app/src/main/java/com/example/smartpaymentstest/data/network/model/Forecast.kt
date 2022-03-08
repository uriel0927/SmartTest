package com.example.smartpaymentstest.data.network.model

import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("dt") val dateTime: Long,
    val sunrise: Long,
    val sunset: Long,
    @SerializedName("temp")val list : Temperature
)


