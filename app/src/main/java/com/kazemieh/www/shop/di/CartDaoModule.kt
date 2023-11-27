package com.kazemieh.www.shop.di

import com.kazemieh.www.shop.db.CartDao
import com.kazemieh.www.shop.db.ShopDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CartDaoModule {

    @Provides
    @Singleton
    fun provideCartDao(
        database: ShopDatabase
    ): CartDao = database.cartDao()
}