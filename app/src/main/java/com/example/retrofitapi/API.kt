package com.example.retrofitapi

import com.example.retrofitapi.Model.jokeResponce
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface jokeApiService {
//    @GET("joke/Any")                   //n2olo hna en el function el 3yznah hya (GET) we ndelo el (End Point)
//    fun getRendomJoke(): Call<jokeResponce> //hya btrg3 list of jokeResponce
//    //3mlnha fe (Call) leh 3shan hya asnchronous fun mosh 3raf emta httnafez
// n2olo hna en el function el 3yznah hya (GET) we ndelo el (End Point)

    @GET("joke/Any")
    fun getRendomJoke(@Query("category") category :String): Call<jokeResponce>

    @GET("joke/Any/{id}")
    fun getJoke(@Path("id") id :Int): Call<jokeResponce>                     //kda anta 3mlt function btrg3 joke id fe (Path)
}

object API { //3mle leh el object da??   && hwa hna kda tb2a mbd2 el single ton wla l2????

//    private val BASE_URL = "https://v2.jokeapi.dev/"
//    private val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//    val apiService = retrofit.create(jokeApiService::class.java)
//    //wzeft el cod da eno hy3mle request we hyrod 3lya be object
    ///////////////////////////////////////

    //BASE_URL
    private val BASE_URL = "https://v2.jokeapi.dev/"

    //Create Logger
    private val logger =HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)//25trna BODY 3shan 3yznha tzhr fe logcat

    //Create OKHttp Client
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logger)

    //Create Retrofit Builder
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())

    //Create Retrofit Instance                           mosh 3raf leh 3mel el step da????
    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>) :T {
        return retrofit.create(serviceType)
    }

}
