package sanchez.sanchez.sergio.feature_main.persistence.network.repository

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.test.core.persistence.network.exception.NetworkException

/**
 * Discover Movies Repository
 */
interface IDiscoverMoviesNetworkRepository {

    /**
     * Get Discover Movies
     * @param page
     */
    @Throws(NetworkException::class)
    suspend fun getDiscoverMovies(page: Int): List<Movie>
}