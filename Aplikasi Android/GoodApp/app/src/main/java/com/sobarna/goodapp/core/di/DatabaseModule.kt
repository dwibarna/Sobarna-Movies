package com.sobarna.goodapp.core.di

import android.content.Context
import androidx.room.Room
import com.sobarna.goodapp.core.data.source.local.room.MovieDao
import com.sobarna.goodapp.core.data.source.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
        MovieDatabase::class.java,
            "movie.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideTourismDao(database: MovieDatabase): MovieDao{
        return database.movieDao()
    }

}