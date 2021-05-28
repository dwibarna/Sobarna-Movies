package com.sobarna.goodapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sobarna.goodapp.R
import com.sobarna.goodapp.core.ui.adapter.SectionPagerAdapter
import com.sobarna.goodapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        private val TAB_TITLES = intArrayOf(
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_favorite_black
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sectionAdapter()
    }


    private fun sectionAdapter() {
        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager: ViewPager2 = binding.vpMain
        viewPager.adapter =sectionPagerAdapter
        val tabs: TabLayout =binding.tlMain
        TabLayoutMediator(tabs,viewPager){ tab,position ->
            tab.icon = resources.getDrawable(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

}