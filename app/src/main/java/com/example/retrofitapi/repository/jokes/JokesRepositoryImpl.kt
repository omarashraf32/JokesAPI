package com.example.retrofitapi.repository.jokes

import androidx.lifecycle.MutableLiveData
import com.example.retrofitapi.model.GetjokesResopnse
import com.example.retrofitapi.network.ApiService
import com.example.retrofitapi.network.RetrofitNetworkBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Mahmoud Gamal on 04/12/2023.
 */
class JokesRepositoryImpl : JokesRepository {

    private val apiService = RetrofitNetworkBuilder.buildService(ApiService::class.java)
    override fun getJokes(): MutableLiveData<GetJokesResponseStates> {
        val jokesLiveData = MutableLiveData<GetJokesResponseStates>()
        apiService.getJokes().enqueue(object : Callback<GetjokesResopnse> {
            override fun onResponse(
                call: Call<GetjokesResopnse>,
                response: Response<GetjokesResopnse>
            ) {
                if (response.isSuccessful) {
                    jokesLiveData.postValue(
                        GetJokesResponseStates.Success(
                            response.body()?.jokes ?: emptyList()
                        )
                    )
                } else { // error state
                    jokesLiveData.postValue(
                        GetJokesResponseStates.Error(
                            response.errorBody()?.string()
                        )
                    )
                }
            }

            override fun onFailure(call: Call<GetjokesResopnse>, t: Throwable) {
                jokesLiveData.postValue(GetJokesResponseStates.Error(t.localizedMessage))
            }

        })
        return jokesLiveData
    }


}