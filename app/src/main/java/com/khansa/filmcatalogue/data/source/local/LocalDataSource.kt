package com.khansa.filmcatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getAllMovies()

    fun getAllShows(): DataSource.Factory<Int, ShowEntity> = mFilmDao.getAllShows()

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getFavoriteMovie()

    fun getFavoriteShows(): DataSource.Factory<Int, ShowEntity> = mFilmDao.getFavoriteShows()

    fun getDetailMovies(movieId: String): LiveData<MovieEntity> =
        mFilmDao.getDetailMovies(movieId)

    fun getDetailShows(showsId: String): LiveData<ShowEntity> =
        mFilmDao.getDetailShows(showsId)

    fun insertMovies(movie: List<MovieEntity>) = mFilmDao.insertMovies(movie)

    fun insertShows(shows: List<ShowEntity>) = mFilmDao.insertShows(shows)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favoriteMovie = newState
        mFilmDao.updateMovies(movie)
    }

    fun setFavoriteShows(shows: ShowEntity, newState: Boolean) {
        shows.favoriteShows = newState
        mFilmDao.updateShows(shows)
    }
}