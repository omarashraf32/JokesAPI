package com.example.retrofitapi.ui.jokesList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitapi.repository.jokes.GetJokesResponseStates
import com.example.retrofitapi.repository.jokes.JokesRepository
import com.example.retrofitapi.repository.jokes.JokesRepositoryImpl

class JokesListViewModel : ViewModel() {


    var getJokesLiveData = MutableLiveData<GetJokesResponseStates>()

    private val jokesRepository: JokesRepository = JokesRepositoryImpl()

    fun fetchJokes() {
        getJokesLiveData = jokesRepository.getJokes()
    }
}