package com.example.instagramclone

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import com.example.instagramclone.databinding.ActivityCameraBinding

private lateinit var binding : ActivityCameraBinding
private var our_request_code : Int = 123
class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clickImage.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, our_request_code)
            }
        }

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == our_request_code && resultCode == RESULT_OK){

            val bitmap = data?.extras?.get("data") as Bitmap
            binding.showCameraImage.setImageBitmap(bitmap)
        }
    }

}