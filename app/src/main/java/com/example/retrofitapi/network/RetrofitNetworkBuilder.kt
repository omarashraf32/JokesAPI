package com.example.retrofitapi.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitNetworkBuilder {


    //Create Logger
    private val logger =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)//25trna BODY 3shan 3yznha tzhr fe logcat

    //Create OKHttp Client
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logger)

    //Create Retrofit Builder
    private val builder =
        Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())

    //Create Retrofit Instance                           mosh 3raf leh 3mel el step da????
    private val retrofit = builder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

}
