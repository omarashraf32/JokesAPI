package com.example.retrofitapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapi.R
import com.example.retrofitapi.databinding.ActivityMainBinding
import com.example.retrofitapi.ui.jokesList.JokesListFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val jokesListFragment = JokesListFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addJokesListFragment(fragment = JokesListFragment())

    }

    private fun addJokesListFragment(fragment: JokesListFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_Conteriner, fragment)
        transaction.commit()
    }
}