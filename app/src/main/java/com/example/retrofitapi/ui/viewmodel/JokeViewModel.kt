package com.example.retrofitapi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitapi.Model.GetjokesResopnce
import com.example.retrofitapi.Model.Joke
import com.example.retrofitapi.ui.API
import com.example.retrofitapi.ui.jokeApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeViewModel : ViewModel() {


    val jokeLiveData: MutableLiveData<List<Joke>> = MutableLiveData()

    val errorMassegeLiveData: MutableLiveData<String> = MutableLiveData()
    fun fetchJokes() {

        val fetchService = API.buildService(jokeApiService::class.java)

        val requestCall = fetchService.getjokes()

        requestCall.enqueue(object : Callback<GetjokesResopnce> {
            override fun onResponse(
                call: Call<GetjokesResopnce>,
                response: Response<GetjokesResopnce>
            ) {
                //yuor status code is in the range 200 to 299
                if (response.isSuccessful)
                   response.body()?.jokes?.let { jokes ->
                       jokeLiveData.postValue(jokes)
                   }
            }

            //it's the called when it happens Network Error Or Establishing connection service
            override fun onFailure(call: Call<GetjokesResopnce>, t: Throwable) {
                errorMassegeLiveData.postValue(t.localizedMessage)
            }

        })

    }
}