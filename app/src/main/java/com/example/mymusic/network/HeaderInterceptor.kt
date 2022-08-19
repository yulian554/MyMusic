package com.example.mymusic.network

import com.example.mymusic.models.HeaderModel
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val header: HeaderModel?): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        header?.let { header ->
            val request = chain.request().newBuilder().addHeader(
                header.key ?: "", header.value ?: ""
            )
                .build()
            return chain.proceed(request)
        }
        return chain.proceed(chain.request())
    }
}