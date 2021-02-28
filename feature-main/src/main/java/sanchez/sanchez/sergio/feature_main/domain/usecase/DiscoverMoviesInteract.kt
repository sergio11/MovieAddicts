package sanchez.sanchez.sergio.feature_main.domain.usecase

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData
import sanchez.sanchez.sergio.feature_main.persistence.api.movies.IDiscoverMoviesRepository

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
            onSuccess: (movies: PageData<Movie>) -> Unit,
            onError: (ex: Exception) -> Unit) = try {
        val pageData = discoverMoviesRepository.getDiscoverMovies(params.page)
        onSuccess(pageData)
    } catch (ex: Exception) {
        onError(ex)
    }

    /**
     * Params
     */
    data class Params(
        val page: Long
    )

}