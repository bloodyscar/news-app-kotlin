package com.example.newsapp.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {

    companion object{
        fun getApiService() : ApiService {
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder().addInterceptor(logging).build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}