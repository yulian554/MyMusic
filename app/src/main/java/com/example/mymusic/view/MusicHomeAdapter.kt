package com.example.mymusic.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymusic.databinding.ItemMusicHomeBinding
import com.example.mymusic.models.Song

class MusicHomeAdapter(private val songs: ArrayList<Song>, private val listener: MusicAdapterListener) : RecyclerView.Adapter<MusicViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        context = parent.context
        val binding = ItemMusicHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(context,songs[position])
        holder.itemView.setOnClickListener {
            listener.onClick(songs[position])
        }
    }

    override fun getItemCount(): Int = songs.size

    interface MusicAdapterListener {
        fun onClick(movie: Song)
    }
}