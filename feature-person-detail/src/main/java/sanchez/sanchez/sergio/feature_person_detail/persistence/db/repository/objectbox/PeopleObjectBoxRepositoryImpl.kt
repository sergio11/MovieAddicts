package sanchez.sanchez.sergio.feature_person_detail.persistence.db.repository


import android.util.Log
import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.mapper.PersonDetailEntityMapper
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.PersonDetailEntity
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.PersonDetailEntity_
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.repository.objectbox.ObjectBoxRepositoryConfiguration
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException
import java.util.*

/**
 * People Object Box Repository Impl
 * @param peopleDAO
 * @param personDetailEntityMapper
 */
class PeopleObjectBoxRepositoryImpl(
    private val peopleDAO: Box<PersonDetailEntity>,
    private val personDetailEntityMapper: PersonDetailEntityMapper,
    private val objectBoxConfiguration: ObjectBoxRepositoryConfiguration
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

        if(Date().time - personDetailEntity.savedAtInMillis > objectBoxConfiguration.objectsExpireInMillis) {
            Log.d("PEOPLE_REP", "Person Object ${personDetailEntity.name} expired ")
            peopleDAO.remove(personDetailEntity).also {
                throw DBNoResultException()
            }
        }

        personDetailEntityMapper.entityToModel(personDetailEntity)
    }

    /**
     * Save Person Detail
     * @param personDetail
     */
    @Throws(DBErrorException::class)
    override suspend fun save(personDetail: PersonDetail): Unit = withContext(Dispatchers.IO) {
        if(peopleDAO.count() >= objectBoxConfiguration.maxObjectsAllowed)
            peopleDAO.query()
                .order(PersonDetailEntity_.savedAtInMillis)
                .build().findFirst()?.let {
                    peopleDAO.remove(it)
                }
        peopleDAO.put(personDetailEntityMapper.modelToEntity(personDetail))
    }
}