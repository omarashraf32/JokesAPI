package com.example.retrofitapi.ui.jokesList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitapi.model.GetjokesResopnce
import com.example.retrofitapi.model.Joke
import com.example.retrofitapi.network.RetrofitNetworkBuilder
import com.example.retrofitapi.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokesListViewModel : ViewModel() {

    val jokesLiveData: MutableLiveData<List<Joke>> = MutableLiveData()

    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()

    fun fetchJokes() {

        val fetchService = RetrofitNetworkBuilder.buildService(ApiService::class.java)

        val requestCall = fetchService.getJokes()

        requestCall.enqueue(object : Callback<GetjokesResopnce> {
            override fun onResponse(
                call: Call<GetjokesResopnce>,
                response: Response<GetjokesResopnce>
            ) {
                //your status code is in the range 200 to 299
                if (response.isSuccessful)
                    jokesLiveData.postValue(response.body()?.jokes ?: emptyList())
                else
                    errorMessageLiveData.postValue(
                        response.errorBody()?.string() ?: "something went wrong"
                    )
            }

            //it's the called when it happens Network Error Or Establishing connection service
            override fun onFailure(call: Call<GetjokesResopnce>, t: Throwable) {
                errorMessageLiveData.postValue(t.localizedMessage)
            }

        })

    }
}