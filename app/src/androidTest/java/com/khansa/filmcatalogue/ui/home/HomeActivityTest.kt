package com.khansa.filmcatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.khansa.filmcatalogue.R
import com.khansa.filmcatalogue.utils.DataDummy
import com.khansa.filmcatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyShows = DataDummy.generateDummyShows()
    private val dummyMovies = DataDummy.generateDummyMovies()

//    @get:Rule
//    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadShows() {
        delayTwoSecond()
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShows.size))
    }

    @Test
    fun loadDetailShows() {
        delayTwoSecond()
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        delayTwoSecond()
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyShows[0].title)))
        onView(withId(R.id.text_year)).check(matches(isDisplayed()))
        onView(withId(R.id.text_year)).check(matches(withText(dummyShows[0].year)))
        onView(isRoot()).perform(swipeUp())
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyShows[0].description)))
    }

    @Test
    fun loadMovies() {
        onView(withText("Movie")).perform(click())
        delayTwoSecond()
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withText("Movie")).perform(click())
        delayTwoSecond()
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        delayTwoSecond()
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.text_year)).check(matches(isDisplayed()))
        onView(withId(R.id.text_year)).check(matches(withText(dummyMovies[0].year)))
        onView(isRoot()).perform(swipeUp())
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyMovies[0].description)))

    }

    @Test
    fun loadFavShows() {
        delayTwoSecond()
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShows.size))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fab_fav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_fav)).perform(click())
        onView(withId(R.id.rv_fav_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyShows.size))
    }

    @Test
    fun loadFavMovies() {
        onView(withText("Movie")).perform(click())
        delayTwoSecond()
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fab_fav)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.action_fav)).perform(click())
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_fav_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))

    }

    private fun delayTwoSecond() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}