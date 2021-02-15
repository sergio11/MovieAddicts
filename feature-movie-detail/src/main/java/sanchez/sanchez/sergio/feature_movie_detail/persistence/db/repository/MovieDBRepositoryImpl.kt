package sanchez.sanchez.sergio.feature_movie_detail.persistence.db.repository

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper.MovieDetailEntityMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.MovieDetailEntity
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.MovieDetailEntity_
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException

/**
 * Movie DB Repository
 * @param movieDetailDAO
 * @param movieDetailEntityMapper
 */
class MovieDBRepositoryImpl(
    private val movieDetailDAO: Box<MovieDetailEntity>,
    private val movieDetailEntityMapper: MovieDetailEntityMapper
): IMoviesDBRepository {

    /**
     * Get By Id
     * @param id
     */
    @Throws(DBNoResultException::class)
    override suspend fun getById(id: Long): MovieDetail = withContext(Dispatchers.IO) {

        val movieDetailEntity = movieDetailDAO.query()
            .equal(MovieDetailEntity_.id, id)
            .build().findUnique() ?: throw DBNoResultException()

        movieDetailEntityMapper.entityToModel(movieDetailEntity)
    }

    /**
     * Save Movie Detail
     * @param movieDetail
     */
    @Throws(DBErrorException::class)
    override suspend fun save(movieDetail: MovieDetail): Unit = withContext(Dispatchers.IO) {
        movieDetailDAO.put(movieDetailEntityMapper.modelToEntity(movieDetail))
    }


}