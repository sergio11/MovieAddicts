package sanchez.sanchez.sergio.feature_movie_detail.domain.usecase

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.persistence.api.IMoviesRepository

/**
 * Get Movie Detail interact
 */
class GetMovieDetailInteract (
        private val moviesRepository: IMoviesRepository) {

    /**
     * Execute
     * @param onSuccess
     * @param onError
     */
    suspend fun execute(
        params: Params,
        onSuccess: (movie: MovieDetail) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val movieDetail = moviesRepository.getMovieDetails(params.movieId)
        onSuccess(movieDetail)
    } catch (ex: Exception) {
        onError(ex)
    }

    /**
     * Params
     */
    data class Params(
        val movieId: Long
    )

}