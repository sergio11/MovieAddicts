package sanchez.sanchez.sergio.feature_main.persistence.api.movies

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies.IDiscoverMoviesNetworkRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository
import java.lang.Exception

/**
 * Discover Movies Repository
 * @param discoverMoviesNetworkRepository
 * @param moviesDBRepository
 */
class DiscoverMoviesRepositoryImpl (
        private val discoverMoviesNetworkRepository: IDiscoverMoviesNetworkRepository,
        private val moviesDBRepository: IDBRepository<Movie>): IDiscoverMoviesRepository {

    /**
     * Get Discover Movies
     * @param page
     */
    override suspend fun getDiscoverMovies(page: Long): PageData<Movie> = try {
        discoverMoviesNetworkRepository.getDiscoverMovies(page).also {
            moviesDBRepository.save(it.data)
        }
    } catch (ex: Exception) {
        try {
            PageData(page = 1, data = moviesDBRepository.getAll(), isLast = true)
        } catch (ex: Exception) {
            throw RepoErrorException(ex)
        }
    }
}