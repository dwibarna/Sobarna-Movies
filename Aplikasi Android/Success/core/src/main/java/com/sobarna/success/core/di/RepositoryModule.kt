package com.sobarna.success.core.di

import com.sobarna.success.core.data.MovieRepository
import com.sobarna.success.core.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module(includes = [NetworkModule::class, com.sobarna.success.core.di.DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: com.sobarna.success.core.data.MovieRepository): IMovieRepository
}