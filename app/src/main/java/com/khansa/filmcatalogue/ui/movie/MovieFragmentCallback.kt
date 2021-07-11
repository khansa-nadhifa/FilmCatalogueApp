package com.khansa.filmcatalogue.ui.movie

import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity

interface MovieFragmentCallback {
    fun onShareClick(movies: MovieEntity)
}
