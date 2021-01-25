package sanchez.sanchez.sergio.feature_main.persistence.api.tv

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.tv.IDiscoverTvNetworkRepository
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException
import java.lang.Exception

class DiscoverTvRepositoryImpl(
    private val discoverTvNetworkRepository: IDiscoverTvNetworkRepository
): IDiscoverTvRepository {

    /**
     * Fetch Discover Tv
     * @param page
     */
    override suspend fun fetchDiscoverTv(page: Int): List<Tv> = try {
        discoverTvNetworkRepository.fetchDiscoverTv(page)
    } catch (ex: Exception) {
        throw RepoErrorException(ex)
    }
}