package com.example.mymusic.network

import com.example.mymusic.models.GetPlayListResponseModel
import com.example.mymusic.models.GetTokenResponse
import com.example.mymusic.models.GetTokensModel
import com.example.mymusic.models.MusicModel
import com.example.mymusic.util.Constant
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface APIServiceInterface {
    @GET(Constant.Query.QUERY_GET_ALL_MUSIC)
    suspend fun getMusicByTrend(): Response<MusicModel>

    @POST(Constant.Query.QUERY_AUTHENTICATION)
    suspend fun getToken(@Body getTokensModel: GetTokensModel): Response<GetTokenResponse>

    @GET
    suspend fun getPlayListByTrend(@Url url: String): Response<GetPlayListResponseModel>
}