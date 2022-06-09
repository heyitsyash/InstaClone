package com.example.instagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplachScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach_screen)

        Handler().postDelayed({
            finish()
          val signIn = Intent(this, SignInActivity::class.java)
          startActivity(signIn)
            finish()
        },2000)
    }
}