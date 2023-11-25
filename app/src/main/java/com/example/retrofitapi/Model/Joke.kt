package com.example.retrofitapi.Model


import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("delivery")
    val delivery: String? = "",
    @SerializedName("flags")
    val flags: Flags? = Flags(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("lang")
    val lang: String? = "",
    @SerializedName("safe")
    val safe: Boolean? = false,
    @SerializedName("setup")
    val setup: String? = "",
    @SerializedName("type")
    val type: String? = ""
)