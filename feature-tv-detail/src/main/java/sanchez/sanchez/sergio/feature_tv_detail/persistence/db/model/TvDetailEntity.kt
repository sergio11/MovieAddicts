package sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model

import io.objectbox.annotation.*
import io.objectbox.relation.ToMany
import sanchez.sanchez.sergio.test.core.persistence.db.converter.StringListConverter
import sanchez.sanchez.sergio.test.core.persistence.db.model.IObjectBoxEntity

/**
 * Tv Detail Entity Definition
 */
@Entity
data class TvDetailEntity (
        @Id var objectId: Long = 0,
        @Unique override val id: Long,
        @NameInDb("name")
        val name: String,
        @NameInDb("original_name")
        val originalName: String,
        @NameInDb("poster_path")
        val posterPath: String?,
        @NameInDb("popularity")
        val popularity: Double,
        @NameInDb("backdrop_path")
        val backdropPath: String?,
        @NameInDb("vote_average")
        val voteAverage: Double,
        @NameInDb("overview")
        val overview: String,
        @NameInDb("first_air_date")
        val firstAirDate: String?,
        @NameInDb("origin_country")
        @Convert(converter = StringListConverter::class, dbType = String::class)
        val originCountry: List<String>,
        @NameInDb("genres")
        @Convert(converter = StringListConverter::class, dbType = String::class)
        val genres: List<String>,
        @NameInDb("original_language")
        val originalLanguage: String,
        @NameInDb("vote_count")
        val voteCount: Long,
        @NameInDb("saved_at_in_millis")
        override val savedAtInMillis: Long
): IObjectBoxEntity {
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
data class KeywordEntity(
        @Id var objectId: Long = 0,
        val id: Long,
        @NameInDb("name")
        val name: String)

/**
 * Review Entity Definition
 */
@Entity
data class ReviewEntity(
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
data class VideoEntity(
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