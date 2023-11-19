package com.example.retrofitapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapi.Model.jokeResponce
import com.example.retrofitapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchJokes()




//        fetchJoke(id)
    }

    private fun fetchJoke(id :Int) {
        val fetchService = API.buildService(jokeApiService::class.java)

        val requestCall = fetchService.getJoke(id)

        requestCall.enqueue(object: Callback<jokeResponce>{
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

    fun fetchJokes() {

        val fetchService = API.buildService(jokeApiService::class.java)

        val requestCall = fetchService.getRendomJoke("Pun")

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

            //it's the called when it happens Network Error Or Establishing connection service
            override fun onFailure(call: Call<jokeResponce>, t: Throwable) {
                Log.d("ttttt", "onFailure: " + t.localizedMessage)
            }

        })

    }
}