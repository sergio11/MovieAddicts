package sanchez.sanchez.sergio.feature_main.persistence.db.model.movies

import io.objectbox.annotation.*
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.model.IObjectBoxEntity

@Entity
class MovieEntity(
    @Id var objectId: Long = 0,
    @Unique override val id: Long,
    @NameInDb("poster_path")
    val posterPath: String?,
    @NameInDb("adult")
    val adult: Boolean,
    @NameInDb("overview")
    val overview: String,
    @NameInDb("release_date")
    val releaseDate: String?,
    @NameInDb("original_title")
    val originalTitle: String,
    @NameInDb("original_language")
    val originalLanguage: String,
    @NameInDb("title")
    val title: String,
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
    override val savedAtInMillis: Long
): IObjectBoxEntity