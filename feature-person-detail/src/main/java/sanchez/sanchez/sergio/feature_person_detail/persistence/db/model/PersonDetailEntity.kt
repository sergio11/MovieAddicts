package sanchez.sanchez.sergio.feature_person_detail.persistence.db.model

import io.objectbox.annotation.*
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.model.IObjectBoxEntity
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.converter.StringListConverter

/**
 * Person Detail Entity
 */
@Entity
data class PersonDetailEntity(
    @Id var objectId: Long = 0,
    @Unique override val id: Long,
    @NameInDb("name")
    val name: String,
    @NameInDb("profile_path")
    val profilePath: String?,
    @NameInDb("adult")
    val adult: Boolean,
    @NameInDb("popularity")
    val popularity: Double,
    @NameInDb("birthday")
    val birthday: String?,
    @NameInDb("known_for_department")
    val knownForDepartment: String,
    @NameInDb("place_of_birth")
    val placeOfBirth: String?,
    @NameInDb("also_known_as")
    @Convert(converter = StringListConverter::class, dbType = String::class)
    val alsoKnownAs: List<String>?,
    @NameInDb("biography")
    val biography: String,
    @NameInDb("saved_at_in_millis")
    override val savedAtInMillis: Long
): IObjectBoxEntity
