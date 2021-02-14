package sanchez.sanchez.sergio.feature_person_detail.persistence.db.repository

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.mapper.PersonDetailEntityMapper
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.PersonDetailEntity
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.PersonDetailEntity_
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException

/**
 * People DB Repository Impl
 * @param peopleDAO
 * @param personDetailEntityMapper
 */
class PeopleDBRepositoryImpl(
    private val peopleDAO: Box<PersonDetailEntity>,
    private val personDetailEntityMapper: PersonDetailEntityMapper
): IPeopleDBRepository {

    /**
     * Get Person Detail By Id
     * @param id
     * @return [PersonDetail]
     */
    @Throws(DBNoResultException::class)
    override suspend fun getById(id: Long): PersonDetail = withContext(Dispatchers.IO) {

        val personDetailEntity = peopleDAO.query()
            .equal(PersonDetailEntity_.id, id)
            .build().findUnique() ?: throw DBNoResultException()

        personDetailEntityMapper.entityToModel(personDetailEntity)
    }

    /**
     * Save Person Detail
     * @param personDetail
     */
    @Throws(DBErrorException::class)
    override suspend fun save(personDetail: PersonDetail): Unit = withContext(Dispatchers.IO) {
        peopleDAO.put(personDetailEntityMapper.modelToEntity(personDetail))
    }

}