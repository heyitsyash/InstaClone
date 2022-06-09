package com.example.instagramclone.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagramclone.Adapter.SearchMemesAdapter
import com.example.instagramclone.Adapter.SearchNewsAdapter
import com.example.instagramclone.repository.MemeInterface
import com.example.instagramclone.repository.NewsInterface
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentSearchBinding
import com.example.instagramclone.utils.MemesData
import com.example.instagramclone.utils.NewsData
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_MEMES_URl = "https://meme-api.herokuapp.com/"
const val BASE_NEWS_URL = "https://newsapi.org/"
private lateinit var binding: FragmentSearchBinding
private lateinit var searchAdapter: SearchMemesAdapter
private lateinit var searchNewsAdapter: SearchNewsAdapter

class SearchFragment : Fragment(R.layout.fragment_search) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchRecycleView.layoutManager =
            LinearLayoutManager(requireContext())
        binding.searchRecycleView.setHasFixedSize(true)
        binding.progressBar.visibility = View.VISIBLE
        fetchNews()

        binding.refresh.setOnClickListener {
            Toast.makeText(requireContext(), "Nothing to do yet", Toast.LENGTH_SHORT).show()
        }

        binding.newsButton.setOnClickListener{
            binding.progressBar.visibility = View.VISIBLE
            fetchNews()
        }

        binding.memesButton.setOnClickListener{
            binding.progressBar.visibility = View.VISIBLE
            fetchMemes()
        }

    }


    private fun fetchMemes() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_MEMES_URl)
            .build()
            .create(MemeInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<MemesData> {
            override fun onResponse(call: Call<MemesData>, response: Response<MemesData>) {


                binding.progressBar.visibility = View.GONE
                val responseBody: MemesData = response.body()!!
                searchAdapter = SearchMemesAdapter(requireContext(), responseBody.memes)
                binding.searchRecycleView.adapter = searchAdapter


            }

            override fun onFailure(call: Call<MemesData>, t: Throwable) {

                Toast.makeText(requireContext(), "Unable to show Data", Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun fetchNews(){

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_NEWS_URL)
            .build()
            .create(NewsInterface::class.java)

        val retrofitData = retrofitBuilder.getNews()

        retrofitData.enqueue(object : Callback<NewsData>{
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {


                binding.progressBar.visibility = View.GONE
                val responseBody: NewsData = response.body()!!
                searchNewsAdapter = SearchNewsAdapter(requireContext(), responseBody.articles)
                binding.searchRecycleView.adapter = searchNewsAdapter

            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Toast.makeText(requireContext(), "Unable to show Data", Toast.LENGTH_LONG).show()
            }
        })
    }

}



