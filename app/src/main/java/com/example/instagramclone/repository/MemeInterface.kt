package com.example.instagramclone.repository

import com.example.instagramclone.utils.MemesData
import retrofit2.Call
import retrofit2.http.GET

interface MemeInterface {

    companion object{
        const val END_URl = "gimme/50"
    }

    @GET(END_URl)
    fun getData() :Call<MemesData>
}