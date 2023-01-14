package com.example.newsapp.recyclerview

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.DetailArticle
import com.example.newsapp.R
import com.example.newsapp.model.Articles

class ListArticleAdapter(private val listArticle : List<Articles>) : RecyclerView.Adapter<ListArticleAdapter.ViewHolder>() {

    lateinit var ctx: Context

    constructor(context: Context, items: List<Articles>): this(items){
        ctx = context
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.title)
        val subTitle : TextView = itemView.findViewById(R.id.subTitle)
        val img : ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener{
            val moveIntent = Intent(holder.itemView.context, DetailArticle::class.java)
            moveIntent.putExtra(DetailArticle.EXTRA_ARTICLE, listArticle[position])
            holder.itemView.context.startActivity(moveIntent)
        }

        holder.title.text = listArticle[position].title
        holder.subTitle.text = listArticle[position].description
        Glide.with(ctx).load(listArticle[position].urlToImage).into(holder.img)


    }

    override fun getItemCount(): Int {
        return listArticle.size
    }
}