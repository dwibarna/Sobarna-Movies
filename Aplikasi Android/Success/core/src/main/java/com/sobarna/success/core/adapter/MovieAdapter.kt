package com.sobarna.success.core.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sobarna.success.core.R
import com.sobarna.success.core.databinding.ListItemBinding
import com.sobarna.success.core.domain.model.Movie
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemBinding.bind(itemView)
        @SuppressLint("SimpleDateFormat")
        fun bind(data: Movie) {
            val imageUrl = "https://image.tmdb.org/t/p/w500${data.poster_path}"
            val oldDate = data.release_date
            val dateFormat: DateFormat = SimpleDateFormat("dd MMMM yyyy")
            val df = SimpleDateFormat("yyyy-MM-dd")
            val newDate = dateFormat.format(df.parse(oldDate)!!)

            with(binding) {
                Glide.with(itemView.context)
                    .load(imageUrl)
                    .into(ivItemList)
                binding.ivTitleItemList.text = data.title
                binding.ivDateList.text = newDate
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}