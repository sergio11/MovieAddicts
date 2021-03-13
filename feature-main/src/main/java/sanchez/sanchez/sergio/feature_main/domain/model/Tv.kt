package sanchez.sanchez.sergio.feature_main.domain.model

import sanchez.sanchez.sergio.movie_addicts.core.utils.Identificable

data class Tv(
    override val id: Long,
    val posterPath: String,
    val popularity: Double,
    val backdropPath: String? = null,
    val voteAverage: Double,
    val overview: String,
    val firstAirDate: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val voteCount: Long,
    val name: String,
    val originalName: String
): Identificable
