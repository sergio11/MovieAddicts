package sanchez.sanchez.sergio.feature_movie_detail.domain.model

data class MovieDetail (
        val id: Long,
        val originalTitle: String,
        val originalLanguage: String,
        val title: String,
        var keywords: List<Keyword>? = ArrayList(),
        var videos: List<Video>? = ArrayList(),
        var reviews: List<Review>? = ArrayList(),
        val posterPath: String?,
        val adult: Boolean,
        val overview: String,
        val releaseDate: String?,
        val genres: List<String>,
        val backdropPath: String?,
        val popularity: Double,
        val voteCount: Long,
        val video: Boolean,
        val voteAverage: Double
)

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