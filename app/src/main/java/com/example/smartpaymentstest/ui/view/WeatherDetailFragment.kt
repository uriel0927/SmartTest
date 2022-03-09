package com.example.smartpaymentstest.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.smartpaymentstest.R
import com.example.smartpaymentstest.databinding.FragmentWheaterDetailBinding

class WeatherDetailFragment : Fragment(R.layout.fragment_wheater_detail) {

    private lateinit var _binding : FragmentWheaterDetailBinding
    val binding get() = _binding

    val argumentos : WeatherDetailFragmentArgs by navArgs()

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWheaterDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment)

        val max = argumentos.temperature.max
        val min = argumentos.temperature.min
        val morn = argumentos.temperature.morn
        val night = argumentos.temperature.night

        binding.tvMax.text = getString(R.string.str_max,max.toString())
        binding.tvMin.text = getString(R.string.str_min,min.toString())
        binding.tvMorn.text = getString(R.string.str_morning,morn.toString())
        binding.tvNigth.text = getString(R.string.str_nigth,night.toString())


        binding.button.setOnClickListener {
            navController.popBackStack()
        }

    }

}