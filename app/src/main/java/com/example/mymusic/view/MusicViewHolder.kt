package com.example.mymusic.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymusic.databinding.ItemMusicHomeBinding
import com.example.mymusic.models.Song

class MusicViewHolder(binding: ItemMusicHomeBinding): RecyclerView.ViewHolder(binding.root) {

    var binding: ItemMusicHomeBinding

    init {
        this.binding = binding
    }

    @SuppressLint("SetTextI18n")
    fun bind(context: Context?, result: Song){
        result.image?.let { image ->
            if (context != null) {
                Glide.with(context).load(image).fitCenter()
                    .into(binding.imageSong)
            }
        }
        result.title?.let {
            binding.textViewSong.text = it
        }
        result.artist?.let {
            binding.textViewArtist.text = it
        }
        if (result.artist != null && result.album != null) {
            binding.textViewArtist.text = "${result.artist} - ${result.album}"
        }
    }
}