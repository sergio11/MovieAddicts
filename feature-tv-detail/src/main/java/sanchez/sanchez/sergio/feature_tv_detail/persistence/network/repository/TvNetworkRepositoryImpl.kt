package sanchez.sanchez.sergio.feature_tv_detail.persistence.network.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Video
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper.TvDetailNetworkMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper.TvKeywordNetworkMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper.TvReviewNetworkMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper.TvVideoNetworkMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.service.TvService
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.repository.SupportNetworkRepository
import java.lang.Exception


/**
 * Tv Network Repository Impl
 * @param tvDetailNetworkMapper
 * @param tvKeywordNetworkMapper
 * @param tvReviewNetworkMapper
 * @param tvVideoNetworkMapper
 * @param tvService
 */
class TvNetworkRepositoryImpl constructor(
        private val tvDetailNetworkMapper: TvDetailNetworkMapper,
        private val tvKeywordNetworkMapper: TvKeywordNetworkMapper,
        private val tvReviewNetworkMapper: TvReviewNetworkMapper,
        private val tvVideoNetworkMapper: TvVideoNetworkMapper,
        private val tvService: TvService
): SupportNetworkRepository(), ITvNetworkRepository {


    @WorkerThread
    override suspend fun getTvDetail(id: Long): TvDetail = coroutineScope {
        // Parallel requests
        val getTvDetailDeferred = async { getTv(id) }
        val getTvKeywordsDeferred = async { getTvKeywords(id) }
        val getTvReviewsDeferred = async { getTvReviews(id) }
        val getTvVideosDeferred = async { getTvVideos(id) }

        getTvDetailDeferred.await().also {

            // Configure Tv Keywords
            it.keywords = try {
                getTvKeywordsDeferred.await()
            } catch (ex: Exception) {
                null
            }

            // Configure Tv Reviews
            it.reviews = try {
                getTvReviewsDeferred.await()
            } catch (ex: Exception) {
                null
            }

            // Configure Tv Videos
            it.videos = try {
                getTvVideosDeferred.await()
            } catch (ex: Exception) {
                null
            }

        }
    }

    /**
     * Private Methods
     */

    /**
     * Get Tv
     * @param id
     */
    @WorkerThread
    private suspend fun getTv(id: Long): TvDetail = safeNetworkCall {
        val response = tvService.getTvDetail(id)
        tvDetailNetworkMapper.dtoToModel(response)
    }

    /**
     * Get Tv Keywords
     * @param id
     */
    @WorkerThread
    private suspend fun getTvKeywords(id: Long): List<Keyword> = safeNetworkCall {
        val response = tvService.getTvKeywords(id)
        tvKeywordNetworkMapper.dtoToModel(response.keywords)
    }

    /**
     * Get Tv Reviews
     * @param id
     */
    @WorkerThread
    private suspend fun getTvReviews(id: Long): List<Review> = safeNetworkCall {
        val response = tvService.getTvReviews(id)
        tvReviewNetworkMapper.dtoToModel(response.reviews)
    }

    /**
     * Get Tv Videos
     * @param id
     */
    @WorkerThread
    private suspend fun getTvVideos(id: Long): List<Video> = safeNetworkCall {
        val response = tvService.getTvVideos(id)
        tvVideoNetworkMapper.dtoToModel(response.videos)
    }

}