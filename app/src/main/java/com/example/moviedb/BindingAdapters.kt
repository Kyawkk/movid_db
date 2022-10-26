package com.example.moviedb

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviedb.network.Movie
import com.example.moviedb.network.MovieApi
import com.example.moviedb.ui.Adapter
import kotlinx.coroutines.launch

@BindingAdapter("listData")
fun bind(recyclerView: RecyclerView, data: List<Movie>?){
    /*val adapter = recyclerView.adapter as MovieAdapter
    adapter.submitList(data)*/

    recyclerView.setHasFixedSize(true)
    recyclerView.adapter = data?.let { Adapter(it) }
}

@BindingAdapter("imgUrl")
fun bindImage(imageView: ImageView, url: String){
    url.let {
        val imgUri = url.toUri().buildUpon().scheme("https").build()
        imageView.load(imgUri){
            crossfade(true)
        }
    }
}