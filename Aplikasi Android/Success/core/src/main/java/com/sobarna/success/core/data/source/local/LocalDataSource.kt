package com.sobarna.success.core.data.source.local


import com.sobarna.success.core.data.source.local.entity.MovieEntity
import com.sobarna.success.core.data.source.local.room.MovieDao
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao: com.sobarna.success.core.data.source.local.room.MovieDao) {

    fun getAllMovie(): Flowable<List<com.sobarna.success.core.data.source.local.entity.MovieEntity>> = movieDao.getAllMovie()

    fun getFavoriteMovie(): Flowable<List<com.sobarna.success.core.data.source.local.entity.MovieEntity>> = movieDao.getFavoriteMovie()

    fun insertMovie(movie: List<com.sobarna.success.core.data.source.local.entity.MovieEntity>) = movieDao.insertMovie(movie)

    fun setFavoriteMovie(movie: com.sobarna.success.core.data.source.local.entity.MovieEntity, newState: Boolean) {
        movie.favorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

}