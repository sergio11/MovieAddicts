package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model

import com.squareup.moshi.Json

data class MovieDetailDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "adult")
        val adult: Boolean,
        @field:Json(name = "backdrop_path")
        val backdropPath: String,
        @field:Json(name = "belongs_to_collection")
        val belongsToCollection: Any? = null,
        @field:Json(name = "budget")
        val budget: Long,
        @field:Json(name = "genres")
        val genres: List<GenreDTO>,
        @field:Json(name = "homepage")
        val homepage: String,
        @field:Json(name = "imdb_id")
        val imdbID: String,
        @field:Json(name = "original_language")
        val originalLanguage: String,
        @field:Json(name = "original_title")
        val originalTitle: String,
        @field:Json(name = "overview")
        val overview: String,
        @field:Json(name = "popularity")
        val popularity: Double,
        @field:Json(name = "poster_path")
        val posterPath: Any? = null,
        @field:Json(name = "production_companies")
        val productionCompanies: List<ProductionCompanyDTO>,
        @field:Json(name = "production_countries")
        val productionCountries: List<ProductionCountryDTO>,
        @field:Json(name = "release_date")
        val releaseDate: String,
        @field:Json(name = "revenue")
        val revenue: Long,
        @field:Json(name = "runtime")
        val runtime: Long,
        @field:Json(name = "spoken_languages")
        val spokenLanguages: List<SpokenLanguageDTO>,
        @field:Json(name = "status")
        val status: String,
        @field:Json(name = "tagline")
        val tagline: String,
        @field:Json(name = "title")
        val title: String,
        @field:Json(name = "video")
        val video: Boolean,
        @field:Json(name = "vote_average")
        val voteAverage: Double,
        @field:Json(name = "vote_count")
        val voteCount: Long
)

data class GenreDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "name")
        val name: String
)

data class ProductionCompanyDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "logo_path")
        val logoPath: String? = null,
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "origin_country")
        val originCountry: String? = null
)

data class ProductionCountryDTO (
        @field:Json(name = "iso_3166_1")
        val iso3166_1: String,
        @field:Json(name = "name")
        val name: String
)

data class SpokenLanguageDTO (
        @field:Json(name = "iso_639_1")
        val iso639_1: String,
        @field:Json(name = "name")
        val name: String
)