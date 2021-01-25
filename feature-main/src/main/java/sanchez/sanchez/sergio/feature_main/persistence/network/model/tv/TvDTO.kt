package sanchez.sanchez.sergio.feature_main.persistence.network.model.tv

import com.squareup.moshi.Json

data class TvDTO(
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "poster_path")
    val posterPath: String,
    @field:Json(name = "popularity")
    val popularity: Double,
    @field:Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @field:Json(name = "vote_average")
    val voteAverage: Double,
    @field:Json(name = "overview")
    val overview: String,
    @field:Json(name = "first_air_date")
    val firstAirDate: String,
    @field:Json(name = "origin_country")
    val originCountry: List<String>,
    @field:Json(name = "genre_ids")
    val genreIDS: List<Long>,
    @field:Json(name = "original_language")
    val originalLanguage: String,
    @field:Json(name = "vote_count")
    val voteCount: Long,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "original_name")
    val originalName: String
)
