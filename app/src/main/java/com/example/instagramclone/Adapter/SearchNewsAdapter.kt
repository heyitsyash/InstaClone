package com.example.instagramclone.Adapter

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.example.instagramclone.R
import com.example.instagramclone.utils.Articles

class SearchNewsAdapter(private val context:Context, private val articles : List<Articles>) : RecyclerView.Adapter<SearchNewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val newsTitle : TextView = itemView.findViewById(R.id.news_text)
        val newsImage : ImageView = itemView.findViewById(R.id.news_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_items , parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val current = articles[position]
        holder.newsTitle.text = current.title
        Glide.with(holder.itemView.context).load(current.urlToImage).into(holder.newsImage)

    }

    override fun getItemCount(): Int {
        return articles.size
    }
}