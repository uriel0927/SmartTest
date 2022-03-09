package com.example.smartpaymentstest.ui.viewholder


import androidx.recyclerview.widget.RecyclerView
import com.example.smartpaymentstest.R
import com.example.smartpaymentstest.data.network.model.Temperature
import com.example.smartpaymentstest.databinding.ItemWeatherBinding
import com.example.smartpaymentstest.ui.model.WeatherItemUI

class WeatherViewholder(private val itemWeatherBinding: ItemWeatherBinding, val onclickitem : (temperature : Temperature) -> Unit) : RecyclerView.ViewHolder(itemWeatherBinding.root) {

    fun onBind(weatherItemUI: WeatherItemUI){
        itemWeatherBinding.tvDay.text = weatherItemUI.time
        itemWeatherBinding.tvWeather.text = weatherItemUI.weather

        when(weatherItemUI.weather){
            "Rain" ->{itemWeatherBinding.imageView.setImageResource(R.drawable.rainy)}
            "Clear" ->{itemWeatherBinding.imageView.setImageResource(R.drawable.sun)}
            "Snow" ->{itemWeatherBinding.imageView.setImageResource(R.drawable.snowy)}
        }

        itemWeatherBinding.root.setOnClickListener {
            onclickitem(weatherItemUI.temperature)
        }
    }

}