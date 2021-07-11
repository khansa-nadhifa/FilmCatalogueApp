package com.khansa.filmcatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.khansa.filmcatalogue.data.source.local.LocalDataSource
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.data.source.remote.ApiResponse
import com.khansa.filmcatalogue.data.source.remote.RemoteDataSource
import com.khansa.filmcatalogue.data.source.remote.response.MovieResponse
import com.khansa.filmcatalogue.data.source.remote.response.ShowsResponse
import com.khansa.filmcatalogue.utils.AppExecutors
import com.khansa.filmcatalogue.vo.Resource

class FilmRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors)
    : FilmDataSource {

    companion object {
        @Volatile
        private var instance: FilmRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteData, localData, appExecutors).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(response.movieId,
                        response.title,
                        response.description,
                        response.year,
                        response.imagePath)
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllShows(): LiveData<Resource<PagedList<ShowEntity>>> {
        return object : NetworkBoundResource<PagedList<ShowEntity>, List<ShowsResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<ShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<ShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ShowsResponse>>> =
                remoteDataSource.getAllShows()

            public override fun saveCallResult(data: List<ShowsResponse>) {
                val showList = ArrayList<ShowEntity>()
                for (response in data) {
                    val show = ShowEntity(response.showsId,
                            response.title,
                            response.description,
                            response.year,
                            response.imagePath)
                    showList.add(show)
                }
                localDataSource.insertShows(showList)
            }
        }.asLiveData()
    }

    override fun getDetailMovies(movieId: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovies(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getDetailMovies(movieId)

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    if (response.movieId == movieId) {
                        val movie = MovieEntity(
                            response.movieId,
                            response.title,
                            response.description,
                            response.year,
                            response.imagePath)
                        movieList.add(movie)
                    }
                }
                localDataSource.getDetailMovies(movieId)
            }
        }.asLiveData()
    }

    override fun getDetailShows(showsId: String): LiveData<Resource<ShowEntity>> {

        return object : NetworkBoundResource<ShowEntity, List<ShowsResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<ShowEntity> =
                localDataSource.getDetailShows(showsId)

            override fun shouldFetch(data: ShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<ShowsResponse>>> =
                remoteDataSource.getDetailShows(showsId)
            override fun saveCallResult(data: List<ShowsResponse>) {
                val showsList = ArrayList<ShowEntity>()
                for (response in data) {
                    if (response.showsId == showsId) {
                        val shows = ShowEntity(
                            response.showsId,
                            response.title,
                            response.description,
                            response.year,
                            response.imagePath)
                        showsList.add(shows)
                    }
                }
                localDataSource.getDetailShows(showsId)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteShows(): LiveData<PagedList<ShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteShows(), config).build()
    }


    override fun setFavoriteMovies(movieId: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieId, state) }

    override fun setFavoriteShows(showsId: ShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteShows(showsId, state) }

}