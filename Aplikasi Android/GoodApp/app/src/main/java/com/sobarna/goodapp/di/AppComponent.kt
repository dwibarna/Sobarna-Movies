package com.sobarna.goodapp.di

import com.sobarna.goodapp.core.di.CoreComponent
import com.sobarna.goodapp.view.DetailActivity
import com.sobarna.goodapp.view.FavoriteFragment
import com.sobarna.goodapp.view.MovieFragment
import dagger.Component


@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)

interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(coreComponent: CoreComponent):AppComponent
    }

    fun inject(fragment: MovieFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailActivity)

}