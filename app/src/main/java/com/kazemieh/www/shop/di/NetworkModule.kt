package com.kazemieh.www.shop.di

import com.kazemieh.www.shop.data.remote.HomeApiInterface
import com.kazemieh.www.shop.util.Constants.BASE_URL
import com.kazemieh.www.shop.util.Constants.NETWORK_TIME_OUT_SECOND
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    internal fun interceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(NETWORK_TIME_OUT_SECOND, TimeUnit.SECONDS)
        .readTimeout(NETWORK_TIME_OUT_SECOND, TimeUnit.SECONDS)
        .writeTimeout(NETWORK_TIME_OUT_SECOND, TimeUnit.SECONDS)
        .addInterceptor(interceptor())
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


}