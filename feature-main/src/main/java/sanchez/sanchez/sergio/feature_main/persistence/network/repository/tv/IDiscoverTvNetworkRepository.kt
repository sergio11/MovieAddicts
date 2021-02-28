package sanchez.sanchez.sergio.feature_main.persistence.network.repository.tv

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.exception.NetworkException

/**
 * Discover Tv Network Repository
 */
interface IDiscoverTvNetworkRepository {

    /**
     * Fetch Discover Tv
     * @param page
     */
    @Throws(NetworkException::class)
    suspend fun fetchDiscoverTv(page: Long): PageData<Tv>
}