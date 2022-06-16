package com.example.instagramclone.model

import androidx.annotation.DrawableRes

data class FeedData(
    @DrawableRes val profileResId : Int,
    val nameText: String,
    val placeText : String,
    @DrawableRes val postResId : Int
) {
}