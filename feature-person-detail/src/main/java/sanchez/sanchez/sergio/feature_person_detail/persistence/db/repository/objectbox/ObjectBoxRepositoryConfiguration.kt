package sanchez.sanchez.sergio.feature_person_detail.persistence.db.repository.objectbox

/**
 * Object Box Repository Configuration
 * @param maxObjectsAllowed
 * @param objectsExpireInMillis
 */
data class ObjectBoxRepositoryConfiguration(
    val maxObjectsAllowed: Int,
    val objectsExpireInMillis: Int
)
