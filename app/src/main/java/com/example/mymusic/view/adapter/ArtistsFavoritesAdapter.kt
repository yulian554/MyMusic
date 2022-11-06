package com.example.mymusic.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.databinding.ItemArtistsFavoriteHomeBinding
import com.example.mymusic.models.Song
import com.example.mymusic.view.viewHolder.ArtistsFavoritesViewHolder

class ArtistsFavoritesAdapter(private val artists: ArrayList<Song>) : RecyclerView.Adapter<ArtistsFavoritesViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsFavoritesViewHolder {
        context = parent.context
        val binding = ItemArtistsFavoriteHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtistsFavoritesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistsFavoritesViewHolder, position: Int) {
        holder.bind(context,artists[position])
    }

    override fun getItemCount(): Int = artists.size

}