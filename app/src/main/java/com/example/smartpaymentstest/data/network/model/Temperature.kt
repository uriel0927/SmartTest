package com.example.smartpaymentstest.data.network.model

import com.example.smartpaymentstest.ui.model.TemperatureModel

data class Temperature(
    val day: Float,
    val min: Float,
    val max: Float,
    val night: Float,
    val eve: Float,
    val morn: Float
)


fun Temperature.toTemperatureModel(): TemperatureModel? =
    TemperatureModel(day = day, min = min, max = max, night = night, eve = eve, morn = morn)
