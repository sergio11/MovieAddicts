package sanchez.sanchez.sergio.feature_main.persistence.api.movies

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies.IDiscoverMoviesNetworkRepository
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException
import java.lang.Exception

/**
 * Discover Movies Repository
 * @param discoverMoviesNetworkRepository
 */
class DiscoverMoviesRepositoryImpl (
        private val discoverMoviesNetworkRepository: IDiscoverMoviesNetworkRepository
        ): IDiscoverMoviesRepository {

    /**
     * Get Discover Movies
     * @param page
     */
    override suspend fun getDiscoverMovies(page: Int): List<Movie> = try {
        discoverMoviesNetworkRepository.getDiscoverMovies(page)
    } catch (ex: Exception) {
        throw RepoErrorException(ex)
    }
}