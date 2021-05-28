package com.sobarna.success.core.di

import android.content.Context
import androidx.room.Room
import com.sobarna.success.core.data.source.local.room.MovieDao
import com.sobarna.success.core.data.source.local.room.MovieDatabase
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
    fun provideDatabase(@ApplicationContext context : Context): com.sobarna.success.core.data.source.local.room.MovieDatabase {
        return Room.databaseBuilder(
            context,
            com.sobarna.success.core.data.source.local.room.MovieDatabase::class.java,
            "movie.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMovieDao(database: com.sobarna.success.core.data.source.local.room.MovieDatabase): com.sobarna.success.core.data.source.local.room.MovieDao {
        return database.movieDao()
    }
}