package com.khansa.filmcatalogue.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.khansa.filmcatalogue.R
import com.khansa.filmcatalogue.databinding.ActivityFavoriteBinding


class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val favSectionsPageAdapter = FavSectionsPageAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = favSectionsPageAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        supportActionBar?.elevation = 0f

        supportActionBar?.title = getText(R.string.favorites)

    }
}