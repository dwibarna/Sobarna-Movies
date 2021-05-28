package com.sobarna.success.di

import com.sobarna.success.core.di.CoreComponent
import com.sobarna.success.view.DetailActivity
import com.sobarna.success.view.FavoriteFragment
import com.sobarna.success.view.MovieFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(coreComponent: CoreComponent) : AppComponent
    }

    fun inject(fragment : MovieFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailActivity)

}