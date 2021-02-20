package sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies

import androidx.annotation.WorkerThread
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.test.core.domain.model.PageData
import sanchez.sanchez.sergio.feature_main.persistence.network.mapper.MovieNetworkMapper
import sanchez.sanchez.sergio.feature_main.persistence.network.service.DiscoverMoviesService
import sanchez.sanchez.sergio.test.core.persistence.network.exception.NetworkNoResultException
import sanchez.sanchez.sergio.test.core.persistence.network.repository.SupportNetworkRepository

/**
 * Discover Movies Repository
 * @param moviesNetworkMapper
 * @param discoverMoviesService
 */
class DiscoverMoviesNetworkRepositoryImpl(
        private val moviesNetworkMapper: MovieNetworkMapper,
        private val discoverMoviesService: DiscoverMoviesService
): SupportNetworkRepository(), IDiscoverMoviesNetworkRepository {

    /**
     * Get Discover Movies
     * @param page
     */
    @WorkerThread
    override suspend fun getDiscoverMovies(page: Long): PageData<Movie> = safeNetworkCall {
        val result = discoverMoviesService.getDiscoverMovies(page)
        if(result.results.isEmpty())
            throw NetworkNoResultException("Not Movies found")
        PageData(
                page = result.page,
                data = moviesNetworkMapper.dtoToModel(result.results),
                isLast = result.page == result.totalPages
        )
    }
}