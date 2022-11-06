package com.example.mymusic.models

data class MusicModel(
    val data: List<Song>? = null,
    val message: String? = null
)

data class Song(
    val album: String? = null,
    val artist: String? = null,
    val genre: String? = null,
    val id: String? = null,
    val image: String? = null,
    val song: String? = null,
    val title: String? = null
)