package com.example.instagramclone.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.model.StoryData

class StoryAdapter(private val context:Context,private val dataset : List<StoryData>) : RecyclerView.Adapter<StoryAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view:View) : RecyclerView.ViewHolder(view){
        val storyImage : ImageView = view.findViewById(R.id.story_image)
        val storyName : TextView = view.findViewById(R.id.story_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.story_items,parent,false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.storyImage.setImageResource(item.storyImageId)
        holder.storyName.text = item.storyName
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}