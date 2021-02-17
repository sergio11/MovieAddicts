package sanchez.sanchez.sergio.feature_main.persistence.db.repository.tv

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.TvEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.tv.TvEntity
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBErrorException
import sanchez.sanchez.sergio.test.core.persistence.db.repository.exception.DBNoResultException

/**
 * Discover Tv DB Repository Impl
 * @param tvDAO
 * @param tvEntityMapper
 */
class DiscoverTvDBRepositoryImpl(
    private val tvDAO: Box<TvEntity>,
    private val tvEntityMapper: TvEntityMapper
): IDiscoverTvDBRepository {

    /**
     * Get All Tv series
     */
    override suspend fun getAll(): List<Tv> = withContext(Dispatchers.IO) {
        if(tvDAO.isEmpty)
            throw DBNoResultException("No tv series was found")
        try {
            tvEntityMapper.entityToModel(tvDAO.all)
        } catch (ex: Exception) {
            throw DBErrorException("Error getting tv series from box", ex)
        }
    }

    /**
     * Save Tv series
     * @param tvList
     */
    override suspend fun save(tvList: List<Tv>) = withContext(Dispatchers.IO) {
        try {
            tvDAO.run {
                removeAll()
                put(tvEntityMapper.modelToEntity(tvList))
            }
        } catch (ex: Exception) {
            throw DBErrorException("Error getting tv series from box", ex)
        }
    }
}