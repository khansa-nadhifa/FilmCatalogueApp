package com.khansa.filmcatalogue.ui.shows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.khansa.filmcatalogue.data.source.FilmRepository
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.vo.Resource
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
class ShowsViewModelTest {

    private lateinit var viewModel: ShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<ShowEntity>>>

    @Mock
    private lateinit var observerFav: Observer<PagedList<ShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<ShowEntity>

    @Before
    fun setUp() {
        viewModel = ShowsViewModel(filmRepository)
    }

    @Test
    fun getShows() {
        val dummyShows = Resource.success(pagedList)
        `when` (dummyShows.data?.size).thenReturn(10)

        val shows = MutableLiveData<Resource<PagedList<ShowEntity>>>()
        shows.value = dummyShows

        `when`(filmRepository.getAllShows()).thenReturn(shows)
        val showEntities = viewModel.getShows().value?.data
        verify(filmRepository).getAllShows()
        assertNotNull(showEntities)
        assertEquals(10, showEntities?.size)

        viewModel.getShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }

    @Test
    fun getFavoriteShows() {
        val dummyFavShows = pagedList
        `when`(dummyFavShows.size).thenReturn(1)
        val shows = MutableLiveData<PagedList<ShowEntity>>()
        shows.value = dummyFavShows

        `when`(filmRepository.getFavoriteShows()).thenReturn(shows)
        val showEntities = viewModel.getFavoriteShows().value
        verify(filmRepository).getFavoriteShows()
        assertNotNull(showEntities)
        assertEquals(1, showEntities?.size)

        viewModel.getFavoriteShows().observeForever(observerFav)
        verify(observerFav).onChanged(dummyFavShows)
    }
}