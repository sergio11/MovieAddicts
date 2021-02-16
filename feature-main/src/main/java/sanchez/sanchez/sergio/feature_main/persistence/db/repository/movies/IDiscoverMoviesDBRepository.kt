package sanchez.sanchez.sergio.feature_main.persistence.db.repository.movies

import sanchez.sanchez.sergio.feature_main.domain.model.Movie

/**
 * Discover Movies DB Repository
 */
interface IDiscoverMoviesDBRepository {

    /**
     * Get All Movies
     */
    suspend fun getAll(): List<Movie>

    /**
     * Save All Movies
     */
    suspend fun save(movies: List<Movie>)

}