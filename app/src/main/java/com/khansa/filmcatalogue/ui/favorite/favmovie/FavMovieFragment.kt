package com.khansa.filmcatalogue.ui.favorite.favmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.khansa.filmcatalogue.R
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.databinding.FragmentFavMovieBinding
import com.khansa.filmcatalogue.databinding.FragmentMovieBinding
import com.khansa.filmcatalogue.ui.movie.MovieAdapter
import com.khansa.filmcatalogue.ui.movie.MovieFragmentCallback
import com.khansa.filmcatalogue.ui.movie.MovieViewModel
import com.khansa.filmcatalogue.viewmodel.ViewModelFactory
import com.khansa.filmcatalogue.vo.Status


class FavMovieFragment : Fragment(), MovieFragmentCallback {

    lateinit var binding: FragmentFavMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentFavMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter(this)

            binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movie ->
                if (movie != null) {
                    binding.progressBar.visibility = View.GONE
                    movieAdapter.submitList(movie)
                }
            })
            with(binding.rvFavMovies) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

    override fun onShareClick(movies: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share this movie.")
                .setText(resources.getString(R.string.share_text, movies.title))
                .startChooser()
        }
    }
}