package sanchez.sanchez.sergio.feature_movie_detail.persistence.api

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository.IMoviesNetworkRepository
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException

/**
 * Movies Repository Impl
 * @param moviesNetworkRepository
 */
class MoviesRepositoryImpl constructor(
        private val moviesNetworkRepository: IMoviesNetworkRepository
): IMoviesRepository {

    /**
     * Get Movie Details
     * @param id
     * @return [MovieDetail]
     */
    override suspend fun getMovieDetails(id: Long): MovieDetail = try {
        moviesNetworkRepository.getMovieDetail(id)
    } catch (ex: Exception) {
        throw RepoErrorException(ex)
    }
}