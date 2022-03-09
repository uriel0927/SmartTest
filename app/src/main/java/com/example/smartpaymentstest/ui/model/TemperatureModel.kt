package com.example.smartpaymentstest.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TemperatureModel (
    val day: Float,
    val min: Float,
    val max: Float,
    val night: Float,
    val eve : Float,
    val morn : Float
    ): Parcelable


