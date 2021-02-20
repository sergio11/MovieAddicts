package sanchez.sanchez.sergio.feature_main.persistence.api.tv

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.tv.IDiscoverTvNetworkRepository
import sanchez.sanchez.sergio.test.core.domain.model.PageData
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
    override suspend fun fetchDiscoverTv(page: Long): PageData<Tv> = try {
        discoverTvNetworkRepository.fetchDiscoverTv(page).also {
            discoverTvDBRepository.save(it.data)
        }
    } catch (ex: Exception) {
        try {
            PageData(page = 1, data = discoverTvDBRepository.getAll(), isLast = true)
        } catch (ex: Exception) {
            throw RepoErrorException(ex)
        }
    }
}