package com.sobarna.goodapp.core.di

import com.sobarna.goodapp.core.data.MovieRepository
import com.sobarna.goodapp.core.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module


@Module(includes = [NetworkModule::class,DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepository: MovieRepository): IMovieRepository
}