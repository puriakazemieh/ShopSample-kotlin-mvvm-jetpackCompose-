package com.kazemieh.www.shop.di

import com.kazemieh.www.shop.data.remote.AddressApi
import com.kazemieh.www.shop.data.remote.CheckoutApi
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
object AddressApiModule {

    @Provides
    @Singleton
    fun provideCheckoutApiInterface(retrofit: Retrofit): AddressApi =
        retrofit.create(AddressApi::class.java)


}