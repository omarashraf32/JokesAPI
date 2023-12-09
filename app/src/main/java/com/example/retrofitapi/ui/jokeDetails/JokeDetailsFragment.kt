package com.example.retrofitapi.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.retrofitapi.databinding.FragmentJokeDetailsBinding
import com.example.retrofitapi.models.Joke
import com.example.retrofitapi.models.jokeResponce
import com.example.retrofitapi.network.ApiService
import com.example.retrofitapi.network.RetrofitNetworkBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeDetailsFragment : Fragment() {
    private var _binding: FragmentJokeDetailsBinding? = null
    private val binding get() = _binding!!
    private var joke :Joke? =Joke()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentJokeDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passData()
        fatchData(

    }

    private fun fatchData() {
        val apiService = RetrofitNetworkBuilder.buildService(ApiService::class.java)
        apiService.getJoke(id).enqueue(object :Callback<jokeResponce>{
            override fun onResponse(call: Call<jokeResponce>, response: Response<jokeResponce>) {
                response.isSuccessful
                response.body()
            }

            override fun onFailure(call: Call<jokeResponce>, t: Throwable) {
                Log.d("TAG", "onFailure: ")
            }

        })

    }


    private fun passData() {
        val bundle = this.arguments
        if (bundle != null) {
            joke = bundle.getParcelable<Joke>("data")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}