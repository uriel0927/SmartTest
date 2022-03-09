package com.example.smartpaymentstest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartpaymentstest.domain.GetForecastWeatherUseCase
import com.example.smartpaymentstest.domain.model.ResultUseCase
import com.example.smartpaymentstest.ui.model.WeatherUiSate
import com.example.smartpaymentstest.ui.model.WeatherItemUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val useCase: GetForecastWeatherUseCase) :
    ViewModel() {

    private var _uiState = MutableLiveData<WeatherUiSate>()
    val uiSate get() = _uiState
    fun getWheathers() {
        viewModelScope.launch {

            val listItemUi : MutableList<WeatherItemUI> = mutableListOf()
            val resultUseCase: ResultUseCase = useCase("33.4", "-94.04")

            when (resultUseCase) {
                is ResultUseCase.Failure -> { _uiState.value = WeatherUiSate.Error(resultUseCase.errorType) }
                is ResultUseCase.Success -> {
                    resultUseCase.weathers.daily.forEach { forecast ->

                        val date = Date(forecast.dateTime)
                        val format = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                        val strDate =  format.format(date)

                        val item = WeatherItemUI(
                            time = strDate,
                            weather = forecast.weather[0].main,
                            temperature = forecast.temp,

                        )
                        listItemUi.add(item)
                    }

                    _uiState.value = WeatherUiSate.ItemsLoaded(listItemUi)
                }
            }
        }

    }
}