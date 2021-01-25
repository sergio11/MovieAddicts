package sanchez.sanchez.sergio.feature_main.domain.usecase

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.persistence.api.IDiscoverMoviesRepository

/**
 * Discover Movies Interact
 * @param discoverMoviesRepository
 */
class DiscoverMoviesInteract (private val discoverMoviesRepository: IDiscoverMoviesRepository) {

    /**
     * Execute
     * @param onSuccess
     * @param onError
     */
    suspend fun execute(
        params: Params,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val movies = discoverMoviesRepository.getDiscoverMovies(params.page)
        onSuccess(movies)
    } catch (ex: Exception) {
        onError(ex)
    }

    /**
     * Params
     */
    data class Params(
        val page: Int
    )

}