package sanchez.sanchez.sergio.feature_tv_detail.domain.model

import sanchez.sanchez.sergio.movie_addicts.core.utils.Identificable

/**
 * Tv Detail Definition
 */
data class TvDetail (
        override val id: Long,
        val name: String,
        val originalName: String,
        var keywords: List<Keyword>? = ArrayList(),
        var videos: List<Video>? = ArrayList(),
        var reviews: List<Review>? = ArrayList(),
        val posterPath: String?,
        val popularity: Double,
        val backdropPath: String?,
        val voteAverage: Double,
        val overview: String,
        val firstAirDate: String?,
        val originCountry: List<String>,
        val genres: List<String>,
        val originalLanguage: String,
        val voteCount: Long
): Identificable


/**
 * Keyword Definition
 */
data class Keyword(val id: Long, val name: String)

/**
 * Review Definition
 */
data class Review(
        val id: String,
        val author: String,
        val content: String,
        val url: String
)

/**
 * Video Definition
 */
data class Video(
        val id: String,
        val name: String,
        val site: String,
        val key: String,
        val size: Long,
        val type: String,
        val thumbnailPath: String
)