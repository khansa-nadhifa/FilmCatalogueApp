package com.khansa.filmcatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "showentities")
data class ShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="showsId")
    var showsId: String,

    @ColumnInfo(name="title")
    var title: String,

    @ColumnInfo(name="description")
    var description: String,

    @ColumnInfo(name="year")
    var year: String,

    @ColumnInfo(name = "imagePath")
    var imagePath: String,

    @ColumnInfo(name = "favoriteShows")
    var favoriteShows: Boolean = false
)