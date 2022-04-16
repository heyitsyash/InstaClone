package com.example.instagramclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instagramclone.Adapter.MessageAdapter
import com.example.instagramclone.databinding.ActivityMessageBinding
import com.example.instagramclone.datasource.MessageDataSource

private lateinit var binding :ActivityMessageBinding
class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Message Recycler View
        val messageDataSet = MessageDataSource().loadMessageDetails()
        binding.messRecyclerView.adapter = MessageAdapter(this,messageDataSet)
        binding.messRecyclerView.setHasFixedSize(true)
    }
}