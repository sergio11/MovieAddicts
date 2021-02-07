package sanchez.sanchez.sergio.feature_tv_detail.domain.usecase

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.persistence.api.ITvRepository

/**
 * Get Tv Detail interact
 */
class GetTvDetailInteract (private val tvRepository: ITvRepository) {

    /**
     * Execute
     * @param onSuccess
     * @param onError
     */
    suspend fun execute(
        params: Params,
        onSuccess: (tvDetail: TvDetail) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val tvDetail = tvRepository.getTvDetail(params.tvId)
        onSuccess(tvDetail)
    } catch (ex: Exception) {
        onError(ex)
    }

    /**
     * Params
     */
    data class Params(
        val tvId: Long
    )

}