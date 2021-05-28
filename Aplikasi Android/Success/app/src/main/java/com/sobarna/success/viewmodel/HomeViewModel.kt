package com.sobarna.success.viewmodel

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.sobarna.success.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(useCase: MovieUseCase) : ViewModel() {
   // val useCase = useCase.getAllMovie()
    val useCase = LiveDataReactiveStreams.fromPublisher(useCase.getAllMovie())
}