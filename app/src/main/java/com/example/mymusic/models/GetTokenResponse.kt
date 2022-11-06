package com.example.mymusic.models

import java.io.Serializable

data class GetTokenResponse (
    val token: String? = null,
    val message: String? = null,
    val isValid: Boolean? = null
): Serializable