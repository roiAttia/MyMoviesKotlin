package roiattia.com.mymovieskotlin.model

import com.squareup.moshi.Json

data class Movie (
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "original_title") val originalTitle: String,
    @field:Json(name = "poster_path") val posterPath: String
)