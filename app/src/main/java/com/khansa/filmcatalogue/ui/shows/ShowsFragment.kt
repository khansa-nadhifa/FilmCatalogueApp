package com.khansa.filmcatalogue.ui.shows

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
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.databinding.FragmentShowsBinding
import com.khansa.filmcatalogue.viewmodel.ViewModelFactory
import com.khansa.filmcatalogue.vo.Status

class ShowsFragment : Fragment(), ShowsFragmentCallback {

    lateinit var binding: FragmentShowsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[ShowsViewModel::class.java]

            val showAdapter = ShowsAdapter(this)
            viewModel.getShows().observe(viewLifecycleOwner, { shows ->
                if (shows != null) {
                    when (shows.status) {
                        Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            showAdapter.submitList(shows.data)
                        }
                        Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(binding.rvShows) {
                this.layoutManager = LinearLayoutManager(context)
                this.setHasFixedSize(true)
                this.adapter = showAdapter
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