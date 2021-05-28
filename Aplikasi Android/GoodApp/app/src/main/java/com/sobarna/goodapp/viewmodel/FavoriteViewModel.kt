package com.sobarna.goodapp.viewmodel

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.sobarna.goodapp.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(useCase: MovieUseCase) : ViewModel() {
    //val useCase = useCase.getFavoriteMovie()
    val useCase = LiveDataReactiveStreams.fromPublisher(useCase.getFavoriteMovie())
}