package com.khansa.filmcatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM movieentities")
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM showentities")
    fun getAllShows(): DataSource.Factory<Int, ShowEntity>

    @Query("SELECT * FROM movieentities where favoriteMovie = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM showentities where favoriteShows = 1")
    fun getFavoriteShows(): DataSource.Factory<Int, ShowEntity>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getDetailMovies(movieId: String): LiveData<MovieEntity>

    @Transaction
    @Query("SELECT * FROM showentities WHERE showsId = :showsId")
    fun getDetailShows(showsId: String): LiveData<ShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShows(shows: List<ShowEntity>)

    @Update
    fun updateMovies(movie: MovieEntity)

    @Update
    fun updateShows(shows: ShowEntity)
}