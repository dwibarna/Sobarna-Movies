package com.sobarna.success.core.data.source.remote

import android.annotation.SuppressLint
import android.util.Log
import com.sobarna.success.core.data.source.remote.network.ApiResponse
import com.sobarna.success.core.data.source.remote.network.ApiService
import com.sobarna.success.core.data.source.remote.response.MovieResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: com.sobarna.success.core.data.source.remote.network.ApiService) {

    @SuppressLint("CheckResult")
    fun getAllMovie(): Flowable<com.sobarna.success.core.data.source.remote.network.ApiResponse<List<com.sobarna.success.core.data.source.remote.response.MovieResponse>>> {
        val resultData = PublishSubject.create<com.sobarna.success.core.data.source.remote.network.ApiResponse<List<com.sobarna.success.core.data.source.remote.response.MovieResponse>>>()

        //get data from remote api
        val client = apiService.getListMovie()

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({response ->
                val dataArray = response.results
                resultData.onNext(if(dataArray.isNotEmpty()) com.sobarna.success.core.data.source.remote.network.ApiResponse.Success(dataArray) else com.sobarna.success.core.data.source.remote.network.ApiResponse.Empty)
            },{error ->
                resultData.onNext(com.sobarna.success.core.data.source.remote.network.ApiResponse.Error(error.message.toString()))
                Log.e("Error RemoteDataSource",error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
/*
        client.enqueue(object : Callback<ListMovieResponse> {
            override fun onResponse(
                call: Call<ListMovieResponse>,
                response: Response<ListMovieResponse>
            ) {
                val dataArray = response.body()?.results
                resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListMovieResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }

 */
    }
}
