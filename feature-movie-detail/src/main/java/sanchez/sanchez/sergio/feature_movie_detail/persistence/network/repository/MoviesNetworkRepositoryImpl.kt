package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository

import android.util.Log
import androidx.annotation.WorkerThread
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Video
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper.MovieDetailNetworkMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper.MovieKeywordNetworkMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper.MovieReviewNetworkMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper.MovieVideoNetworkMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.service.MoviesService
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.repository.SupportNetworkRepository
import java.lang.Exception

/**
 * Movies Network Repository Impl
 * @param movieDetailNetworkMapper
 * @param movieKeywordNetworkMapper
 * @param movieReviewNetworkMapper
 * @param movieVideoNetworkMapper
 * @param moviesService
 */
class MoviesNetworkRepositoryImpl constructor(
        private val movieDetailNetworkMapper: MovieDetailNetworkMapper,
        private val movieKeywordNetworkMapper: MovieKeywordNetworkMapper,
        private val movieReviewNetworkMapper: MovieReviewNetworkMapper,
        private val movieVideoNetworkMapper: MovieVideoNetworkMapper,
        private val moviesService: MoviesService
): SupportNetworkRepository(), IMoviesNetworkRepository {

    /**
     * Get Movie Detail
     * @param id
     * @return [MovieDetail]
     */
    @WorkerThread
    override suspend fun getMovieDetail(id: Long): MovieDetail = coroutineScope {
        // Parallel requests
        val getMovieDetailDeferred = async { getMovie(id) }
        val getMovieKeywordsDeferred = async { getMovieKeywords(id) }
        val getMovieReviewsDeferred = async { getMovieReviews(id) }
        val getMovieVideosDeferred = async { getMovieVideos(id) }

        getMovieDetailDeferred.await().also {

            // Configure Movie Keywords
            it.keywords = try {
                getMovieKeywordsDeferred.await()
            } catch (ex: Exception) {
                null
            }

            // Configure Movie Reviews
            it.reviews = try {
                getMovieReviewsDeferred.await()
            } catch (ex: Exception) {
                null
            }

            // Configure Movie Videos
            it.videos = try {
                getMovieVideosDeferred.await()
            } catch (ex: Exception) {
                null
            }

        }
    }

    /**
     * Private Methods
     */

    /**
     * Get Movie
     * @param id
     */
    @WorkerThread
    private suspend fun getMovie(id: Long): MovieDetail = safeNetworkCall {
        Log.d("MOVIES_DETAIL", "getMovie -> $id")
        val movieDetailsDTO = moviesService.getMovieDetails(id)
        movieDetailNetworkMapper.dtoToModel(movieDetailsDTO)
    }

    /**
     * Get Movie Keywords
     * @param id
     */
    @WorkerThread
    private suspend fun getMovieKeywords(id: Long): List<Keyword> = safeNetworkCall {
        Log.d("MOVIES_DETAIL", "getMovieKeywords -> $id")
        val response = moviesService.getMovieKeywords(id)
        movieKeywordNetworkMapper.dtoToModel(response.keywords)
    }

    /**
     * Get Movie Reviews
     * @param id
     */
    @WorkerThread
    private suspend fun getMovieReviews(id: Long): List<Review> = safeNetworkCall {
        Log.d("MOVIES_DETAIL", "getMovieReviews -> $id")
        val response = moviesService.getMovieReviews(id)
        movieReviewNetworkMapper.dtoToModel(response.reviews)
    }

    /**
     * Get Movie Videos
     * @param id
     */
    @WorkerThread
    private suspend fun getMovieVideos(id: Long): List<Video> = safeNetworkCall {
        Log.d("MOVIES_DETAIL", "getMovieVideos -> $id")
        val response = moviesService.getMovieVideos(id)
        movieVideoNetworkMapper.dtoToModel(response.videos)
    }


}