package sanchez.sanchez.sergio.feature_person_detail.persistence.network.repository

import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.exception.NetworkException
import kotlin.jvm.Throws

interface IPeopleNetworkRepository {

    /**
     * Get Person Detail
     * @param id
     */
    @Throws(NetworkException::class)
    suspend fun getPersonDetail(id: Long): PersonDetail
}