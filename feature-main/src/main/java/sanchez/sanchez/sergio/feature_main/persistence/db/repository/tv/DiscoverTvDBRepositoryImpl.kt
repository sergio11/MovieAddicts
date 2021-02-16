package sanchez.sanchez.sergio.feature_main.persistence.db.repository.tv

import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.TvEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.tv.TvEntity

/**
 * Discover Tv DB Repository Impl
 * @param tvDAO
 * @param tvEntityMapper
 */
class DiscoverTvDBRepositoryImpl(
    private val tvDAO: Box<TvEntity>,
    private val tvEntityMapper: TvEntityMapper
): IDiscoverTvDBRepository {

    override suspend fun getAll(): List<Tv> = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }

    override suspend fun save(tvList: List<Tv>) = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")
    }
}