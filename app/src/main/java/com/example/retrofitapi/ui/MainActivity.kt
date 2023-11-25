package com.example.retrofitapi.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapi.Model.jokeResponce
import com.example.retrofitapi.databinding.ActivityMainBinding
import com.example.retrofitapi.ui.viewmodel.JokeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var jokesAdapter: jokesAdapter
    private lateinit var jokeViewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecyclerView()
        GetJokes()
        observe()


//        fetchJoke(id)
    }

    private fun observe() {
        jokeViewModel.jokeLiveData.observe(this, Observer{Joke ->
           if (jokesAdapter != null)
               jokesAdapter.currentList
        })

        jokeViewModel.massegeLiveData.observe(this, Observer{Joke ->
            Toast.makeText(this, "Error...", Toast.LENGTH_SHORT).show()

        })
    }

    private fun GetJokes() {
        jokeViewModel = ViewModelProvider(this).get(JokeViewModel::class.java)
        jokeViewModel.fetchJokes()
    }

    private fun initRecyclerView() {
        jokesAdapter = jokesAdapter()
           binding.jokesRecycler.layoutManager =
            LinearLayoutManager(this@MainActivity)
            binding.jokesRecycler.adapter = jokesAdapter
        }

    private fun fetchJoke(id: Int) {
        val fetchService = API.buildService(jokeApiService::class.java)

        val requestCall = fetchService.getJoke(id)

        requestCall.enqueue(object : Callback<jokeResponce> {
            override fun onResponse(call: Call<jokeResponce>, response: Response<jokeResponce>) {
                if (response.isSuccessful) {
                    //yuor status code is in the range 200 to 299
                    Log.d("ttttt", "onResponse: " + response.body())

                } else {
                    //yuor status code is in the range 300, 400, 500
                    Toast.makeText(this@MainActivity, "Not Successful", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<jokeResponce>, t: Throwable) {
                Log.d("ttttt", "onFailure: " + t.localizedMessage)
            }

        })


    }


}