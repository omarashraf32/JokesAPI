package com.example.retrofitapi.repository.jokes

import androidx.lifecycle.MutableLiveData
import com.example.retrofitapi.model.Joke

/**
 * @author Mahmoud Gamal on 04/12/2023.
 */
interface JokesRepository {
    fun getJokes(): MutableLiveData<GetJokesResponseStates>
}