package com.example.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.Articles
import com.example.newsapp.model.News
import com.example.newsapp.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _listArticles = MutableLiveData<List<Articles>>()
    val listArticles: LiveData<List<Articles>> = _listArticles

    companion object {
        private const val TAG = "MainViewModel"
        private const val API_KEY = "2a64d802f0564f2d8704c7655f025a64"
        private const val SOURCES = "techcrunch"
    }

    fun getApiArticle(){
        val client = ApiConfig.getApiService().getArticles(SOURCES, API_KEY)
        client.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                if(response.isSuccessful){
                    val responseBody = response.body()
                    Log.d(TAG, responseBody.toString())
                    if (responseBody != null) {
                        _listArticles.value = responseBody.articles
                    }
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
    }
}