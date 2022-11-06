package com.example.mymusic.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymusic.databinding.FragmentHomeBinding
import com.example.mymusic.models.HeaderModel
import com.example.mymusic.models.Song
import com.example.mymusic.viewModel.HomeViewModel
import com.example.mymusic.util.Constant
import com.example.mymusic.util.SharedPreferences
import com.example.mymusic.view.adapter.ArtistsFavoritesAdapter
import com.example.mymusic.view.adapter.MusicHomeAdapter
import com.example.mymusic.view.viewHolder.MusicViewHolder

class HomeFragment : Fragment(), MusicViewHolder.MusicAdapterListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: MusicHomeAdapter
    private val viewModel: HomeViewModel by viewModels()
    private val listSong = ArrayList<Song>()
    //list false
    private val listSongFavorites = ArrayList<Song>()
    private lateinit var adapterFavorites: ArtistsFavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initAdapter()
        initObservers()
        return binding.root
    }

    private fun initAdapter() {
        adapter = MusicHomeAdapter(listSong, this)
        //adapter false
        adapterFavorites = ArtistsFavoritesAdapter(listSongFavorites)
    }

    override fun onResume() {
        super.onResume()
        val header = HeaderModel(
            key = Constant.Headers.AUTHORIZATIONS, value = SharedPreferences.getToken(requireContext())
        )
        viewModel.getMusic(header)
        setInfoArtistsFavorites()
    }

    override fun onClick(song: Song) {
        //Glide.with(requireContext()).load(song.image).fitCenter().into(binding.imageHeader)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObservers() {
        viewModel.successResponse.observe(viewLifecycleOwner) { songs ->
            songs?.let {
                listSong.addAll(songs)
                val myAdapter = adapter
                binding.recyclerviewPlayList.adapter = myAdapter
                myAdapter.notifyDataSetChanged()
            }
        }
    }

    /**
     * Data false
     */

    @SuppressLint("NotifyDataSetChanged")
    private fun setInfoArtistsFavorites() {
        listSongFavorites.addAll(getArtistsFavorites())
        val myAdapter = adapterFavorites
        binding.recyclerviewArtistsFavorites.adapter = myAdapter
        myAdapter.notifyDataSetChanged()
    }

    private fun getArtistsFavorites(): List<Song> {
        return listOf(
            Song(null, null,null,null,"http://192.168.1.7:8080/api/music/images/802f2cd9-7232-4fa8-94d9-2837d24dfc26.jpeg",null,null),
            Song(null, null,null,null,"http://192.168.1.7:8080/api/music/images/4e0c991d-b25f-4581-8a34-6ea1fb07337a.jpeg",null,null),
            Song(null, null,null,null,"http://192.168.1.7:8080/api/music/images/802f2cd9-7232-4fa8-94d9-2837d24dfc26.jpeg",null,null),
            Song(null, null,null,null,"http://192.168.1.7:8080/api/music/images/4e0c991d-b25f-4581-8a34-6ea1fb07337a.jpeg",null,null),
            Song(null, null,null,null,"http://192.168.1.7:8080/api/music/images/802f2cd9-7232-4fa8-94d9-2837d24dfc26.jpeg",null,null),
        )
    }
}