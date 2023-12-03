package com.example.retrofitapi.network

import com.example.retrofitapi.model.GetjokesResopnce
import com.example.retrofitapi.model.jokeResponce
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("joke/Any?amount=20")
    fun getJokes(): Call<GetjokesResopnce>

    @GET("joke/Any")
    fun getRandomJoke(@Query("category") category :String): Call<jokeResponce>

    @GET("joke/Any/{id}")
    fun getJoke(@Path("id") id :Int): Call<jokeResponce>                     //kda anta 3mlt function btrg3 joke id fe (Path)
}