package com.example.mymusic.util

object Constant {

    class Headers {
        companion object {
            const val AUTHORIZATIONS = "Authorization"
        }
    }

    class Repo {
        companion object {
            const val BASE_URL = "http://192.168.1.2:8080/api/"
        }
    }

    class Query {
        companion object {
            const val QUERY_GET_ALL_MUSIC = "music"
            const val QUERY_AUTHENTICATION = "auth"
            const val QUERY_GET_PLAY_LIST = "playlist/get-play-lists"
        }
    }

}