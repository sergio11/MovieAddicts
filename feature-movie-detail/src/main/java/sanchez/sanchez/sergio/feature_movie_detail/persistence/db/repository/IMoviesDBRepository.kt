package sanchez.sanchez.sergio.feature_movie_detail.persistence.db.repository

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail

/**
 * Movies DB Repository
 */
interface IMoviesDBRepository {

    /**
     * Get Movie Detail By Id
     * @param id
     */
    suspend fun getById(id: Long): MovieDetail

    /**
     * Save Movie Detail
     * @param movieDetail
     */
    suspend fun save(movieDetail: MovieDetail)
}