package sanchez.sanchez.sergio.feature_main.persistence.network.model.movies

import com.squareup.moshi.Json

data class MovieDTO (
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "poster_path")
    val posterPath: String? = null,
    @field:Json(name = "adult")
    val adult: Boolean,
    @field:Json(name = "overview")
    val overview: String,
    @field:Json(name = "release_date")
    val releaseDate: String,
    @field:Json(name = "genre_ids")
    val genreIDS: List<Long>,
    @field:Json(name = "original_title")
    val originalTitle: String,
    @field:Json(name = "original_language")
    val originalLanguage: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @field:Json(name = "popularity")
    val popularity: Double,
    @field:Json(name = "vote_count")
    val voteCount: Long,
    @field:Json(name = "video")
    val video: Boolean,
    @field:Json(name = "vote_average")
    val voteAverage: Double
)
