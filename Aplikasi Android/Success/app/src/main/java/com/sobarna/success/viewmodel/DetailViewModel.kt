package com.sobarna.success.viewmodel

import androidx.lifecycle.ViewModel
import com.sobarna.success.core.domain.model.Movie
import com.sobarna.success.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val useCase: MovieUseCase) : ViewModel() {
    fun setFavoriteTourism(movie: Movie, newStatus:Boolean) =
        useCase.setFavoriteMovie(movie, newStatus)
}