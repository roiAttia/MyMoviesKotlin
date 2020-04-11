package roiattia.com.mymovieskotlin.model

import com.squareup.moshi.Json

class MovieResponse (
        @field:Json(name = "results") val movies: List<Movie>
)
