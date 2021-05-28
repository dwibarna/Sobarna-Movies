package com.sobarna.success.core.domain.repository


import com.sobarna.success.core.data.Resource
import com.sobarna.success.core.domain.model.Movie
import io.reactivex.Flowable

interface IMovieRepository {

    fun getAllMovies(): Flowable<com.sobarna.success.core.data.Resource<List<Movie>>>

    fun getFavoriteMovie(): Flowable<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

}