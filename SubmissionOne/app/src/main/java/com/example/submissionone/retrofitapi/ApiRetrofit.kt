package com.example.submissionone.retrofitapi

import com.example.submissionone.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRetrofit {
  //  https://api.themoviedb.org/3/movie/top_rated?api_key=338e9f156f9f274bed38580ad4810b0f
    @GET("users")
    @Headers("Authorization: token efb84bdbe1810822147b62f5eaf5248d6301d5ba")
    fun getPosts(): Call<ArrayList<User>>
    @GET("users/{username}")
    @Headers("Authorization: token efb84bdbe1810822147b62f5eaf5248d6301d5ba")
    fun getDetail(@Path("username")username:String):Call<DetailUser>

    @GET("search/users")
    @Headers("Authorization: token efb84bdbe1810822147b62f5eaf5248d6301d5ba")
    fun getSearchAPI(@Query("q")query:String):Call<DataSearchUser>

    @GET("users/{username}/followers")
    @Headers("Authorization: token efb84bdbe1810822147b62f5eaf5248d6301d5ba")
    fun getFollowersAPI(@Path("username")username:String):Call<ArrayList<FollowersUser>>

    @GET("users/{username}/following")
    @Headers("Authorization: token efb84bdbe1810822147b62f5eaf5248d6301d5ba")
    fun getFollowingAPI(@Path("username")username:String):Call<ArrayList<FollowingUser>>

}

