package sanchez.sanchez.sergio.feature_main.persistence.db.repository.people

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException

/**
 * People DB Repository
 */
interface IPeopleDBRepository {

    /**
     * Get All people
     */
    @Throws(DBNoResultException::class, DBErrorException::class)
    suspend fun getAll(): List<Person>

    /**
     * Save All people
     */
    @Throws(DBErrorException::class)
    suspend fun save(people: List<Person>)
}