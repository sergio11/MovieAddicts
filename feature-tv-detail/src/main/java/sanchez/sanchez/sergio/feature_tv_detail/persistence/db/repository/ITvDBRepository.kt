package sanchez.sanchez.sergio.feature_tv_detail.persistence.db.repository

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail

/**
 * Tv DB Repository
 */
interface ITvDBRepository {

    /**
     * Get Tv Detail By Id
     * @param id
     */
    suspend fun getById(id: Long): TvDetail

    /**
     * Save Tv Detail
     * @param tvDetail
     */
    suspend fun save(tvDetail: TvDetail)
}