package com.example.retrofitapi.ui.jokesList

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
import com.example.retrofitapi.model.Joke
import com.example.retrofitapi.repository.jokes.GetJokesResponseStates
import com.example.retrofitapi.ui.jokesList.viewmodel.JokesListViewModel


class JokesListFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var jokesAdapter: jokesAdapter
    private lateinit var viewModel: JokesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setupViews()
        setupLiveDataObservers()
        fetchData()
    }

    private fun setupViews() {
        initRecyclerView()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[JokesListViewModel::class.java]
    }

    private fun fetchData() = viewModel.fetchJokes()

    private fun setupLiveDataObservers() {
        viewModel.getJokesLiveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is GetJokesResponseStates.Success -> onGettingJokesSuccess(state.jokesList)
                is GetJokesResponseStates.Error -> onGettingJokesError(state.errorMsg)
            }
        }
    }

    private fun onGettingJokesError(errorMsg: String?) {
        Toast.makeText(context, "Error...", Toast.LENGTH_SHORT).show()
    }

    private fun onGettingJokesSuccess(jokes: List<Joke>) {
        if (jokes.isEmpty())
            showEmptyJokesView()
        else
            jokesAdapter.submitList(jokes)
    }


    private fun showEmptyJokesView() {

    }

    private fun initRecyclerView() {
        jokesAdapter = jokesAdapter()
        binding.jokesRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = jokesAdapter
        }

    }
}


