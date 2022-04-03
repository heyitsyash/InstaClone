package com.example.instagramclone

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.Adapter.FeedAdapter
import com.example.instagramclone.Adapter.MessageAdapter
import com.example.instagramclone.Adapter.StoryAdapter
import com.example.instagramclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var our_request_code: Int = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //feed Recycler View
        val myDataSet = dataSource().loadFeedDetails()
        binding.feedRecyclerview.adapter = FeedAdapter(this, myDataSet)
        binding.feedRecyclerview.setHasFixedSize(true)


        //Story Recycler View
        val storyDataSet = StoryDataSource().loadStoryDetails()
        binding.storyRecycler.adapter = StoryAdapter(this, storyDataSet)
        binding.storyRecycler.setHasFixedSize(true)



        binding.sendImage.setOnClickListener {
            val intent = Intent(this, MessageActivity::class.java)
            startActivity(intent)
        }

        binding.cameraButton.setOnClickListener {
            val intent = Intent(this,CameraActivity::class.java)
            startActivity(intent)

        }

    }
}
