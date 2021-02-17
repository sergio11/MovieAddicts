package sanchez.sanchez.sergio.feature_main.persistence.db.repository.movies

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.MovieEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.movies.MovieEntity
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException

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
        if(movieDAO.isEmpty)
            throw DBNoResultException("No movies was found")
        try {
            movieEntityMapper.entityToModel(movieDAO.all)
        } catch (ex: Exception) {
            throw DBErrorException("Error getting movies from box", ex)
        }
    }

    /**
     * Save movies
     * @param movies
     */
    override suspend fun save(movies: List<Movie>) = withContext(Dispatchers.IO) {
        try {
            movieDAO.run {
                removeAll()
                put(movieEntityMapper.modelToEntity(movies))
            }
        } catch (ex: Exception) {
            throw DBErrorException("Error getting movies from box", ex)
        }
    }
}