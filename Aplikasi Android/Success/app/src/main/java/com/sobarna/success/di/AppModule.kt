package com.sobarna.success.di

import com.sobarna.success.core.domain.usecase.MovieInteract
import com.sobarna.success.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideMovieUseCase(movieInteract: MovieInteract) : MovieUseCase
}