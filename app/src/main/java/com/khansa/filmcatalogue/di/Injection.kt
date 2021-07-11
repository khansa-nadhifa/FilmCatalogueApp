package com.khansa.filmcatalogue.di

import android.content.Context
import com.khansa.filmcatalogue.data.source.FilmRepository
import com.khansa.filmcatalogue.data.source.local.LocalDataSource
import com.khansa.filmcatalogue.data.source.local.room.FilmDatabase
import com.khansa.filmcatalogue.data.source.remote.RemoteDataSource
import com.khansa.filmcatalogue.utils.AppExecutors
import com.khansa.filmcatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): FilmRepository {

        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return FilmRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}