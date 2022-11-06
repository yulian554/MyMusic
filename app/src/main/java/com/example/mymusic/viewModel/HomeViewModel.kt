package com.example.mymusic.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymusic.util.Constant
import com.example.mymusic.models.HeaderModel
import com.example.mymusic.models.Song
import com.example.mymusic.network.APIServiceInterface
import com.example.mymusic.network.HeaderInterceptor
import com.example.mymusic.network.RetrofitInstance
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel: ViewModel() {

    private val _successResponse = MutableLiveData<List<Song>>()
    val successResponse: LiveData<List<Song>>
        get() = _successResponse


    fun getMusic(header: HeaderModel) {
        viewModelScope.launch {
            val call = RetrofitInstance.apiHeader(header)
            val response = call.getMusicByTrend().body()
            response?.data?.let {
                _successResponse.postValue(it)
            }
        }
    }
}