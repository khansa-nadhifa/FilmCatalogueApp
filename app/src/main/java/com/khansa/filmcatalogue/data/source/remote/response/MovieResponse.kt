package com.khansa.filmcatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var title: String,
    var description: String,
    var year: String,
    var imagePath: String
):Parcelable
