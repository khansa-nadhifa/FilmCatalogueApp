package com.khansa.filmcatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.FilmRepository
import com.khansa.filmcatalogue.vo.Resource

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = filmRepository.getAllMovies()

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = filmRepository.getFavoriteMovies()
}