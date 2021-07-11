package com.khansa.filmcatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khansa.filmcatalogue.data.source.remote.response.MovieResponse
import com.khansa.filmcatalogue.data.source.remote.response.ShowsResponse
import com.khansa.filmcatalogue.utils.EspressoIdlingResource
import com.khansa.filmcatalogue.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
           // callback.onAllMoviesReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getAllShows(): LiveData<ApiResponse<List<ShowsResponse>>> {
        EspressoIdlingResource.increment()
        val resultShows = MutableLiveData<ApiResponse<List<ShowsResponse>>>()
        handler.postDelayed({
            //callback.onAllShowsReceived(jsonHelper.loadShows())
            resultShows.value = ApiResponse.success(jsonHelper.loadShows())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultShows
    }

    fun getDetailMovies(movieId: String): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadDetailMovies(movieId))
            //callback.onAllDetailMoviesReceived(jsonHelper.loadDetailMovies(itemId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getDetailShows(showsId: String): LiveData<ApiResponse<List<ShowsResponse>>> {
        EspressoIdlingResource.increment()
        val resultShows = MutableLiveData<ApiResponse<List<ShowsResponse>>>()
        handler.postDelayed({
            resultShows.value = ApiResponse.success(jsonHelper.loadDetailShows(showsId))
            //callback.onAllDetailShowsReceived(jsonHelper.loadDetailShows(itemId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultShows
    }



    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadShowsCallback {
        fun onAllShowsReceived(showResponses: List<ShowsResponse>)
    }

    interface LoadDetailMoviesCallback {
        fun onAllDetailMoviesReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadDetailShowsCallback {
        fun onAllDetailShowsReceived(showResponses: List<ShowsResponse>)
    }

}