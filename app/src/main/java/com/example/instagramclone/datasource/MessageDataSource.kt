package com.example.instagramclone.datasource

import com.example.instagramclone.R
import com.example.instagramclone.model.MessageData

class MessageDataSource() {


    fun loadMessageDetails():List<MessageData>
    {

        return listOf<MessageData>(
            MessageData(R.drawable.shivam, "Shivam","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.kuldeep, "Kuldeep","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.jay, "jay","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.abhay, "Abhay","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.abhishek, "Ankush","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.vineet, "Vineet","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.devansh, "Devansh","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.palak, "Palak","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.harsh, "Harsh","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.rahul, "Rahul","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.yash, "Shivam","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.yash, "abhay","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.yash, "Ronak","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.yash, "aayush","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.yash, "luvkush","Sent TatvIndia Reels... 16h"),
            MessageData(R.drawable.yash, "gaurav","Sent TatvIndia Reels... 16h")
        )

    }
}