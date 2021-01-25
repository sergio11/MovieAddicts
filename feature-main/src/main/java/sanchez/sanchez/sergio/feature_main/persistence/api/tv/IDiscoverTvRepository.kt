package sanchez.sanchez.sergio.feature_main.persistence.api.tv

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.test.core.persistence.api.RepoNoResultException

/**
 * Discover Tv Repository
 */
interface IDiscoverTvRepository {

    /**
     * Fetch Discover Tv
     * @param page
     */
    @Throws(RepoNoResultException::class, RepoErrorException::class)
    suspend fun fetchDiscoverTv(page: Int): List<Tv>
}