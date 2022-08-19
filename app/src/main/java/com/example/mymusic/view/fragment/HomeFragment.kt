package com.example.mymusic.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mymusic.databinding.FragmentHomeBinding
import com.example.mymusic.models.Song
import com.example.mymusic.network.Repository
import com.example.mymusic.view.MusicHomeAdapter

class HomeFragment : Fragment(), MusicHomeAdapter.MusicAdapterListener, Repository.ResponseGetMusic {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: MusicHomeAdapter
    private val listSong = ArrayList<Song>()
    private val myRepo = Repository(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        adapter = MusicHomeAdapter(listSong, this)
        binding.recyclerViewMusic.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        myRepo.getMusic("music")
    }

    override fun onClick(movie: Song) {
        TODO("Not yet implemented")
    }

    override fun getSongsSuccess(songs: List<Song>) {
        Glide.with(requireContext()).load(songs.first().image).fitCenter().into(binding.imageHeader)
        binding.imageHeader
        listSong.addAll(songs)
        val myAdapter = adapter
        binding.recyclerViewMusic.adapter = myAdapter
        myAdapter.notifyDataSetChanged()
    }
}