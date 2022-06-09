package com.example.instagramclone.datasource

import com.example.instagramclone.R
import com.example.instagramclone.utils.FeedData

class FeedDataSource() {

    fun loadFeedDetails() : List<FeedData>{

        return listOf<FeedData>(
            FeedData(R.drawable.yash,"Yash","Gwalior MP", R.drawable.family),
            FeedData(R.drawable.shivam,"Shivam","Gwalior MP", R.drawable.shivam),
            FeedData(R.drawable.kuldeep,"Kuldeep","Gwalior MP", R.drawable.kuldeep),
            FeedData(R.drawable.vineet,"Vineet","Gwalior MP", R.drawable.vineet),
            FeedData(R.drawable.palak,"Palak","Gwalior MP", R.drawable.palak),
            FeedData(R.drawable.jay,"jay","Gwalior MP", R.drawable.jay),
            FeedData(R.drawable.abhay,"Abhay","Gwalior MP", R.drawable.abhay),
            FeedData(R.drawable.devansh,"Devansh","Gwalior MP", R.drawable.devansh),
            FeedData(R.drawable.rahul,"Rahul","Gwalior MP", R.drawable.rahul),
            FeedData(R.drawable.harsh,"Harsh","Gwalior MP", R.drawable.harsh))

    }
}