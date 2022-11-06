package com.example.mymusic.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymusic.models.GetTokensModel
import com.example.mymusic.network.RetrofitInstance
import com.example.mymusic.util.Event
import com.example.mymusic.viewModel.resource.AuthenticationLoginResource
import kotlinx.coroutines.launch

class AuthenticationLoginViewModel: ViewModel() {

    private val _eventGetToken = MutableLiveData<Event<AuthenticationLoginResource>>()
    val eventGetToken:  LiveData<Event<AuthenticationLoginResource>>
       get() = _eventGetToken

    fun getTokens(body: GetTokensModel) {
        _eventGetToken.postValue(Event(AuthenticationLoginResource.Loading))
        viewModelScope.launch {
            val response = RetrofitInstance.api.getToken(body).body()?.token
            if (!response.isNullOrEmpty()) {
                _eventGetToken.postValue(Event(AuthenticationLoginResource.SuccessGetToken(response)))
            } else {
                _eventGetToken.postValue(Event(AuthenticationLoginResource.FailureGetToken))
            }
        }
    }
}