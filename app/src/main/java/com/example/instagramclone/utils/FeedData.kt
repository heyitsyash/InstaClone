package com.example.instagramclone.utils

import androidx.annotation.DrawableRes
import org.w3c.dom.Text

data class FeedData(
    @DrawableRes val profileResId : Int,
    val nameText: String,
    val placeText : String,
    @DrawableRes val postResId : Int
) {
}