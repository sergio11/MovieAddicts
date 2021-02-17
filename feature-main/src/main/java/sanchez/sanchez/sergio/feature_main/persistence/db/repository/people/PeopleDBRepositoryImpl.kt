package sanchez.sanchez.sergio.feature_main.persistence.db.repository.people

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.PersonEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.people.PersonEntity
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException

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
        if(peopleDAO.isEmpty)
            throw DBNoResultException("No People was found")
        try {
            personEntityMapper.entityToModel(peopleDAO.all)
        } catch (ex: Exception) {
            throw DBErrorException("Error getting people from box", ex)
        }
    }

    /**
     * Save all people
     * @param people
     */
    override suspend fun save(people: List<Person>) {
        try {
            peopleDAO.run {
                removeAll()
                put(personEntityMapper.modelToEntity(people))
            }
        } catch (ex: Exception) {
            throw DBErrorException("Error getting people from box", ex)
        }
    }
}