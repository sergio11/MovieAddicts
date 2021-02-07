package sanchez.sanchez.sergio.feature_person_detail.persistence.api

import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.repository.IPeopleNetworkRepository
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException

/**
 * People Repository Impl
 * @param peopleNetworkRepository
 */
class PeopleRepositoryImpl constructor(
        private val peopleNetworkRepository: IPeopleNetworkRepository
): IPeopleRepository {

    /**
     * Get Person Detail
     * @param id
     */
    override suspend fun getPersonDetail(id: Long): PersonDetail = try {
        peopleNetworkRepository.getPersonDetail(id)
    }  catch (ex: Exception) {
        throw RepoErrorException(ex)
    }
}