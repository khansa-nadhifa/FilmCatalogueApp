package com.khansa.filmcatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.vo.Resource

interface FilmDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllShows(): LiveData<Resource<PagedList<ShowEntity>>>

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteShows(): LiveData<PagedList<ShowEntity>>

    fun getDetailMovies(movieId: String): LiveData<Resource<MovieEntity>>

    fun getDetailShows(showsId: String): LiveData<Resource<ShowEntity>>

    fun setFavoriteMovies(movieId: MovieEntity, state: Boolean)

    fun setFavoriteShows(showsId: ShowEntity, state: Boolean)
}