package sanchez.sanchez.sergio.feature_main.persistence.db.model.people

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.NameInDb
import io.objectbox.annotation.Unique
import sanchez.sanchez.sergio.test.core.persistence.db.model.IObjectBoxEntity

/**
 * Person Entity
 */
@Entity
class PersonEntity (
    @Id var objectId: Long = 0,
    @Unique override val id: Long,
    @NameInDb("name")
    val name: String,
    @NameInDb("popularity")
    val popularity: Double,
    @NameInDb("profile_path")
    val profilePath: String?,
    @NameInDb("adult")
    val adult: Boolean,
    @NameInDb("saved_at_in_millis")
    override val savedAtInMillis: Long
    ): IObjectBoxEntity