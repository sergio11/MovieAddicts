package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.exception.NetworkException
import kotlin.jvm.Throws

/**
 * Movies Network Repository
 */
interface IMoviesNetworkRepository {

    /**
     * Get Movie Detail
     * @param id
     * @return [MovieDetail]
     */
    @Throws(NetworkException::class)
    suspend fun getMovieDetail(id: Long): MovieDetail

    /**
     * Add Movie to favorites
     * @param id
     */
    @Throws(NetworkException::class)
    suspend fun addMovieToFavorites(id: Long): MovieDetail

    /**
     * Remove Movie from favorites
     * @param id
     */
    @Throws(NetworkException::class)
    suspend fun removeMovieFromFavorites(id: Long): MovieDetail
}