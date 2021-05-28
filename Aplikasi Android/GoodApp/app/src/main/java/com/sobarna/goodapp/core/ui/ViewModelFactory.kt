package com.sobarna.goodapp.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sobarna.goodapp.core.domain.usecase.MovieUseCase
import com.sobarna.goodapp.viewmodel.DetailViewModel
import com.sobarna.goodapp.viewmodel.FavoriteViewModel
import com.sobarna.goodapp.viewmodel.HomeViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val useCase: MovieUseCase) :
    ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(useCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(useCase) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(useCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}