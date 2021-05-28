package com.sobarna.success.core.data.source.remote.network


import com.sobarna.success.core.BuildConfig
import com.sobarna.success.core.data.source.remote.response.ListMovieResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("3/movie/upcoming?api_key=${BuildConfig.KEY}")
    fun getListMovie(): Flowable<com.sobarna.success.core.data.source.remote.response.ListMovieResponse>
}