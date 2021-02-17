package sanchez.sanchez.sergio.feature_main.persistence.db.repository.movies

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException

/**
 * Discover Movies DB Repository
 */
interface IDiscoverMoviesDBRepository {

    /**
     * Get All Movies
     */
    @Throws(DBNoResultException::class, DBErrorException::class)
    suspend fun getAll(): List<Movie>

    /**
     * Save All Movies
     */
    @Throws(DBErrorException::class)
    suspend fun save(movies: List<Movie>)

}