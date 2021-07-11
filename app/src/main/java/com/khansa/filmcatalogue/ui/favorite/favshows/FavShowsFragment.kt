package com.khansa.filmcatalogue.ui.favorite.favshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.khansa.filmcatalogue.R
import com.khansa.filmcatalogue.data.source.local.entity.MovieEntity
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.databinding.FragmentFavMovieBinding
import com.khansa.filmcatalogue.databinding.FragmentFavShowsBinding
import com.khansa.filmcatalogue.ui.movie.MovieAdapter
import com.khansa.filmcatalogue.ui.movie.MovieFragmentCallback
import com.khansa.filmcatalogue.ui.movie.MovieViewModel
import com.khansa.filmcatalogue.ui.shows.ShowsAdapter
import com.khansa.filmcatalogue.ui.shows.ShowsFragmentCallback
import com.khansa.filmcatalogue.ui.shows.ShowsViewModel
import com.khansa.filmcatalogue.viewmodel.ViewModelFactory

class FavShowsFragment : Fragment(), ShowsFragmentCallback {

    lateinit var binding: FragmentFavShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentFavShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ShowsViewModel::class.java]

            val showsAdapter = ShowsAdapter(this)

            binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavoriteShows().observe(viewLifecycleOwner, { shows ->
                if (shows != null) {
                    binding.progressBar.visibility = View.GONE
                    showsAdapter.submitList(shows)
                }
            })
            with(binding.rvFavShows) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = showsAdapter
            }
        }
    }

    override fun onShareClick(shows: ShowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share this show.")
                .setText(resources.getString(R.string.share_text, shows.title))
                .startChooser()
        }
    }
}