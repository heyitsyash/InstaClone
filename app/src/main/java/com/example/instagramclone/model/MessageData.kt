package com.example.instagramclone.model

import androidx.annotation.DrawableRes

data class MessageData(
    @DrawableRes val ProfileId: Int,
    val name : String,
    val message : String
) {
}