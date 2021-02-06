package sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model

import com.squareup.moshi.Json


data class TvDetailDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "backdrop_path")
        val backdropPath: String,
        @field:Json(name = "created_by")
        val createdBy: List<CreatedByDTO>,
        @field:Json(name = "episode_run_time")
        val episodeRunTime: List<Long>,
        @field:Json(name = "first_air_date")
        val firstAirDate: String,
        @field:Json(name = "genres")
        val genres: List<GenreDTO>,
        @field:Json(name = "homepage")
        val homepage: String,
        @field:Json(name = "in_production")
        val inProduction: Boolean,
        @field:Json(name = "languages")
        val languages: List<String>,
        @field:Json(name = "last_air_date")
        val lastAirDate: String,
        @field:Json(name = "last_episode_to_air")
        val lastEpisodeToAir: LastEpisodeToAirDTO,
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "next_episode_to_air")
        val nextEpisodeToAir: Any? = null,
        @field:Json(name = "networks")
        val networks: List<NetworkDTO>,
        @field:Json(name = "number_of_episodes")
        val numberOfEpisodes: Long,
        @field:Json(name = "number_of_seasons")
        val numberOfSeasons: Long,
        @field:Json(name = "origin_country")
        val originCountry: List<String>,
        @field:Json(name = "original_language")
        val originalLanguage: String,
        @field:Json(name = "original_name")
        val originalName: String,
        @field:Json(name = "overview")
        val overview: String,
        @field:Json(name = "popularity")
        val popularity: Double,
        @field:Json(name = "poster_path")
        val posterPath: String,
        @field:Json(name = "production_companies")
        val productionCompanies: List<NetworkDTO>,
        @field:Json(name = "production_countries")
        val productionCountries: List<ProductionCountryDTO>,
        @field:Json(name = "seasons")
        val seasons: List<SeasonDTO>,
        @field:Json(name = "spoken_languages")
        val spokenLanguages: List<SpokenLanguageDTO>,
        @field:Json(name = "status")
        val status: String,
        @field:Json(name = "tagline")
        val tagline: String,
        @field:Json(name = "type")
        val type: String,
        @field:Json(name = "vote_average")
        val voteAverage: Double,
        @field:Json(name = "vote_count")
        val voteCount: Long
)

data class CreatedByDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "credit_id")
        val creditID: String,
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "gender")
        val gender: Long,
        @field:Json(name = "profile_path")
        val profilePath: String
)

data class GenreDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "name")
        val name: String
)


data class LastEpisodeToAirDTO (
        @field:Json(name = "air_date")
        val airDate: String,
        @field:Json(name = "episode_number")
        val episodeNumber: Long,
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "overview")
        val overview: String,
        @field:Json(name = "production_code")
        val productionCode: String,
        @field:Json(name = "season_number")
        val seasonNumber: Long,
        @field:Json(name = "still_path")
        val stillPath: String,
        @field:Json(name = "vote_average")
        val voteAverage: Double,
        @field:Json(name = "vote_count")
        val voteCount: Long
)

data class NetworkDTO (
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "logo_path")
        val logoPath: String? = null,
        @field:Json(name = "origin_country")
        val originCountry: String
)

data class ProductionCountryDTO (
        @field:Json(name = "iso_3166_1")
        val iso3166_1: String,
        @field:Json(name = "name")
        val name: String
)

data class SeasonDTO (
        @field:Json(name = "air_date")
        val airDate: String,
        @field:Json(name = "episode_count")
        val episodeCount: Long,
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "overview")
        val overview: String,
        @field:Json(name = "poster_path")
        val posterPath: String,
        @field:Json(name = "season_number")
        val seasonNumber: Long
)


data class SpokenLanguageDTO (
        @field:Json(name = "english_name")
        val englishName: String,
        @field:Json(name = "iso_639_1")
        val iso639_1: String,
        @field:Json(name = "name")
        val name: String
)
