package com.kazemieh.www.shop.di

import com.kazemieh.www.shop.data.remote.ProductDetailApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ProductDetailApiModule {

    @Singleton
    @Provides
    fun provideProductDetailApiModule(retrofit: Retrofit): ProductDetailApi =
        retrofit.create(ProductDetailApi::class.java)
}