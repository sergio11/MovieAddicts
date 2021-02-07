package sanchez.sanchez.sergio.feature_person_detail.persistence.network.repository

import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.mapper.PersonDetailNetworkMapper
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.service.PeopleService
import sanchez.sanchez.sergio.test.core.persistence.network.repository.SupportNetworkRepository

/**
 * People Network Repository Impl
 */
class PeopleNetworkRepositoryImpl constructor(
        private val personDetailNetworkMapper: PersonDetailNetworkMapper,
        private val peopleService: PeopleService
): SupportNetworkRepository(), IPeopleNetworkRepository {

    /**
     * Get Person Detail
     * @param id
     * @return [PersonDetail]
     */
    override suspend fun getPersonDetail(id: Long): PersonDetail = safeNetworkCall {
        val response = peopleService.getPersonDetail(id)
        personDetailNetworkMapper.dtoToModel(response)
    }


}