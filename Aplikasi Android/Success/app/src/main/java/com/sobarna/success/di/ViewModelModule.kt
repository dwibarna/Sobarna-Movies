package com.sobarna.success.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sobarna.success.core.ui.ViewModelFactory
import com.sobarna.success.viewmodel.DetailViewModel
import com.sobarna.success.viewmodel.FavoriteViewModel
import com.sobarna.success.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel (viewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel) :ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory:ViewModelFactory):ViewModelProvider.Factory
}