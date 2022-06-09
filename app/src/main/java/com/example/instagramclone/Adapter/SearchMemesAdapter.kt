package com.example.instagramclone.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.R
import com.example.instagramclone.utils.Memes

class SearchMemesAdapter(private val context: Context, private val dataset : List<Memes>) : RecyclerView.Adapter<SearchMemesAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val memesImage : ImageView = itemView.findViewById(R.id.memes_image)
        val memesTitle : TextView = itemView.findViewById(R.id.memes_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.search_items,parent,false)
        return ViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = dataset[position]
        holder.memesTitle.text = item.title
        Glide.with(holder.itemView.context).load(item.url).into(holder.memesImage)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}