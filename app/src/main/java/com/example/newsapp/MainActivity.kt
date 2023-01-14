package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.model.Articles
import com.example.newsapp.recyclerview.ListArticleAdapter
import com.example.newsapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel : MainViewModel
    private lateinit var activityMainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        supportActionBar?.hide()

        val layoutManager = LinearLayoutManager(this)
        activityMainBinding.rvNews.layoutManager = layoutManager


        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]

        mainViewModel.getApiArticle()

        mainViewModel.listArticles.observe(this) { restaurant ->
            setArticle(restaurant)
        }


    }

    private fun setArticle(article: List<Articles>) {
        val adapter = ListArticleAdapter(this, article)

        activityMainBinding.rvNews.adapter = adapter

    }

}