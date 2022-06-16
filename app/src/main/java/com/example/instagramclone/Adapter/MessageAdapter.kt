package com.example.instagramclone.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.R
import com.example.instagramclone.model.MessageData

class MessageAdapter(context:Context, private val dataset : List<MessageData>):RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val messageImage : ImageView = itemView.findViewById(R.id.message_image)
        val messageName : TextView = itemView.findViewById(R.id.message_name)
        val message : TextView = itemView.findViewById(R.id.message_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.message_layout,parent,false)
        return MessageViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val item = dataset[position]
        holder.messageImage.setImageResource(item.ProfileId)
        holder.messageName.text = item.name
        holder.message.text = item.message
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}