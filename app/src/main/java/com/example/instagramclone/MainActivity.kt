package com.example.instagramclone

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.Adapter.FeedAdapter
import com.example.instagramclone.Adapter.MessageAdapter
import com.example.instagramclone.Adapter.StoryAdapter
import com.example.instagramclone.databinding.ActivityMainBinding
import com.example.instagramclone.ui.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Fragment Instance
    private val homeFragment = HomeFragment()
    private val likesFragment = LikesFragment()
    private val addFragment = AddFragment()
    private val accountFragment = AccountFragment()
    private val searchFragment = SearchFragment()

    private lateinit var binding: ActivityMainBinding
    private var our_request_code: Int = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        //feed Recycler View
//        val myDataSet = dataSource().loadFeedDetails()
//        binding.feedRecyclerview.adapter = FeedAdapter(this, myDataSet)
//        binding.feedRecyclerview.setHasFixedSize(true)
//
//
//        //Story Recycler View
//        val storyDataSet = StoryDataSource().loadStoryDetails()
//        binding.storyRecycler.adapter = StoryAdapter(this, storyDataSet)
//        binding.storyRecycler.setHasFixedSize(true)
//
//
//
//        binding.sendImage.setOnClickListener {
//            val intent = Intent(this, MessageActivity::class.java)
//            startActivity(intent)
//        }
//
//        binding.cameraButton.setOnClickListener {
//            val intent = Intent(this,CameraActivity::class.java)
//            startActivity(intent)

            //initially opening home fragment
        replaceFragment(homeFragment)

        //setting on click to the nav bar icons
        binding.bottomNavBar.setOnNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.home_page -> replaceFragment(homeFragment)
                R.id.add_page -> replaceFragment(addFragment)
                R.id.like_page -> replaceFragment(likesFragment)
                R.id.search_page -> replaceFragment(searchFragment)
                R.id.account_page -> replaceFragment(accountFragment)
            }
            true
        }
    }

    //this will replace the fragments in our fragment container which is frame layout
    private fun replaceFragment(fragment: Fragment) {

        if (fragment != null) {

            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit()
        }
    }

}

