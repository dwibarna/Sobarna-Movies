package com.sobarna.goodapp.di

import com.sobarna.goodapp.core.domain.usecase.MovieInteract
import com.sobarna.goodapp.core.domain.usecase.MovieUseCase
import dagger.Binds
import dagger.Module


@Module
abstract class AppModule {

    @Binds
    abstract fun provideMovieUseCase(movieInteract: MovieInteract): MovieUseCase
}