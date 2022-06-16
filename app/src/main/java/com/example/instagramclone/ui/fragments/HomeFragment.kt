package com.example.instagramclone.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclone.*
import com.example.instagramclone.Adapter.IPostAdapter
import com.example.instagramclone.Adapter.PostAdapter
import com.example.instagramclone.Adapter.StoryAdapter
import com.example.instagramclone.daos.PostDao
import com.example.instagramclone.databinding.FragmentHomeBinding
import com.example.instagramclone.datasource.StoryDataSource
import com.example.instagramclone.datasource.FeedDataSource
import com.example.instagramclone.model.Post
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.faltenreich.skeletonlayout.createSkeleton
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query


class HomeFragment : Fragment(R.layout.fragment_home), IPostAdapter {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var postDao : PostDao
    private lateinit var adapter: PostAdapter
    private var our_request_code: Int = 123
    private lateinit var skeleton: Skeleton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        //feed Recycler View

//        val myDataSet = FeedDataSource().loadFeedDetails()
//        binding.feedRecyclerview.adapter = FeedAdapter(requireContext(), myDataSet)
//        binding.feedRecyclerview.setHasFixedSize(true)

        //in our adapter we have to pass the recycler view options means how we have to show the data
        //so ,in this case we want the data from the Post collections and want in Descending order by CreatedAt
        postDao = PostDao()
        val postCollection = postDao.postCollection
        val query = postCollection.orderBy("createdAt", Query.Direction.DESCENDING)
        val recyclerViewOptions = FirestoreRecyclerOptions.Builder<Post>().setQuery(query,Post::class.java).build()

        adapter = PostAdapter(recyclerViewOptions,this)
        binding.feedRecyclerview.adapter = adapter
        binding.feedRecyclerview.setHasFixedSize(true)

        //Story Recycler View
        val storyDataSet = StoryDataSource().loadStoryDetails()
        binding.storyRecycler.adapter = StoryAdapter(requireContext(), storyDataSet)
        binding.storyRecycler.setHasFixedSize(true)



        binding.postSendImage.setOnClickListener {
            val intent = Intent(requireContext(), MessageActivity::class.java)
            startActivity(intent)
        }

        binding.cameraButton.setOnClickListener {
            val intent = Intent(requireContext(), CameraActivity::class.java)
            startActivity(intent)

        }

        // Either use an existing Skeletonlayout
        skeleton = binding.skeletonLayout

        // or create a new SkeletonLayout from a given View
        skeleton = view.createSkeleton()

        skeleton = binding.storyRecycler.applySkeleton(R.layout.story_items)
        skeleton = binding.feedRecyclerview.applySkeleton(R.layout.post_items)

//        skeleton.showSkeleton()


    }

    private fun onDataLoaded() {
        skeleton.showOriginal()
    }

    //so that firestore Recycler view starts observing to the data base and update it in real time
    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

    override fun onLikeClicked(postId: String) {
        postDao.updateLikes(postId)
    }

}