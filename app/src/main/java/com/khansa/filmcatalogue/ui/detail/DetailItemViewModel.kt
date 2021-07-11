package com.khansa.filmcatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.data.source.FilmRepository
import com.khansa.filmcatalogue.vo.Resource

class DetailItemViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    val movieId = MutableLiveData<String>()
    val showsId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }

    fun setSelectedShow(showsId: String) {
        this.showsId.value = showsId
    }

    var movieDetail: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { mMovieId ->
        filmRepository.getDetailMovies(mMovieId)
    }

    var showsDetail: LiveData<Resource<ShowEntity>> = Transformations.switchMap(showsId) { mShowsId ->
        filmRepository.getDetailShows(mShowsId)
    }

    fun setFavoriteMovie() {
        val movieResource = movieDetail.value
        if (movieResource != null) {
            val movie = movieResource.data
            val newState = !movie?.favoriteMovie!!
            filmRepository.setFavoriteMovies(movie, newState)

        }
    }

    fun setFavoriteShows() {
        val showsResource = showsDetail.value
        if (showsResource != null) {
            val shows = showsResource.data
            val newState = !shows?.favoriteShows!!
            filmRepository.setFavoriteShows(shows, newState)

        }
    }
}