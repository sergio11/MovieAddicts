package sanchez.sanchez.sergio.feature_main.persistence.db.repository.people

import sanchez.sanchez.sergio.feature_main.domain.model.Person

/**
 * People DB Repository
 */
interface IPeopleDBRepository {

    /**
     * Get All people
     */
    suspend fun getAll(): List<Person>

    /**
     * Save All people
     */
    suspend fun save(people: List<Person>)
}