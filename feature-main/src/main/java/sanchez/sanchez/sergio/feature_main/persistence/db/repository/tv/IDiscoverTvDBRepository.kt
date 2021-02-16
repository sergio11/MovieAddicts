package sanchez.sanchez.sergio.feature_main.persistence.db.repository.tv

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.domain.model.Tv

/**
 * Discover Tv DB Repository
 */
interface IDiscoverTvDBRepository {

    /**
     * Get all tv
     */
    suspend fun getAll(): List<Tv>

    /**
     * Save All tv
     */
    suspend fun save(tvList: List<Tv>)
}