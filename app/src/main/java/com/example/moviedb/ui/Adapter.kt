package com.example.moviedb.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.databinding.MovieItemBinding
import com.example.moviedb.network.Movie

class Adapter (data : List<Movie>): RecyclerView.Adapter<Adapter.MyViewHolder>() {
    val data = data
    class MyViewHolder(binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        fun bind(movie: Movie){
            binding.movie = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = data.get(position)
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}