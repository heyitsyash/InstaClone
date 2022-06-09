package com.example.instagramclone.utils

//model class which has to be added in the firestore collection
data class User(
    val uid : String = "",
    val displayName : String? = "",
    val photoUrl : String = ""
) {
}