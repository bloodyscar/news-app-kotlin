package com.example.newsapp.retrofit

import com.example.newsapp.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
    fun getArticles(@Query("sources") sources : String, @Query("apiKey") apiKey : String) : Call<News>
}