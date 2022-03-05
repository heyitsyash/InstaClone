package com.example.instagramclone

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagramclone.Adapter.FeedAdapter
import com.example.instagramclone.Adapter.StoryAdapter
import com.example.instagramclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataSet = dataSource().loadFeedDetails()

        binding.feedRecyclerview.adapter = FeedAdapter(this,myDataSet)
        binding.feedRecyclerview.setHasFixedSize(true)

        val storyDataSet = StoryDataSource().loadStoryDetails()

        binding.storyRecycler.adapter = StoryAdapter(this,storyDataSet)
        binding.storyRecycler.setHasFixedSize(true)
    }
}