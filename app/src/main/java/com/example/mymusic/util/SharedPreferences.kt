package com.example.mymusic.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferences {

    /**
     * Returns instant of preferences
     */
    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("data", Context.MODE_PRIVATE)
    }

    fun setToken(context: Context, token: String) {
        getSharedPreferences(context).edit().putString("token", token).apply()
    }

    fun getToken(context: Context): String? {
        return getSharedPreferences(context).getString("token", "")
    }
}