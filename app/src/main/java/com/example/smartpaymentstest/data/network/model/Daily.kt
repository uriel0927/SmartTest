package com.example.smartpaymentstest.data.network.model

import com.google.gson.annotations.SerializedName

data class Daily (
    val lat : Float,
    val lon : Float,
    val timezone : String,
    @SerializedName("timezone_offset")val timezoneOffset : Long,
    val daily : List<Forecast>
     )