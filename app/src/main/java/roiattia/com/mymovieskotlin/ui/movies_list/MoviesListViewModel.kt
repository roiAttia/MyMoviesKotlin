package roiattia.com.mymovieskotlin.ui.movies_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import roiattia.com.mymovieskotlin.model.Movie
import roiattia.com.mymovieskotlin.repositories.MoviesRepository

class MoviesListViewModel(application: Application) : AndroidViewModel(application) {

    private val moviesRepo = MoviesRepository()

    fun fetchMovies(category: String, sort: String) {
        moviesRepo.getMovies(category, sort)
    }

    fun getMoviesLiveData(): LiveData<List<Movie>>{
        return moviesRepo.movies
    }

}
