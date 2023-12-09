package com.example.retrofitapi.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
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
): Parcelable