package com.example.retrofitapi.ui.jokesList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapi.model.Joke
import com.example.retrofitapi.R


class jokesAdapter : ListAdapter<Joke, jokesAdapter.UserViweHolder>(UserDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViweHolder {
        return UserViweHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_joke_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViweHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class UserViweHolder(view: View) : RecyclerView.ViewHolder(view) {
        var idJoke: TextView = view.findViewById(R.id.txt_jokeId)
        var titelJoke: TextView = view.findViewById(R.id.txt_joke_titel)

        fun bindData(joke: Joke) {
            idJoke.text = joke.id.toString()
            titelJoke.text = joke.category
        }
    }
}

class UserDiffUtil : DiffUtil.ItemCallback<Joke>() {
    override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}
