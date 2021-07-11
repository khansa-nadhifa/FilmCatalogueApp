package com.khansa.filmcatalogue.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.khansa.filmcatalogue.R
import com.khansa.filmcatalogue.ui.movie.MovieFragment
import com.khansa.filmcatalogue.ui.shows.ShowsFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.shows, R.string.movie)
    }

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> ShowsFragment()
                1 -> MovieFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

}