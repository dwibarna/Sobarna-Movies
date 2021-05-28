package com.sobarna.goodapp.core.di

import android.content.Context
import com.sobarna.goodapp.core.domain.repository.IMovieRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)

interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : CoreComponent
    }

    fun provideRepository():IMovieRepository
}