package com.example.instagramclone.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instagramclone.R
import com.example.instagramclone.daos.PostDao
import com.example.instagramclone.databinding.FragmentAddBinding


class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postDao = PostDao()
        binding.postButton.setOnClickListener {

            val text = binding.postEditText.text.toString().trim()
            if (text.isNotEmpty()) {
                postDao.addPost(text)
                activity?.finish()
            }
        }
    }
}