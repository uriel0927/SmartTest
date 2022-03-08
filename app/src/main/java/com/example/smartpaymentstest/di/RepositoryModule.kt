package com.example.smartpaymentstest.di


import com.example.smartpaymentstest.data.repositories.ForecastWeatherRepository
import com.example.smartpaymentstest.data.repositories.ForecastWeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun providesForecastWheaterRepository( forecastWeatherRepository: ForecastWeatherRepositoryImpl ) : ForecastWeatherRepository
}