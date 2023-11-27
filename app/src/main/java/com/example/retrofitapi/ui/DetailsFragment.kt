package com.example.retrofitapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapi.databinding.FragmentDetailsBinding
import com.example.retrofitapi.ui.viewmodel.JokeViewModel


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var jokesAdapter: jokesAdapter
    private lateinit var jokeViewModel: JokeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        setupViews()
        initViewModel()
        fetchData()
        setupLiveDataObservers()
        return binding.root

    }

    private fun setupViews() {
        initRecyclerView()
    }

    private fun initViewModel() {
        jokeViewModel = ViewModelProvider(this)[JokeViewModel::class.java]

    }

    private fun fetchData() = jokeViewModel.fetchJokes()

    private fun setupLiveDataObservers() {
        setupJokesLiveData()
        setupErrorLiveData()
    }

    private fun setupErrorLiveData() {
        jokeViewModel.errorMassegeLiveData.observe(viewLifecycleOwner, Observer { massege ->
            Toast.makeText(context, "Error...", Toast.LENGTH_SHORT).show()

        })
    }

    private fun setupJokesLiveData() {
        jokeViewModel.jokeLiveData.observe(viewLifecycleOwner, Observer { jokes ->
            jokesAdapter.submitList(jokes)

        })
    }

    private fun initRecyclerView() {
        jokesAdapter = jokesAdapter()
        binding.jokesRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = jokesAdapter
        }


    }
    }


