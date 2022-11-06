package com.example.mymusic.view.viewHolder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymusic.databinding.ItemArtistsFavoriteHomeBinding
import com.example.mymusic.models.Song

class ArtistsFavoritesViewHolder(binding: ItemArtistsFavoriteHomeBinding): RecyclerView.ViewHolder(binding.root) {

    var binding: ItemArtistsFavoriteHomeBinding

    init {
        this.binding = binding
    }

    fun bind(context: Context?, result: Song) {
        context?.let {
            Glide.with(it).load(result.image).fitCenter().into(binding.imageCardFavorites)
        }
    }
}