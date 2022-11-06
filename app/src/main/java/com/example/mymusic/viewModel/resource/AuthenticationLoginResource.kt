package com.example.mymusic.viewModel.resource

sealed class AuthenticationLoginResource(val successToken: String? = null) {
    object Loading: AuthenticationLoginResource()
    class SuccessGetToken(token: String): AuthenticationLoginResource(token)
    object FailureGetToken : AuthenticationLoginResource()
}
