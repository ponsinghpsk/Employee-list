package com.ponsingh.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    companion object {
        private lateinit var retrofit: Retrofit

    fun getApi():Retrofit {
        if (this::retrofit.isInitialized.not()) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }


    }
}