package com.example.mymusic.network

import com.example.mymusic.models.HeaderModel
import com.example.mymusic.util.Constant.Repo.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private fun retrofit(header: HeaderModel? = null): Retrofit {
        return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .client(getClient(header))
               .build()
    }

    private fun getClient(header: HeaderModel? = null) = OkHttpClient.Builder().addInterceptor(HeaderInterceptor(header)).build()

    val api: APIServiceInterface by lazy {
        retrofit().create(APIServiceInterface::class.java)
    }

    fun apiHeader(header: HeaderModel): APIServiceInterface {
        return retrofit(header).create(APIServiceInterface::class.java)
    }
}