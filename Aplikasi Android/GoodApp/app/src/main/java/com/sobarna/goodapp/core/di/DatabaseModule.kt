package com.sobarna.goodapp.core.di

import android.content.Context
import androidx.room.Room
import com.sobarna.goodapp.core.data.source.local.room.MovieDao
import com.sobarna.goodapp.core.data.source.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MovieDatabase {
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