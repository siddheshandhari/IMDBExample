package com.example.imdbexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbexample.R
import com.example.imdbexample.databinding.MovieAdapterBinding
import com.example.imdbexample.model.MostPopularDataDetail


class MovieAdapter(
    private val movies: List<MostPopularDataDetail>
) : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MovieAdapterBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.movie_adapter, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        return holder.bind(movies[position])
    }
}

class MoviesViewHolder(private val binding: MovieAdapterBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MostPopularDataDetail) {
        binding.setVariable(BR.movieDetails, movie)
        binding.executePendingBindings()
    }

}
