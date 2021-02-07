package sanchez.sanchez.sergio.feature_tv_detail.persistence.api

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.repository.ITvNetworkRepository
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException

/**
 * Tv Repository Impl
 * @param tvRepoNetworkRepository
 */
class TvRepositoryImpl constructor(
        private val tvRepoNetworkRepository: ITvNetworkRepository
): ITvRepository {

    /**
     * Get Tv Detail
     * @param id
     */
    override suspend fun getTvDetail(id: Long): TvDetail = try {
        tvRepoNetworkRepository.getTvDetail(id)
    } catch (ex: Exception) {
        throw RepoErrorException(ex)
    }

}