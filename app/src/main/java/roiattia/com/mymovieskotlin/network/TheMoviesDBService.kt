package roiattia.com.mymovieskotlin.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import roiattia.com.mymovieskotlin.model.Movie
import roiattia.com.mymovieskotlin.model.MovieResponse

interface TheMoviesDBService {

    /** MOVIES **/
    @GET("movie/{category}")
    fun getMoviesByCategory(@Path("category")category: String,
                            @Query("sort")sort: String): Call<MovieResponse>
}