package com.example.newsapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class News (
    @field:SerializedName("articles")
    val articles : List<Articles>
)

@Parcelize
data class Articles (
    @field:SerializedName("title")
    val title : String,

    @field:SerializedName("description")
    val description : String,

    @field:SerializedName("urlToImage")
    val urlToImage : String,

    @field:SerializedName("content")
    val content : String
) : Parcelable
