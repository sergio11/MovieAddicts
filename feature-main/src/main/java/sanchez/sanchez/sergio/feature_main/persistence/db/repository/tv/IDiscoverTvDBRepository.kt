package sanchez.sanchez.sergio.feature_main.persistence.db.repository.tv

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException

/**
 * Discover Tv DB Repository
 */
interface IDiscoverTvDBRepository {

    /**
     * Get all tv
     */
    @Throws(DBNoResultException::class, DBErrorException::class)
    suspend fun getAll(): List<Tv>

    /**
     * Save All tv
     * @param tvList
     */
    @Throws(DBErrorException::class)
    suspend fun save(tvList: List<Tv>)
}