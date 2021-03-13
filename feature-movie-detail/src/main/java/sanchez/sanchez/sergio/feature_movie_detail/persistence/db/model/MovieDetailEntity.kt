package sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model

import io.objectbox.annotation.*
import io.objectbox.relation.ToMany
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.converter.StringListConverter
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.model.IObjectBoxEntity

/**
 * Movie Detail Entity
 */
@Entity
data class MovieDetailEntity(
    @Id var objectId: Long = 0,
    @Unique override val id: Long,
    @NameInDb("original_title")
    val originalTitle: String,
    @NameInDb("original_language")
    val originalLanguage: String,
    @NameInDb("title")
    val title: String,
    @NameInDb("poster_path")
    val posterPath: String?,
    @NameInDb("adult")
    val adult: Boolean,
    @NameInDb("overview")
    val overview: String,
    @NameInDb("release_date")
    val releaseDate: String?,
    @NameInDb("genres")
    @Convert(converter = StringListConverter::class, dbType = String::class)
    val genres: List<String>,
    @NameInDb("backdrop_path")
    val backdropPath: String?,
    @NameInDb("popularity")
    val popularity: Double,
    @NameInDb("vote_count")
    val voteCount: Long,
    @NameInDb("video")
    val video: Boolean,
    @NameInDb("vote_average")
    val voteAverage: Double,
    @NameInDb("saved_at_in_millis")
    override val savedAtInMillis: Long,
    @NameInDb("is_favorite")
    val isFavorite: Boolean,
): IObjectBoxEntity{

    @NameInDb("keywords")
    lateinit var keywords: ToMany<KeywordEntity>
    @NameInDb("videos")
    lateinit var videos: ToMany<VideoEntity>
    @NameInDb("reviews")
    lateinit var reviews: ToMany<ReviewEntity>

}

/**
 * Keyword Entity Definition
 */
@Entity
data class KeywordEntity (
    @Id var objectId: Long = 0,
    val id: Long,
    @NameInDb("name")
    val name: String)

/**
 * Review Entity Definition
 */
@Entity
data class ReviewEntity (
    @Id var objectId: Long = 0,
    val id: String,
    @NameInDb("author")
    val author: String,
    @NameInDb("content")
    val content: String,
    @NameInDb("url")
    val url: String
)

/**
 * Video Entity Definition
 */
@Entity
data class VideoEntity (
    @Id var objectId: Long = 0,
    val id: String,
    @NameInDb("name")
    val name: String,
    @NameInDb("site")
    val site: String,
    @NameInDb("key")
    val key: String,
    @NameInDb("size")
    val size: Long,
    @NameInDb("type")
    val type: String,
    @NameInDb("thumbnail_path")
    val thumbnailPath: String
)
