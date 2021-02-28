package sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.exception.NetworkException
import kotlin.jvm.Throws

/**
 * Discover Movies Repository
 */
interface IDiscoverMoviesNetworkRepository {

    /**
     * Get Discover Movies
     * @param page
     */
    @Throws(NetworkException::class)
    suspend fun getDiscoverMovies(page: Long): PageData<Movie>
}