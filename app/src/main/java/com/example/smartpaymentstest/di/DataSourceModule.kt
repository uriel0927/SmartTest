package com.example.smartpaymentstest.di

import com.example.smartpaymentstest.data.network.RemoteDataSource
import com.example.smartpaymentstest.data.network.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun providesRemoteDataSource( remoteDataSourceImpl: RemoteDataSourceImpl) : RemoteDataSource

}