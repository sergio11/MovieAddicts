package sanchez.sanchez.sergio.test.core.persistence.db.model

interface IObjectBoxEntity {

    /**
     * Get Id
     */
    val id: Long

    /**
     * Get Saved At In Millis
     */
    val savedAtInMillis: Long
}