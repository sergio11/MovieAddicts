package sanchez.sanchez.sergio.feature_person_detail.persistence.api

import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoNoResultException
import kotlin.jvm.Throws

/**
 * People Repository
 */
interface IPeopleRepository {

    /**
     * Get Person Detail
     * @param id
     * @return [PersonDetail]
     */
    @Throws(RepoNoResultException::class, RepoErrorException::class)
    suspend fun getPersonDetail(id: Long): PersonDetail


}