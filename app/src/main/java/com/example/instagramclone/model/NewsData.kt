package com.example.instagramclone.model

data class NewsData(
    val articles: List<Articles>,
    val status: String,
    val totalResults: Int
)