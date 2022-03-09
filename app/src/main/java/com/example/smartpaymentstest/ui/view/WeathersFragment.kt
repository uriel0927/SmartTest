package com.example.smartpaymentstest.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartpaymentstest.R
import com.example.smartpaymentstest.data.network.model.NetworkErrorType
import com.example.smartpaymentstest.data.network.model.Temperature
import com.example.smartpaymentstest.data.network.model.toTemperatureModel
import com.example.smartpaymentstest.databinding.FragmentWeatherBinding
import com.example.smartpaymentstest.ui.adapter.WeathersAdapter
import com.example.smartpaymentstest.ui.model.WeatherUiSate
import com.example.smartpaymentstest.ui.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeathersFragment : Fragment(R.layout.fragment_weather) {

    private lateinit var _binding : FragmentWeatherBinding
    val binding get() = _binding

    private val viewmodel : WeatherViewModel by viewModels()

    private lateinit var adapter : WeathersAdapter

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel.uiSate.observe(this,::observerUiSate)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment)

        adapter = WeathersAdapter(mutableListOf(),::onselectedItem)
        binding.rvWeather.layoutManager = LinearLayoutManager(requireContext())
        binding.rvWeather.adapter = adapter

        viewmodel.getWheathers()
    }

    fun onselectedItem(temperature: Temperature){

        val action = WeathersFragmentDirections.actionWeathersFragmentToWeatherDetailFragment(temperature.toTemperatureModel()!!)
        navController.navigate(action)

    }

    fun observerUiSate(uiState : WeatherUiSate){
        when(uiState){
            is WeatherUiSate.Loading->{}
            is WeatherUiSate.ItemsLoaded->{
                adapter.setData(uiState.items)
            }
            is WeatherUiSate.Error->{
                when(uiState.errorType){
                    NetworkErrorType.CONNECTION_ERROR->{
                        showMessageError(getString(R.string.str_message_error_network))
                    }
                    NetworkErrorType.UNKNOWN_ERROR->{
                        showMessageError(getString(R.string.str_message_error_desconocido))
                    }
                    NetworkErrorType.API_ERROR->{
                        showMessageError(getString(R.string.str_message_error_api))
                    }
                }
            }
        }

    }

    private fun showMessageError(message : String) {
        Toast.makeText(requireContext(), message , Toast.LENGTH_LONG).show()
    }


}


