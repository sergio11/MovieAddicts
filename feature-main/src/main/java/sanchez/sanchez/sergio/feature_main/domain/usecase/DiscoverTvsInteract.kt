package sanchez.sanchez.sergio.feature_main.domain.usecase

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.api.tv.IDiscoverTvRepository

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
        onSuccess: (tvList: List<Tv>) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val tvList = discoverTvRepository.fetchDiscoverTv(params.page)
        onSuccess(tvList)
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