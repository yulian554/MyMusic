package com.example.mymusic.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymusic.util.Constant
import com.example.mymusic.models.HeaderModel
import com.example.mymusic.models.Song
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository(private val listener: ResponseGetMusic): ViewModel() {

    private val header: HeaderModel = HeaderModel(
        key = Constant.Headers.AUTHORIZATIONS, value = Constant.Headers.TOKEN
    )

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.Repo.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    private fun getClient() = OkHttpClient.Builder().addInterceptor(HeaderInterceptor(header)).build()

    fun getMusic(query: String) {
        viewModelScope.launch {
            val call =
                getRetrofit().create(APIServiceInterface::class.java).getMusicByTrend(query)
            call.body()
            run {
                if (call.isSuccessful) {
                    call.body()?.songs?.let {
                        listener.getSongsSuccess(it)
                    }
                }
            }
        }
    }

    interface ResponseGetMusic {
        fun getSongsSuccess(songs: List<Song>)
    }
}