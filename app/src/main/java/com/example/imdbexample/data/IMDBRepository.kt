package com.example.imdbexample.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.imdbexample.adapter.MovieAdapter
import com.example.imdbexample.model.MostPopularData
import com.example.imdbexample.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IMDBRepository {
    private val TAG = "IMDBRepository"
    val popularMoviesMutableLiveData = MutableLiveData<MostPopularData>()

    fun getMostPopularMovies() {
        val call = ServiceBuilder.create().listMostPopularMovies()
        call.enqueue(object : Callback<MostPopularData> {
            override fun onResponse(
                call: Call<MostPopularData>,
                response: Response<MostPopularData>
            ) {
                if(response.isSuccessful){
                    Log.d(TAG, "onResponse: "+ response.body())
                    val mostPopularData = response.body()
                    if (mostPopularData!= null)
                        popularMoviesMutableLiveData.value = mostPopularData!!
                } else
                    Log.d(TAG, "onResponse: "+ response.errorBody())
            }

            override fun onFailure(call: Call<MostPopularData>, t: Throwable) {
                Log.d(TAG, "onFailure: "+t.message)
            }

        })
    }
}