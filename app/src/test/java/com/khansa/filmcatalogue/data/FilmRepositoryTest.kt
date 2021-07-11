package com.khansa.filmcatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.khansa.filmcatalogue.data.source.FilmDataSource
import com.khansa.filmcatalogue.data.source.NetworkBoundResource
import com.khansa.filmcatalogue.data.source.local.LocalDataSource
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.data.source.local.room.FilmDao
import com.khansa.filmcatalogue.data.source.remote.ApiResponse
import com.khansa.filmcatalogue.data.source.remote.RemoteDataSource
import com.khansa.filmcatalogue.data.source.remote.response.MovieResponse
import com.khansa.filmcatalogue.data.source.remote.response.ShowsResponse
import com.khansa.filmcatalogue.utils.AppExecutors
import com.khansa.filmcatalogue.utils.DataDummy
import com.khansa.filmcatalogue.utils.LiveDataTestUtil
import com.khansa.filmcatalogue.utils.PagedListUtil
import com.khansa.filmcatalogue.vo.Resource
import org.junit.Assert.*
import org.junit.Test
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.*

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeFilmRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val showResponses = DataDummy.generateRemoteDummyShows()
    private val showId = showResponses[0].showsId
    // private val content = DataDummy.generateRemoteDummyContent(moduleId)

    @Test
    fun getAllShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getAllShows()).thenReturn(dataSourceFactory)
        filmRepository.getAllShows()

        val showsEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShows()))
        verify(local).getAllShows()
        assertNotNull(showsEntities.data)
        assertEquals(showResponses.size.toLong(), showsEntities.data?.size?.toLong())
    }

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        filmRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailShows() {
        val dummyDetailShowEntities = MutableLiveData<ShowEntity>()
        dummyDetailShowEntities.value = DataDummy.generateDetailShows(DataDummy.generateDummyShows()[0], false)
        `when`(local.getDetailShows(showId)).thenReturn(dummyDetailShowEntities)

        val showEntities = LiveDataTestUtil.getValue(filmRepository.getDetailShows(showId))
        verify(local).getDetailShows(eq(showId))

        assertNotNull(showEntities.data)
        assertNotNull(showEntities.data?.title)
        assertNotNull(showResponses[0].title, showEntities.data?.title)
    }

    @Test
    fun getDetailMovies() {
        val dummyDetailMovieEntities = MutableLiveData<MovieEntity>()
        dummyDetailMovieEntities.value = DataDummy.generateDetailMovie(DataDummy.generateDummyMovies()[0], false)
        `when`(local.getDetailMovies(movieId)).thenReturn(dummyDetailMovieEntities)

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getDetailMovies(movieId))
        verify(local).getDetailMovies(eq(movieId))

        assertNotNull(movieEntities.data)
        assertNotNull(movieEntities.data?.title)
        assertNotNull(movieResponses[0].title, movieEntities.data?.title)
    }

    @Test
    fun getFavoriteShows(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getFavoriteShows()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteShows()

        val favoriteShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShows()))
        verify(local).getFavoriteShows()
        assertNotNull(favoriteShowEntity)
        assertEquals(showResponses.size.toLong(), favoriteShowEntity.data?.size?.toLong())
    }

    @Test
    fun getFavoriteMovies(){
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        filmRepository.getFavoriteMovies()

        val favoriteMovieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovie()
        assertNotNull(favoriteMovieEntity)
        assertEquals(movieResponses.size.toLong(), favoriteMovieEntity.data?.size?.toLong())
    }

    @Test
    fun setFavoriteShows(){
        val dao = spy(FilmDao::class.java)
        val localDataSource = LocalDataSource.getInstance(dao)
        val dummyShows = DataDummy.generateDummyShows()[0]
        val expected = dummyShows.copy(favoriteShows = false)
        doNothing().`when`(dao).updateShows(expected)
        localDataSource.setFavoriteShows(dummyShows, false)
        verify(dao, times(1)).updateShows(expected)
    }

    @Test
    fun setFavoriteMovies(){
        val dao = spy(FilmDao::class.java)
        val localDataSource = LocalDataSource.getInstance(dao)
        val dummyMovie = DataDummy.generateDummyMovies()[0]
        val expected = dummyMovie.copy(favoriteMovie = false)
        doNothing().`when`(dao).updateMovies(expected)
        localDataSource.setFavoriteMovie(dummyMovie, false)
        verify(dao, times(1)).updateMovies(expected)
    }



}