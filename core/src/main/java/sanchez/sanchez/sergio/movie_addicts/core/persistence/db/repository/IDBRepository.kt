package sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository

import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.exception.DBNoResultException

/**
 * DB Repository
 */
interface IDBRepository<T> {

    /**
     * Get Person Detail By Id
     * @param id
     */
    @Throws(DBNoResultException::class, DBErrorException::class)
    suspend fun getById(id: Long): T

    /**
     * Get All
     */
    @Throws(DBNoResultException::class, DBErrorException::class)
    suspend fun getAll(): List<T>

    /**
     * Save model
     * @param model
     */
    @Throws(DBErrorException::class)
    suspend fun save(model: T)

    /**
     * Save All
     */
    @Throws(DBErrorException::class)
    suspend fun save(modelList: List<T>)
}