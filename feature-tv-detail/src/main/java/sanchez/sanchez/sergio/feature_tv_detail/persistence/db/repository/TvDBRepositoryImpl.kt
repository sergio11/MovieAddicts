package sanchez.sanchez.sergio.feature_tv_detail.persistence.db.repository

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper.TvDetailEntityMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model.TvDetailEntity
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model.TvDetailEntity_
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException

/**
 * Tv DB Repository Impl
 * @param tvDetailDAO
 * @param tvDetailEntityMapper
 */
class TvDBRepositoryImpl(
    private val tvDetailDAO: Box<TvDetailEntity>,
    private val tvDetailEntityMapper: TvDetailEntityMapper
): ITvDBRepository {

    /**
     * Get By Id
     * @param id
     * @return [TvDetail]
     */
    @Throws(DBNoResultException::class)
    override suspend fun getById(id: Long): TvDetail = withContext(Dispatchers.IO) {
        val tvDetailEntity = tvDetailDAO.query()
            .equal(TvDetailEntity_.id, id)
            .build().findUnique() ?: throw DBNoResultException()
        tvDetailEntityMapper.entityToModel(tvDetailEntity)
    }

    /**
     * Save Tv Detail
     * @param tvDetail
     */
    @Throws(DBErrorException::class)
    override suspend fun save(tvDetail: TvDetail): Unit = withContext(Dispatchers.IO) {
        tvDetailDAO.put(tvDetailEntityMapper.modelToEntity(tvDetail))
    }
}