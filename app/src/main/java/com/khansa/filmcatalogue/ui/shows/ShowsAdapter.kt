package com.khansa.filmcatalogue.ui.shows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.khansa.filmcatalogue.R
import com.khansa.filmcatalogue.data.source.local.entity.ShowEntity
import com.khansa.filmcatalogue.databinding.ItemListBinding
import com.khansa.filmcatalogue.ui.detail.DetailItemActivity

class ShowsAdapter(private val callback: ShowsFragmentCallback) : PagedListAdapter<ShowEntity, ShowsAdapter.ShowsViewHolder>(DIFF_CALLBACK) {
//    private val listShows = ArrayList<ShowEntity>()

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ShowEntity>() {
            override fun areItemsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem.showsId == newItem.showsId
            }
            override fun areContentsTheSame(oldItem: ShowEntity, newItem: ShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsViewHolder {
        val itemsShowsBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowsViewHolder(itemsShowsBinding)
    }

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {
        val shows = getItem(position)
        if (shows != null) {
            holder.bind(shows)
        }
    }

    inner class ShowsViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(shows: ShowEntity) {
            with(binding) {
                tvItemTitle.text = shows.title
                tvItemDescription.text = shows.description
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailItemActivity::class.java)
                    intent.putExtra(DetailItemActivity.EXTRA_SHOW, shows.showsId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(shows) }
                Glide.with(itemView.context)
                        .load(shows.imagePath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }
}