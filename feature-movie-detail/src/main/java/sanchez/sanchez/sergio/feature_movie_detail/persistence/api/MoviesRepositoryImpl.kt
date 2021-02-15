package sanchez.sanchez.sergio.feature_movie_detail.persistence.api

import android.util.Log
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.repository.IMoviesDBRepository
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository.IMoviesNetworkRepository
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException

/**
 * Movies Repository Impl
 * @param moviesNetworkRepository
 * @param movieDBRepository
 */
class MoviesRepositoryImpl constructor(
        private val moviesNetworkRepository: IMoviesNetworkRepository,
        private val movieDBRepository: IMoviesDBRepository
): IMoviesRepository {

    /**
     * Get Movie Details
     * @param id
     * @return [MovieDetail]
     */
    override suspend fun getMovieDetails(id: Long): MovieDetail = try {
        Log.d("MOVIES_REPO", "movieDBRepository.getById CALLED")
        movieDBRepository.getById(id)
    }  catch (ex: Exception) {
        try {
            Log.d("MOVIES_REPO", "moviesNetworkRepository.getMovieDetail CALLED")
            moviesNetworkRepository.getMovieDetail(id).also {
                Log.d("MOVIES_REPO", "movieDBRepository.save CALLED")
                movieDBRepository.save(it)
            }
        } catch (ex: Exception) {
            throw RepoErrorException(ex)
        }
    }
}