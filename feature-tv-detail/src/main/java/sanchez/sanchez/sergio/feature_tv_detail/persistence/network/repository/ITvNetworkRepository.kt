package sanchez.sanchez.sergio.feature_tv_detail.persistence.network.repository

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.exception.NetworkException
import kotlin.jvm.Throws

/**
 * Tv Network Repository
 */
interface ITvNetworkRepository {

    /**
     * Get Tv Detail
     * @param id
     */
    @Throws(NetworkException::class)
    suspend fun getTvDetail(id: Long): TvDetail
}