package sanchez.sanchez.sergio.feature_movie_detail.persistence.api

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoNoResultException
import kotlin.jvm.Throws

/**
 * Movies Repository
 */
interface IMoviesRepository {

    /**
     * Get Movie Details
     * @param id
     * @return [MovieDetail]
     */
    @Throws(RepoNoResultException::class, RepoErrorException::class)
    suspend fun getMovieDetails(id: Long): MovieDetail

}