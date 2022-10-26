package com.example.moviedb.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.network.Movie
import com.example.moviedb.network.MovieApi
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    enum class MovieApiStatus {LOADING,ERROR,DONE}

    private val _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus> = _status

    private val _movies = MutableLiveData<List<Movie>>()
    val amphibians : MutableLiveData<List<Movie>> = _movies

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    fun onMovieClicked(movie: Movie){
        _movie.value = movie
    }

    init {
        getMovieList()
    }


    private fun getMovieList(){
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            println("data: Loading...")
            try {
                _movies.value = MovieApi.retrofitService.getMovie()
                _status.value = MovieApiStatus.DONE
                println("data: Finished")
            }catch (e: java.lang.Exception){
                _movies.value = listOf()
                _status.value = MovieApiStatus.ERROR
                println("data: error ${e.toString()}")
            }
        }
    }

}