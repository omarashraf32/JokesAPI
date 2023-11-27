package com.example.retrofitapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapi.R
import com.example.retrofitapi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val detailsFragment = DetailsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSetupView(fragment = DetailsFragment())

    }

    private fun initSetupView(fragment: DetailsFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_Conteriner,fragment)
            .addToBackStack(null)
            transaction.commit()


    }
}