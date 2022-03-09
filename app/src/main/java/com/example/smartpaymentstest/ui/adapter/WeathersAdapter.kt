package com.example.smartpaymentstest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartpaymentstest.data.network.model.Temperature
import com.example.smartpaymentstest.databinding.ItemWeatherBinding
import com.example.smartpaymentstest.ui.model.WeatherItemUI
import com.example.smartpaymentstest.ui.viewholder.WeatherViewholder

class WeathersAdapter(
    private var weathers: List<WeatherItemUI>,
    private val onItemSelected: (temperature: Temperature) -> Unit
) : RecyclerView.Adapter<WeatherViewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewholder {
        val bindingItem =
            ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewholder(bindingItem, onclickitem = onItemSelected)

    }

    override fun onBindViewHolder(holder: WeatherViewholder, position: Int) {
        val itemWeather = weathers[position]
        holder.onBind(itemWeather)
    }

    override fun getItemCount(): Int = weathers.size

    fun setData(items: List<WeatherItemUI>) {
        weathers = items
        notifyDataSetChanged()
    }
}