package com.sobarna.success.core.data


import com.sobarna.success.core.data.source.local.LocalDataSource
import com.sobarna.success.core.data.source.remote.RemoteDataSource
import com.sobarna.success.core.data.source.remote.network.ApiResponse
import com.sobarna.success.core.data.source.remote.response.MovieResponse
import com.sobarna.success.core.domain.model.Movie
import com.sobarna.success.core.domain.repository.IMovieRepository
import com.sobarna.success.core.utils.AppExecutors
import com.sobarna.success.core.utils.DataMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllMovies(): Flowable<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(){
            override fun loadFromDB(): Flowable<List<Movie>> {
                return localDataSource.getAllMovie().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
               return data == null || data.isEmpty()
            }

            override fun createCall(): Flowable<ApiResponse<List<MovieResponse>>> {
                return  remoteDataSource.getAllMovie()
            }

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }

        }.asFlowable()
    }

    override fun getFavoriteMovie(): Flowable<List<Movie>> {
        return localDataSource.getFavoriteMovie().map { DataMapper.mapEntitiesToDomain(it) }
    }
/*
    override fun getAllMovies(): LiveData<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Movie>> {
                return Transformations.map(localDataSource.getAllMovie()) {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()

 */
/*
    override fun getFavoriteMovie(): LiveData<List<Movie>> {
        return Transformations.map(localDataSource.getFavoriteMovie()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

 */

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(tourismEntity, state) }
    }
}