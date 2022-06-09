package com.example.instagramclone.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclone.*
import com.example.instagramclone.Adapter.FeedAdapter
import com.example.instagramclone.Adapter.StoryAdapter
import com.example.instagramclone.databinding.FragmentHomeBinding
import com.example.instagramclone.datasource.StoryDataSource
import com.example.instagramclone.datasource.FeedDataSource


private lateinit var binding : FragmentHomeBinding
private var our_request_code: Int = 123
class HomeFragment : Fragment(R.layout.fragment_home) {
    // TODO: Rename and change types of parameters

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //feed Recycler View
        val myDataSet = FeedDataSource().loadFeedDetails()
        binding.feedRecyclerview.adapter = FeedAdapter(requireContext(), myDataSet)
        binding.feedRecyclerview.setHasFixedSize(true)

        //Story Recycler View
        val storyDataSet = StoryDataSource().loadStoryDetails()
        binding.storyRecycler.adapter = StoryAdapter(requireContext(), storyDataSet)
        binding.storyRecycler.setHasFixedSize(true)



        binding.sendImage.setOnClickListener {
            val intent = Intent(requireContext(), MessageActivity::class.java)
            startActivity(intent)
        }

        binding.cameraButton.setOnClickListener {
            val intent = Intent(requireContext(), CameraActivity::class.java)
            startActivity(intent)

        }
    }

}