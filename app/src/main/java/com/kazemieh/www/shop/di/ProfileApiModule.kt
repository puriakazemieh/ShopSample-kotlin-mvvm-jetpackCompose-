package com.kazemieh.www.shop.di

import com.kazemieh.www.shop.data.remote.HomeApi
import com.kazemieh.www.shop.data.remote.ProfileApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileApiModule {

    @Provides
    @Singleton
    fun provideHomeApiInterface(retrofit: Retrofit): ProfileApi =
        retrofit.create(ProfileApi::class.java)


}