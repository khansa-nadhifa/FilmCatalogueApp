package com.khansa.filmcatalogue.ui.shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.data.source.FilmRepository
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.vo.Resource

class ShowsViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getShows(): LiveData<Resource<PagedList<ShowEntity>>> = filmRepository.getAllShows()

    fun getFavoriteShows(): LiveData<PagedList<ShowEntity>> = filmRepository.getFavoriteShows()
}