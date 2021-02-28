package sanchez.sanchez.sergio.movie_addicts.core.persistence.db.model

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