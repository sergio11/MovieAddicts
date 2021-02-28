package sanchez.sanchez.sergio.feature_main.domain.usecase

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.api.tv.IDiscoverTvRepository
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData

/**
 * Discover Tvs Interact
 * @param discoverTvRepository
 */
class DiscoverTvsInteract (private val discoverTvRepository: IDiscoverTvRepository) {

    /**
     * Execute
     * @param onSuccess
     * @param onError
     */
    suspend fun execute(
        params: Params,
        onSuccess: (pageData: PageData<Tv>) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val pageData = discoverTvRepository.fetchDiscoverTv(params.page)
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