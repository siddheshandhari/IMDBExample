package com.example.imdbexample.network

import com.example.imdbexample.model.MostPopularData
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface IMDBService {
    @GET("MostPopularMovies/k_ts65mp1h")
    fun listMostPopularMovies(): Call<MostPopularData>
}

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://imdb-api.com/en/API/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun create() : IMDBService {
        return retrofit.create(IMDBService::class.java)
    }
}