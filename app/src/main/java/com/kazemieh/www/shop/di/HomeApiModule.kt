package com.kazemieh.www.shop.di

import com.kazemieh.www.shop.data.remote.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeApiModule {

    @Provides
    @Singleton
    fun provideHomeApiInterface(retrofit: Retrofit): HomeApi =
        retrofit.create(HomeApi::class.java)


}