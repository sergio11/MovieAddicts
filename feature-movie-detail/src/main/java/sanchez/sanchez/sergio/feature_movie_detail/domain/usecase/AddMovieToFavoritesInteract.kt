package sanchez.sanchez.sergio.feature_movie_detail.domain.usecase

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.persistence.api.IMoviesRepository

/**
 * Add Movie To Favorites Interact
 * @param movieRepository
 */
class AddMovieToFavoritesInteract(
    private val movieRepository: IMoviesRepository
) {


    /**
     * Execute
     * @param onSuccess
     * @param onError
     */
    suspend fun execute(
        params: Params,
        onSuccess: (movieDetail: MovieDetail) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val movieDetail = movieRepository.addMovieToFavoriteList(params.movieId)
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