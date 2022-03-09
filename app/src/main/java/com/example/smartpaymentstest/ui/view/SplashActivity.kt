package com.example.smartpaymentstest.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.example.smartpaymentstest.R
import com.example.smartpaymentstest.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var _binding : ActivitySplashBinding
    val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animationLottie.setAnimation(R.raw.splash)
        binding.animationLottie.playAnimation()

        CoroutineScope(Dispatchers.IO).launch {

            delay(3000)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()

        }

    }
}