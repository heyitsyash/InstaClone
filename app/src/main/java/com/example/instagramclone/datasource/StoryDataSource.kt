package com.example.instagramclone.datasource

import com.example.instagramclone.R
import com.example.instagramclone.model.StoryData

class StoryDataSource() {

    fun loadStoryDetails() : List<StoryData>{

        return listOf<StoryData>(
            StoryData(R.drawable.yash,"yash"),
            StoryData(R.drawable.shivam,"Shivam"),
            StoryData(R.drawable.kuldeep,"kuldeep"),
            StoryData(R.drawable.harsh,"harsh"),
            StoryData(R.drawable.jay,"jay"),
            StoryData(R.drawable.palak,"palak"),
            StoryData(R.drawable.vineet,"vineet"),
            StoryData(R.drawable.rahul,"rahul"),
            StoryData(R.drawable.shivam,"rudra"),
            StoryData(R.drawable.abhay,"abhay"),
            StoryData(R.drawable.abhishek,"ankush"),
            StoryData(R.drawable.yash,"aayush"),
            StoryData(R.drawable.yash,"ronak"),
            StoryData(R.drawable.yash,"abhishek"),
            StoryData(R.drawable.yash,"Shivam")
        )

    }
}