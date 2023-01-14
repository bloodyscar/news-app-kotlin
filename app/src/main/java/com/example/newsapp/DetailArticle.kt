package com.example.newsapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ActivityDetailArticleBinding
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.model.Articles

class DetailArticle : AppCompatActivity() {
    private lateinit var detailArticleBinding: ActivityDetailArticleBinding

    companion object {
        const val EXTRA_ARTICLE = "extra_article"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_article)

        detailArticleBinding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(detailArticleBinding.root)

        Log.d("DETAIL", intent.getParcelableExtra<Articles>(EXTRA_ARTICLE).toString())

        val article = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Articles>(EXTRA_ARTICLE)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Articles>(EXTRA_ARTICLE)
        }

        if(article != null){
            detailArticleBinding.tvTitle.text = article.title
            detailArticleBinding.tvSubtitle.text = article.content
            Glide.with(this).load(article.urlToImage).into(detailArticleBinding.imageView2)
        }



    }
}