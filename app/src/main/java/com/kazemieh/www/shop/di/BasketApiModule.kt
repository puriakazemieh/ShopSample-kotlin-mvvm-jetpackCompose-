package com.kazemieh.www.shop.di

import com.kazemieh.www.shop.data.remote.BasketApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object BasketApiModule {

    @Provides
    @Singleton
    fun provideBasketApi(retrofit: Retrofit): BasketApi =
        retrofit.create(BasketApi::class.java)
}