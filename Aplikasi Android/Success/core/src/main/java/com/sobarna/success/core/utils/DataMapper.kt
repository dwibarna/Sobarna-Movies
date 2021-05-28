package com.sobarna.success.core.utils

import com.sobarna.success.core.data.source.local.entity.MovieEntity
import com.sobarna.success.core.data.source.remote.response.MovieResponse
import com.sobarna.success.core.domain.model.Movie


object DataMapper {
    fun mapResponsesToEntities(input: List<com.sobarna.success.core.data.source.remote.response.MovieResponse>): List<com.sobarna.success.core.data.source.local.entity.MovieEntity> {
        val movieList = ArrayList<com.sobarna.success.core.data.source.local.entity.MovieEntity>()
        input.map {
            val movie = com.sobarna.success.core.data.source.local.entity.MovieEntity(
                id = it.id,
                original_language = it.original_language,
                original_title = it.original_title,
                overview = it.overview,
                popularity = it.popularity,
                poster_path = it.poster_path,
                release_date = it.release_date,
                title = it.title,
                vote_average = it.vote_average,
                vote_count = it.vote_count,
                favorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<com.sobarna.success.core.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                original_language = it.original_language,
                original_title = it.original_title,
                overview = it.overview,
                popularity = it.popularity,
                poster_path = it.poster_path,
                release_date = it.release_date,
                title = it.title,
                vote_average = it.vote_average,
                vote_count = it.vote_count,
                favorite = it.favorite
            )
        }

    fun mapDomainToEntity(input: Movie) =
        com.sobarna.success.core.data.source.local.entity.MovieEntity(
            id = input.id,
            original_language = input.original_language,
            original_title = input.original_title,
            overview = input.overview,
            popularity = input.popularity,
            poster_path = input.poster_path,
            release_date = input.release_date,
            title = input.title,
            vote_average = input.vote_average,
            vote_count = input.vote_count,
            favorite = input.favorite
        )
}