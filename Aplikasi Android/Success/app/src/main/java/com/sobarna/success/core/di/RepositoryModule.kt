package com.sobarna.success.core.di

import com.sobarna.success.core.data.MovieRepository
import com.sobarna.success.core.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module


@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IMovieRepository
}