package com.khansa.filmcatalogue.ui.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.khansa.filmcatalogue.R
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.databinding.ActivityDetailItemBinding
import com.khansa.filmcatalogue.databinding.ContentDetailItemBinding
import com.khansa.filmcatalogue.viewmodel.ViewModelFactory
import com.khansa.filmcatalogue.vo.Status


class DetailItemActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_SHOW = "extra_show"
    }

    private lateinit var detailContentBinding: ContentDetailItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailItemBinding = ActivityDetailItemBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailItemBinding.detailContent

        setContentView(activityDetailItemBinding.root)

        setSupportActionBar(activityDetailItemBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailItemViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val showId = extras.getString(EXTRA_SHOW)
            val movieId = extras.getString(EXTRA_MOVIE)

            if(showId != null) {
                supportActionBar?.title = getText(R.string.show_detail)

                viewModel.setSelectedShow(showId)

                viewModel.showsDetail.observe(this, { shows ->
                    when (shows.status) {
                        Status.LOADING -> activityDetailItemBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (shows.data != null) {
                            activityDetailItemBinding.progressBar.visibility = View.GONE
                            populateShow(shows.data)
                        }
                        Status.ERROR -> {
                            activityDetailItemBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }

            if(movieId != null) {
                supportActionBar?.title = getText(R.string.movie_detail)

                viewModel.setSelectedMovie(movieId)

                viewModel.movieDetail.observe(this, { movie ->
                    when (movie.status) {
                        Status.LOADING -> activityDetailItemBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (movie.data != null) {
                            activityDetailItemBinding.progressBar.visibility = View.GONE
                            populateMovie(movie.data)
                        }
                        Status.ERROR -> {
                            activityDetailItemBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }
        }
        detailContentBinding.fabFav.setOnClickListener {
            viewModel.setFavoriteShows()
            viewModel.setFavoriteMovie()
        }
    }

    private fun populateShow(itemEntity: ShowEntity) {
        detailContentBinding.textTitle.text = itemEntity.title
        detailContentBinding.textDescription.text = itemEntity.description
        detailContentBinding.textYear.text = itemEntity.year

        val favoriteShows = itemEntity.favoriteShows
        setFavoriteState(favoriteShows)

        Glide.with(this)
                .load(itemEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)
    }

    private fun populateMovie(itemEntity: MovieEntity) {
        detailContentBinding.textTitle.text = itemEntity.title
        detailContentBinding.textDescription.text = itemEntity.description
        detailContentBinding.textYear.text = itemEntity.year

        val favoriteMovie = itemEntity.favoriteMovie
        setFavoriteState(favoriteMovie)

        Glide.with(this)
                .load(itemEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)

    }

    private fun setFavoriteState(state: Boolean){
        if(state) {
            detailContentBinding.fabFav.setImageResource(R.drawable.baseline_favorite_24)
        }
        else {
            detailContentBinding.fabFav.setImageResource(R.drawable.baseline_favorite_border_24)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return true
    }
}