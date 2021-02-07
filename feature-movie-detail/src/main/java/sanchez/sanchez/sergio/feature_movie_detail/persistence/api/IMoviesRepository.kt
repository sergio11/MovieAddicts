package sanchez.sanchez.sergio.feature_movie_detail.persistence.api

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail

/**
 * Movies Repository
 */
interface IMoviesRepository {

    /**
     * Get Movie Details
     * @param id
     * @return [MovieDetail]
     */
    suspend fun getMovieDetails(id: Long): MovieDetail

}