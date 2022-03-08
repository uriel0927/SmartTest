package com.example.smartpaymentstest.di

import com.example.smartpaymentstest.BuildConfig
import com.example.smartpaymentstest.data.network.ApiForecast
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit (): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
                ).build()

    @Singleton
    @Provides
    fun providesApiForecastService(retorfit : Retrofit) : ApiForecast =
        retorfit.create(ApiForecast::class.java)

}