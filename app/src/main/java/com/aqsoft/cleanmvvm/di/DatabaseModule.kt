package com.aqsoft.cleanmvvm.di

import android.app.Application
import androidx.room.Room
import com.aqsoft.cleanmvvm.data.source.local.ApplicationDatabase
import com.aqsoft.cleanmvvm.data.source.local.dao.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    internal fun provideApplicationDatabase(application: Application): ApplicationDatabase {
        return Room.databaseBuilder(
            application,
            ApplicationDatabase::class.java,
            ApplicationDatabase.DATABASE_NAME
        ).allowMainThreadQueries().build()
    }

    @Provides
    internal fun provideRemedyDao(appDatabase: ApplicationDatabase): ItemDao{
        return appDatabase.itemDao
    }
}