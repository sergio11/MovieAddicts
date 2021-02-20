package sanchez.sanchez.sergio.feature_main.persistence.api.tv

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.tv.IDiscoverTvNetworkRepository
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.IDBRepository
import java.lang.Exception

/**
 * Discover Tv Repository Impl
 * @param discoverTvNetworkRepository
 * @param discoverTvDBRepository
 */
class DiscoverTvRepositoryImpl(
    private val discoverTvNetworkRepository: IDiscoverTvNetworkRepository,
    private val discoverTvDBRepository: IDBRepository<Tv>
): IDiscoverTvRepository {

    /**
     * Fetch Discover Tv
     * @param page
     */
    override suspend fun fetchDiscoverTv(page: Int): List<Tv> = try {
        discoverTvNetworkRepository.fetchDiscoverTv(page).also {
            discoverTvDBRepository.save(it)
        }
    } catch (ex: Exception) {
        try {
            discoverTvDBRepository.getAll()
        } catch (ex: Exception) {
            throw RepoErrorException(ex)
        }
    }
}