package roiattia.com.mymovieskotlin.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import roiattia.com.mymovieskotlin.model.Movie
import roiattia.com.mymovieskotlin.model.MovieResponse
import roiattia.com.mymovieskotlin.network.RetrofitClient

class MoviesRepository{

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    fun getMovies(category: String, sort: String){
        val call = RetrofitClient.tmdbApi.getMoviesByCategory(category, sort)
        call.enqueue(object: Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                _movies.value = response.body()?.movies
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.i("MoviesRepository", "failure = ${t.message}")
            }
        })
    }
}