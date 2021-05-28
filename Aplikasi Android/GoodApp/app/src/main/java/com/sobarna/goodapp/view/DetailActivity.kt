package com.sobarna.goodapp.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.sobarna.goodapp.MyApplication
import com.sobarna.goodapp.R
import com.sobarna.goodapp.core.domain.model.Movie
import com.sobarna.goodapp.core.ui.ViewModelFactory
import com.sobarna.goodapp.databinding.ActivityDetailBinding
import com.sobarna.goodapp.viewmodel.DetailViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    @Inject
    lateinit var factory: ViewModelFactory


    private val detailViewModel: DetailViewModel by viewModels {
        factory
    }
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // setSupportActionBar(binding.toolbar)


        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailTourism(detailMovie)
    }

    @SuppressLint("SimpleDateFormat")
    private fun showDetailTourism(movie: Movie?) {
        movie?.let {

            val oldDate = movie.release_date
            val yearFormat: DateFormat = SimpleDateFormat("yyyy")
            val newFormat: DateFormat = SimpleDateFormat("dd MMMM yyyy")
            val df = SimpleDateFormat("yyyy-MM-dd")
            val yearDate = yearFormat.format(df.parse(oldDate)!!)
            val currentDate = newFormat.format(df.parse(oldDate)!!)

            val title :String = movie.title+" ($yearDate)"
            val dateRelease :String = currentDate +" (${movie.original_language.uppercase()})"
            val imageUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"
            val userScore:String = (movie.vote_average.toInt()*10).toString() +'%'
            val overview = "\t ${movie.overview}"

            Glide.with(this)
                .load(imageUrl)
                .into(binding.ivAvatarDetail)

            binding.tvTitleDetail.text = title
            binding.tvDateDetail.text = dateRelease

            binding.tvUserScoreDetail.text = userScore
            binding.tvOverViewDetail.text = overview

          //  supportActionBar?.title = detailTourism.name
          //  binding.content.tvDetailDescription.text = detailTourism.overview
         //   Glide.with(this@DetailTourismActivity)
         ////       .load(detailTourism.image)
         //       .into(binding.ivDetailImage)

            var statusFavorite = movie.favorite
            setStatusFavorite(statusFavorite)
            binding.fabDetail.setOnClickListener {
               statusFavorite = !statusFavorite
                detailViewModel.setFavoriteTourism(movie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }


    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabDetail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fabDetail.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}




