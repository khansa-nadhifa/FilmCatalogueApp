package com.khansa.filmcatalogue.ui.shows

import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity

interface ShowsFragmentCallback {
    fun onShareClick(shows: ShowEntity)
}
