package com.example.instagramclone.model

import androidx.annotation.DrawableRes

data class StoryData(
    @DrawableRes val storyImageId: Int,
    val storyName : String
) {
}