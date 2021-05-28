package com.sobarna.success.core.domain.usecase


import com.sobarna.success.core.data.Resource
import com.sobarna.success.core.domain.model.Movie
import io.reactivex.Flowable

interface MovieUseCase {
    fun getAllMovie(): Flowable<com.sobarna.success.core.data.Resource<List<Movie>>>
    fun getFavoriteMovie(): Flowable<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}