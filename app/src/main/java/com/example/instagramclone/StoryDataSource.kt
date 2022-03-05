package com.example.instagramclone

import com.example.instagramclone.utils.StoryData

class StoryDataSource() {

    fun loadStoryDetails() : List<StoryData>{

        return listOf<StoryData>(
            StoryData(R.drawable.yash,"Shivam"),
            StoryData(R.drawable.yash,"Shivam"),
            StoryData(R.drawable.yash,"Shivam"),
            StoryData(R.drawable.yash,"Shivam"),
            StoryData(R.drawable.yash,"Shivam"),
            StoryData(R.drawable.yash,"Shivam"),
            StoryData(R.drawable.yash,"Shivam"),
            StoryData(R.drawable.yash,"Shivam")
        )

    }
}