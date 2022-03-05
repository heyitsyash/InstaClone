package com.example.instagramclone.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.utils.FeedData

class FeedAdapter(private val context:Context,private val dataset:List<FeedData>) :
    RecyclerView.Adapter<FeedAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val profileImage:ImageView = view.findViewById(R.id.profile_feed_image)
        val nameText:TextView = view.findViewById(R.id.name_text)
        val placeText :TextView = view.findViewById(R.id.place_text)
        val postImage : ImageView = view.findViewById(R.id.post_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adaterLayout = LayoutInflater.from(parent.context).inflate(R.layout.feed_items,parent,false)
        return ItemViewHolder(adaterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]
        holder.profileImage.setImageResource(item.profileResId)
        holder.nameText.text = item.nameText
        holder.placeText.setText(item.placeText)
        holder.postImage.setImageResource(item.postResId)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}