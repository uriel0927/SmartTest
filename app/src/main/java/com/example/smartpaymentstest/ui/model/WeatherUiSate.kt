package com.example.smartpaymentstest.ui.model

import com.example.smartpaymentstest.data.network.model.NetworkErrorType

sealed class WeatherUiSate{

    data class ItemsLoaded(val items : List<WeatherItemUI>) : WeatherUiSate()
    object Loading : WeatherUiSate()
    data class Error(val errorType : NetworkErrorType) : WeatherUiSate()

}
