package sanchez.sanchez.sergio.feature_main.persistence.db.model.tv

import io.objectbox.annotation.*
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.converter.StringListConverter
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.model.IObjectBoxEntity

/**
 * Tv Entity
 */
@Entity
class TvEntity (
    @Id var objectId: Long = 0,
    @Unique override val id: Long,
    @NameInDb("poster_path")
    val posterPath: String,
    @NameInDb("popularity")
    val popularity: Double,
    @NameInDb("backdrop_path")
    val backdropPath: String? = null,
    @NameInDb("vote_average")
    val voteAverage: Double,
    @NameInDb("overview")
    val overview: String,
    @NameInDb("first_air_date")
    val firstAirDate: String,
    @NameInDb("origin_country")
    @Convert(converter = StringListConverter::class, dbType = String::class)
    val originCountry: List<String>,
    @NameInDb("original_language")
    val originalLanguage: String,
    @NameInDb("vote_count")
    val voteCount: Long,
    @NameInDb("name")
    val name: String,
    @NameInDb("original_name")
    val originalName: String,
    @NameInDb("saved_at_in_millis")
    override val savedAtInMillis: Long
    ): IObjectBoxEntity