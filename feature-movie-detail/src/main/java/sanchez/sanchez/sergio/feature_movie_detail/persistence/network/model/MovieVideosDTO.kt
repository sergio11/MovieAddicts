package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model

import com.squareup.moshi.Json

data class MovieVideosDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "results")
        val movies: List<MovieDTO>
)

data class MovieDTO (
        @field:Json(name = "id")
        val id: String,
        @field:Json(name = "iso_639_1")
        val iso639_1: String,
        @field:Json(name = "iso_3166_1")
        val iso3166_1: String,
        @field:Json(name = "key")
        val key: String,
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "site")
        val site: String,
        @field:Json(name = "size")
        val size: Long,
        @field:Json(name = "type")
        val type: String
)
