package sanchez.sanchez.sergio.feature_main.persistence.db.repository.people

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.PersonEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.people.PersonEntity

/**
 * People DB Repository
 * @param peopleDAO
 * @param personEntityMapper
 */
class PeopleDBRepositoryImpl(
    private val peopleDAO: Box<PersonEntity>,
    private val personEntityMapper: PersonEntityMapper
): IPeopleDBRepository {

    /**
     * Get All People
     */
    override suspend fun getAll(): List<Person> = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }

    /**
     * Save all people
     * @param people
     */
    override suspend fun save(people: List<Person>) {
        TODO("Not yet implemented")
    }
}