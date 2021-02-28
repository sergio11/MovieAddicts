package sanchez.sanchez.sergio.feature_tv_detail.persistence.api

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoNoResultException
import kotlin.jvm.Throws

/**
 * Tv Repository
 */
interface ITvRepository {

    /**
     * Get Tv Detail
     * @param id
     * @return [TvDetail]
     */
    @Throws(RepoNoResultException::class, RepoErrorException::class)
    suspend fun getTvDetail(id: Long): TvDetail
}