package com.sobarna.success.core.domain.usecase


import com.sobarna.success.core.data.Resource
import com.sobarna.success.core.domain.model.Movie
import com.sobarna.success.core.domain.repository.IMovieRepository
import io.reactivex.Flowable
import javax.inject.Inject

class MovieInteract @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie(): Flowable<Resource<List<Movie>>> {
        return movieRepository.getAllMovies()
    }

    override fun getFavoriteMovie(): Flowable<List<Movie>> {
       return movieRepository.getFavoriteMovie()
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        return movieRepository.setFavoriteMovie(movie,state)
    }
}