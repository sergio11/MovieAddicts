package sanchez.sanchez.sergio.feature_main.persistence.network.repository.tv

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.network.mapper.TvNetworkMapper
import sanchez.sanchez.sergio.feature_main.persistence.network.service.DiscoverTvService
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.exception.NetworkNoResultException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.repository.SupportNetworkRepository

/**
 * Discover Tv Network Repository Impl
 * @param discoverDiscoverTvService
 * @param tvNetworkMapper
 */
class DiscoverTvNetworkRepositoryImpl(
    private val discoverDiscoverTvService: DiscoverTvService,
    private val tvNetworkMapper: TvNetworkMapper
): SupportNetworkRepository(), IDiscoverTvNetworkRepository {

    /**
     * Fetch Discover Tv
     * @param page
     */
    override suspend fun fetchDiscoverTv(page: Long): PageData<Tv> = safeNetworkCall {
        val result = discoverDiscoverTvService.fetchDiscoverTv(page)
        if(result.results.isEmpty())
            throw NetworkNoResultException("Not Discover Tv found")
        PageData(
                page = result.page,
                data = tvNetworkMapper.dtoToModel(result.results),
                isLast = result.page == result.totalPages
        )
    }
}