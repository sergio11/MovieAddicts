package sanchez.sanchez.sergio.test.core.persistence.db.repository.objectbox

import io.objectbox.Property
import sanchez.sanchez.sergio.test.core.persistence.db.model.IObjectBoxEntity

/**
 * Object Box Repository Configuration
 * @param maxObjectsAllowed
 * @param objectsExpireInMillis
 * @param objectIdProperty
 * @param savedAtInMillisProperty
 */
data class ObjectBoxRepositoryConfiguration<E: IObjectBoxEntity>(
    val maxObjectsAllowed: Int,
    val objectsExpireInMillis: Int,
    val objectIdProperty: Property<E>,
    val savedAtInMillisProperty: Property<E>
)
