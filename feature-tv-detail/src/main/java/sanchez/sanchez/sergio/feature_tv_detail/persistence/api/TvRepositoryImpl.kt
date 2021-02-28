package sanchez.sanchez.sergio.feature_tv_detail.persistence.api

import android.util.Log
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.repository.ITvNetworkRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository

/**
 * Tv Repository Impl
 * @param tvRepoNetworkRepository
 * @param tvDBRepository
 */
class TvRepositoryImpl constructor(
        private val tvRepoNetworkRepository: ITvNetworkRepository,
        private val tvDBRepository: IDBRepository<TvDetail>
): ITvRepository {

    /**
     * Get Tv Detail
     * @param id
     */
    override suspend fun getTvDetail(id: Long): TvDetail = try {
        Log.d("TV_REPO", "tvDBRepository.getById CALLED")
        tvDBRepository.getById(id)
    }  catch (ex: Exception) {
        try {
            Log.d("TV_REPO", "tvRepoNetworkRepository.getTvDetail CALLED")
            tvRepoNetworkRepository.getTvDetail(id).also {
                Log.d("TV_REPO", "tvDBRepository.save CALLED")
                tvDBRepository.save(it)
            }
        } catch (ex: Exception) {
            Log.d("TV_REPO", "error occurred ${ex.message} CALLED")
            throw RepoErrorException(ex)
        }
    }

}