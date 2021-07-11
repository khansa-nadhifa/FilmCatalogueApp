package com.khansa.filmcatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khansa.filmcatalogue.data.source.FilmRepository
import com.khansa.filmcatalogue.di.Injection
import com.khansa.filmcatalogue.ui.detail.DetailItemViewModel
import com.khansa.filmcatalogue.ui.movie.MovieViewModel
import com.khansa.filmcatalogue.ui.shows.ShowsViewModel

class ViewModelFactory private constructor(private val mFilmRepository: FilmRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(ShowsViewModel::class.java) -> {
                return ShowsViewModel(mFilmRepository) as T
            }
            modelClass.isAssignableFrom(DetailItemViewModel::class.java) -> {
                return DetailItemViewModel(mFilmRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}