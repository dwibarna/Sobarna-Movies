package com.example.consumersubmissionapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.consumersubmissionapp.databinding.GithubListBinding

class FavoriteAdapter(private var favoriteList :ArrayList<FavoriteUser>)
    : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    fun setDataFavorite(itemList: List<FavoriteUser>){
        favoriteList.clear()
        favoriteList.addAll(itemList)
        notifyDataSetChanged()
    }
    inner class FavoriteViewHolder(private val binding: GithubListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(favorite: FavoriteUser){
            Glide.with(itemView.context)
                .load(favorite.avatarUser)
                .apply(RequestOptions().override(100,100))
                .into(binding.ivAvatarList)
            binding.tvUsernameList.text = favorite.usernameUser
            binding.root.setOnClickListener {
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = GithubListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(favoriteList[position])
        favoriteList[position]
    }
    override fun getItemCount(): Int = favoriteList.size
}