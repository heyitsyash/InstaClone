package com.example.instagramclone.repository

import com.example.instagramclone.utils.NewsData
import retrofit2.Call
import retrofit2.http.GET

interface NewsInterface {

    companion object{
        const val END_URl = "v2/top-headlines?country=in&category=business&apiKey=d428373dc9054d32afefb94594d2f240"
    }
    @GET(END_URl)
    fun getNews() : Call<NewsData>
}