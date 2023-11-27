package com.kazemieh.www.shop.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kazemieh.www.shop.db.ShopDatabase
import com.kazemieh.www.shop.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context = context, ShopDatabase::class.java,DATABASE_NAME).build()
}