package sanchez.sanchez.sergio.feature_main.persistence.api.movies

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.test.core.persistence.api.RepoNoResultException
import kotlin.jvm.Throws

/**
 * Discover Movies Repository
 */
interface IDiscoverMoviesRepository {

    /**
     * Get Discover Movies
     * @param page
     */
    @Throws(RepoNoResultException::class, RepoErrorException::class)
    suspend fun getDiscoverMovies(page: Int): List<Movie>
}