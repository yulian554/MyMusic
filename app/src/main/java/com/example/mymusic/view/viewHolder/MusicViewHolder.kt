package com.example.mymusic.view.viewHolder

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymusic.databinding.ItemMusicHomeBinding
import com.example.mymusic.models.Song

class MusicViewHolder(binding: ItemMusicHomeBinding, private val listener: MusicAdapterListener): RecyclerView.ViewHolder(binding.root) {

    var binding: ItemMusicHomeBinding

    init {
        this.binding = binding
    }

    fun bind(context: Context?, result: Song) {
        context?.let {
            Glide.with(it).load(result.image).fitCenter().into(binding.imageCardPlayList)
            binding.root.setOnClickListener {
                listener.onClick(result)
            }
        }
    }

    interface MusicAdapterListener {
        fun onClick(song: Song)
    }
}