package com.example.instagramclone.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instagramclone.R
import com.example.instagramclone.model.Post
import com.example.instagramclone.utils.PostTime
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Document

class PostAdapter(options: FirestoreRecyclerOptions<Post>, val listener : IPostAdapter) :
    FirestoreRecyclerAdapter<Post, PostAdapter.PostViewHolder>(
        options
    ) {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val profileImage = itemView.findViewById<ImageView>(R.id.post_feed_image)
        val userName = itemView.findViewById<TextView>(R.id.post_user_name)
        val postText = itemView.findViewById<TextView>(R.id.post_text)
        val likeImage = itemView.findViewById<ImageView>(R.id.post_like_image)
        val likeCount = itemView.findViewById<TextView>(R.id.post_like_count)
        val createdAt = itemView.findViewById<TextView>(R.id.post_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val postViewHolder =  PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_items, parent, false)
        )

        postViewHolder.likeImage.setOnClickListener{

            listener.onLikeClicked(snapshots.getSnapshot(postViewHolder.adapterPosition).id)
        }

        return postViewHolder
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int, model: Post) {
        holder.postText.text = model.text
        holder.userName.text = model.createdBy.displayName
        Glide.with(holder.profileImage.context).load(model.createdBy.photoUrl).circleCrop()
            .into(holder.profileImage)
        holder.likeCount.text = model.likedBy.size.toString() + " likes"
        holder.createdAt.text = PostTime.getTineAgo(model.createdAt)

        val auth = Firebase.auth
        val currentUserId = auth.currentUser!!.uid
        val isLiked = model.likedBy.contains(currentUserId)

        if (isLiked){
            holder.likeImage.setImageDrawable(ContextCompat.getDrawable(holder.likeImage.context,R.drawable.ic_liked))
        }else{
            holder.likeImage.setImageDrawable(ContextCompat.getDrawable(holder.likeImage.context,R.drawable.ic_unliked))
        }
    }
}

interface IPostAdapter {
    fun onLikeClicked(postId: String)
}