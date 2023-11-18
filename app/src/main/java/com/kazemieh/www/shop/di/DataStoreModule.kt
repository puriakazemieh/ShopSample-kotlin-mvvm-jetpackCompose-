package com.kazemieh.www.shop.di

import android.content.Context
import com.kazemieh.www.shop.data.datastore.DataStoreRepository
import com.kazemieh.www.shop.data.datastore.DataStoryRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ): DataStoreRepository = DataStoryRepositoryImp(context)
}