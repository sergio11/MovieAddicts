package sanchez.sanchez.sergio.feature_main.persistence.api.tv

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoNoResultException

/**
 * Discover Tv Repository
 */
interface IDiscoverTvRepository {

    /**
     * Fetch Discover Tv
     * @param page
     */
    @Throws(RepoNoResultException::class, RepoErrorException::class)
    suspend fun fetchDiscoverTv(page: Long): PageData<Tv>
}