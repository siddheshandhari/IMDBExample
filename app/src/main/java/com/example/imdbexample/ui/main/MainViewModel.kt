package com.example.imdbexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.imdbexample.data.IMDBRepository
import com.example.imdbexample.model.MostPopularData

class MainViewModel : ViewModel() {
    private val imdbRepository = IMDBRepository()
    val popularMoviesLiveData : LiveData<MostPopularData> = imdbRepository.popularMoviesMutableLiveData

    init {
        imdbRepository.getMostPopularMovies()
    }
}