package com.example.android.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule{

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): AppDatabase{
        return Room.databaseBuilder(applicationContext,
                AppDatabase::class.java,
                "logging.db")
            .build()
    }

    @Provides
    fun provideLogDao(appDatabase: AppDatabase): LogDao{
        return appDatabase.logDao()
    }
}