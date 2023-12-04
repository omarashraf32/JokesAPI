package com.example.retrofitapi.repository.jokes

import com.example.retrofitapi.model.Joke
sealed class GetJokesResponseStates {
    class Success(val jokesList: List<Joke>) : GetJokesResponseStates()

    class Error(val errorMsg: String?) : GetJokesResponseStates()
}