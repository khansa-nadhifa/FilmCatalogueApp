package com.khansa.filmcatalogue.utils

import android.content.Context
import com.khansa.filmcatalogue.data.source.remote.response.MovieResponse
import com.khansa.filmcatalogue.data.source.remote.response.ShowsResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadShows(): List<ShowsResponse> {
        val list = ArrayList<ShowsResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("ShowsResponses.json").toString())
            val listArray = responseObject.getJSONArray("shows")
            for (i in 0 until listArray.length()) {
                val shows = listArray.getJSONObject(i)

                val id = shows.getString("itemId")
                val title = shows.getString("title")
                val description = shows.getString("description")
                val year = shows.getString("year")
                val imagePath = shows.getString("imagePath")

                val showsResponse = ShowsResponse(id, title, description, year, imagePath)
                list.add(showsResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movies = listArray.getJSONObject(i)

                val id = movies.getString("itemId")
                val title = movies.getString("title")
                val description = movies.getString("description")
                val year = movies.getString("year")
                val imagePath = movies.getString("imagePath")

                val movieResponse = MovieResponse(id, title, description, year, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailShows(itemId: String): List<ShowsResponse> {
        val list = ArrayList<ShowsResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("ShowsResponses.json").toString())
            val listArray = responseObject.getJSONArray("shows")
            for (i in 0 until listArray.length()) {
                val shows = listArray.getJSONObject(i)

                val id = shows.getString("itemId")
                val title = shows.getString("title")
                val description = shows.getString("description")
                val year = shows.getString("year")
                val imagePath = shows.getString("imagePath")

                val showsResponse = ShowsResponse(id, title, description, year, imagePath)
                list.add(showsResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailMovies(itemId: String): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movies = listArray.getJSONObject(i)

                val id = movies.getString("itemId")
                val title = movies.getString("title")
                val description = movies.getString("description")
                val year = movies.getString("year")
                val imagePath = movies.getString("imagePath")

                val movieResponse = MovieResponse(id, title, description, year, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}