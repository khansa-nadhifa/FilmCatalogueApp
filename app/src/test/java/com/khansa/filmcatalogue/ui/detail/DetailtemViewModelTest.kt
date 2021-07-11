package com.khansa.filmcatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.khansa.filmcatalogue.data.source.FilmRepository
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.utils.DataDummy
import com.khansa.filmcatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailItemViewModelTest {

    private lateinit var viewModel: DetailItemViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId
    private val dummyShows = DataDummy.generateDummyShows()[0]
    private val showId = dummyShows.showsId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var showObserver: Observer<Resource<ShowEntity>>

//    @Mock
//    private lateinit var pagedListMovie: PagedList<MovieEntity>
//
//    @Mock
//    private lateinit var pagedListShows: PagedList<ShowEntity>


    @Before
    fun setUp() {
        viewModel = DetailItemViewModel(filmRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedShow(showId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = Resource.success(DataDummy.generateDetailMovie(dummyMovie, true))

        `when`(filmRepository.getDetailMovies(movieId)).thenReturn(movie)

        viewModel.setSelectedMovie(movieId)

        viewModel.movieDetail.observeForever(movieObserver)
        verify(movieObserver).onChanged(movie.value)

        val expectedValue = movie.value
        val actualValue = viewModel.movieDetail.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun getShows() {
        val shows = MutableLiveData<Resource<ShowEntity>>()
        shows.value = Resource.success(DataDummy.generateDetailShows(dummyShows, true))

        `when`(filmRepository.getDetailShows(showId)).thenReturn(shows)

        viewModel.setSelectedShow(showId)

        viewModel.showsDetail.observeForever(showObserver)
        verify(showObserver).onChanged(shows.value)

        val expectedValue = shows.value
        val actualValue = viewModel.showsDetail.value

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun setFavoriteMovie() {
        viewModel.setSelectedMovie(movieId)

        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = Resource.success(DataDummy.generateDetailMovie(dummyMovie, true))

        `when`(filmRepository.getDetailMovies(movieId)).thenReturn(movie)

        viewModel.movieDetail = filmRepository.getDetailMovies(movieId)
        viewModel.setFavoriteMovie()

        verify(filmRepository).setFavoriteMovies(dummyMovie, false)
        verifyNoMoreInteractions(movieObserver)
    }

    @Test
    fun setFavoriteShows() {
        viewModel.setSelectedShow(showId)

        val shows = MutableLiveData<Resource<ShowEntity>>()
        shows.value = Resource.success(DataDummy.generateDetailShows(dummyShows, true))

        `when`(filmRepository.getDetailShows(showId)).thenReturn(shows)

        viewModel.showsDetail = filmRepository.getDetailShows(showId)
        viewModel.setFavoriteShows()

        verify(filmRepository).setFavoriteShows(dummyShows, false)
        verifyNoMoreInteractions(showObserver)
    }
}