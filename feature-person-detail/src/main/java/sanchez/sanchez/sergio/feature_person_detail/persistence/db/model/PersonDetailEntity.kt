package sanchez.sanchez.sergio.feature_person_detail.persistence.db.model

import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.NameInDb
import sanchez.sanchez.sergio.test.core.persistence.db.converter.StringListConverter

/**
 * Person Detail Entity
 */
@Entity
data class PersonDetailEntity(
    @Id var id: Long,
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
    val biography: String
)
