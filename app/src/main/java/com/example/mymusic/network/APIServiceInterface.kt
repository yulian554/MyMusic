package com.example.mymusic.network

import com.example.mymusic.models.MusicModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIServiceInterface {
    @GET
    suspend fun getMusicByTrend(@Url url: String): Response<MusicModel>
}