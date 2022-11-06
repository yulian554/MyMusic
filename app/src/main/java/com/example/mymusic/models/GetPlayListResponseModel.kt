package com.example.mymusic.models

data class GetPlayListResponseModel(
    val data: List<Data>,
    val message: String
)

data class Data(
    val _id: String,
    val name: String,
    val songs: List<SongPlayList>,
    val user: String
)

data class SongPlayList(
    val __v: Int,
    val _id: String,
    val album: String,
    val artist: String,
    val genre: String,
    val image: String,
    val song: String,
    val title: String
)