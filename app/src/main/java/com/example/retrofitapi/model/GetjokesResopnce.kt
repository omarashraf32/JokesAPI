package com.example.retrofitapi.model


import com.google.gson.annotations.SerializedName

data class GetjokesResopnce(
    @SerializedName("amount")
    val amount: Int? = 0,
    @SerializedName("error")
    val error: Boolean? = false,
    @SerializedName("jokes")
    val jokes: List<Joke>? = listOf()
)