package sanchez.sanchez.sergio.feature_movie_detail.persistence.api

import android.util.Log
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository.IMoviesNetworkRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository

/**
 * Movies Repository Impl
 * @param moviesNetworkRepository
 * @param movieDBRepository
 */
class MoviesRepositoryImpl constructor(
        private val moviesNetworkRepository: IMoviesNetworkRepository,
        private val movieDBRepository: IDBRepository<MovieDetail>
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

    /**
     * Add Movie to favorite list
     * @param id
     */
    override suspend fun addMovieToFavoriteList(id: Long): MovieDetail = try {
        moviesNetworkRepository.addMovieToFavorites(id).also {
            movieDBRepository.save(it)
        }
    } catch (ex: Exception) {
        throw RepoErrorException(ex)
    }

    /**
     * Delete Movie From favorites
     * @param id
     */
    override suspend fun deleteMovieFromFavorites(id: Long): MovieDetail = try {
        moviesNetworkRepository.removeMovieFromFavorites(id).also {
            movieDBRepository.save(it)
        }
    } catch (ex: Exception) {
        throw RepoErrorException(ex)
    }
}