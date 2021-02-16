package sanchez.sanchez.sergio.feature_main.persistence.db.repository.movies

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.MovieEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.movies.MovieEntity

/**
 * Discover Movies DB Repository Impl
 * @param movieDAO
 * @param movieEntityMapper
 */
class DiscoverMoviesDBRepositoryImpl(
    private val movieDAO: Box<MovieEntity>,
    private val movieEntityMapper: MovieEntityMapper
): IDiscoverMoviesDBRepository {

    /**
     * Get All Movies
     */
    override suspend fun getAll(): List<Movie> = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }

    /**
     * Save movies
     * @param movies
     */
    override suspend fun save(movies: List<Movie>) = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }
}