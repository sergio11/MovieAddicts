package sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.objectbox

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.model.IObjectBoxEntity
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.exception.DBError
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.exception.DBNoResultException
import sanchez.sanchez.sergio.movie_addicts.core.utils.Identificable
import java.lang.Exception
import java.util.*

/**
 * Support Object Box Repository Impl
 * @param objectBoxDao
 * @param entityMapper
 *
 */
class SupportObjectBoxRepositoryImpl<T: Identificable, E: IObjectBoxEntity>(
        private val objectBoxDao: Box<E>,
        private val entityMapper: IEntityToModelMapper<E, T>,
        private val objectBoxConfiguration: ObjectBoxRepositoryConfiguration<E>
): IDBRepository<T> {

    /**
     * Get Object by id
     * @param id
     */
    override suspend fun getById(id: Long) = withContext(Dispatchers.IO) {
        try {
            val objectEntity = objectBoxDao.query()
                    .equal(objectBoxConfiguration.objectIdProperty, id)
                    .build().findUnique() ?: throw DBNoResultException()

            if(Date().time - objectEntity.savedAtInMillis > objectBoxConfiguration.objectsExpireInMillis) {
                objectBoxDao.remove(objectEntity).also {
                    throw DBNoResultException()
                }
            }
            entityMapper.entityToModel(objectEntity)
        } catch (ex: DBError) {
            throw ex
        } catch (ex: Exception) {
            throw DBErrorException("Error when get object from box", ex)
        }
    }

    /**
     * Get All Objects from box
     */
    override suspend fun getAll(): List<T> = withContext(Dispatchers.IO) {
        if(objectBoxDao.isEmpty)
            throw DBNoResultException("No objects were found")
        try {
            val objectEntityList = objectBoxDao.all
            val ite = objectEntityList.iterator()
            while (ite.hasNext())
                ite.next().let { objectEntity ->
                    if(Date().time - objectEntity.savedAtInMillis > objectBoxConfiguration.objectsExpireInMillis) {
                        objectBoxDao.remove(objectEntity).also {
                            ite.remove()
                        }
                    }
                }
            if(objectEntityList.isEmpty())
                throw DBNoResultException("No objects were found")
            entityMapper.entityToModel(objectEntityList)
        } catch (ex: DBError) {
            throw ex
        } catch (ex: Exception) {
            throw DBErrorException("Error getting people from box", ex)
        }
    }

    /**
     * Save model into the box
     * @param model
     */
    override suspend fun save(model: T): Unit = withContext(Dispatchers.IO) {
        try {
            if(objectBoxDao.count() >= objectBoxConfiguration.maxObjectsAllowed)
                objectBoxDao.query()
                        .order(objectBoxConfiguration.savedAtInMillisProperty)
                        .build().findFirst()?.let {
                            objectBoxDao.remove(it)
                        }

            objectBoxDao.query()
                .equal(objectBoxConfiguration.objectIdProperty, model.id)
                .build().findUnique()?.let {
                    objectBoxDao.remove(it)
                }

            objectBoxDao.put(entityMapper.modelToEntity(model))
        } catch (ex: Exception) {
            throw DBErrorException("Exception when try to save model into the box", ex)
        }
    }

    /**
     * Save model list into the box
     * @param modelList
     */
    override suspend fun save(modelList: List<T>): Unit = withContext(Dispatchers.IO)  {
        try {
            if(modelList.isEmpty())
                throw IllegalArgumentException("Model list can not be empty")
            objectBoxDao.run {
                if(count() >= objectBoxConfiguration.maxObjectsAllowed)
                    query().order(objectBoxConfiguration.savedAtInMillisProperty)
                            .build().find(0, modelList.size.toLong()).let {
                                objectBoxDao.remove(it)
                            }

                objectBoxDao.query()
                    .`in`(objectBoxConfiguration.objectIdProperty, modelList.map { it.id }.toLongArray())
                    .build().findUnique()?.let {
                        objectBoxDao.remove(it)
                    }

                put(entityMapper.modelToEntity(modelList))
            }
        } catch (ex: Exception) {
            throw DBErrorException("Error getting people from box", ex)
        }
    }
}