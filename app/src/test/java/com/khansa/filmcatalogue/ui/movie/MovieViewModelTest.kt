package com.khansa.filmcatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.khansa.filmcatalogue.data.source.FilmRepository
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.utils.DataDummy
import com.khansa.filmcatalogue.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var observerFav: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>


    @Before
    fun setUp() {
        viewModel = MovieViewModel(filmRepository)
    }

    @Test
    fun getMovies() {

        val dummyMovies = Resource.success(pagedList)
        `when` (dummyMovies.data?.size).thenReturn(10)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovies

        `when`(filmRepository.getAllMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value?.data
        verify(filmRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavMovies = pagedList
        `when`(dummyFavMovies.size).thenReturn(1)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyFavMovies

        `when`(filmRepository.getFavoriteMovies()).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovies().value
        verify(filmRepository).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(1, movieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observerFav)
        verify(observerFav).onChanged(dummyFavMovies)
    }
}