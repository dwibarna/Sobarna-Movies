package com.sobarna.goodapp.core.data.source.local

import com.sobarna.goodapp.core.data.source.local.entity.MovieEntity
import com.sobarna.goodapp.core.data.source.local.room.MovieDao
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao:MovieDao) {



    fun getAllMovie(): Flowable<List<MovieEntity>> = movieDao.getAllMovie()

    fun getFavoriteMovie(): Flowable<List<MovieEntity>> = movieDao.getFavoriteMovie()

    fun insertMovie(movie: List<MovieEntity>) = movieDao.insertMovie(movie)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

}