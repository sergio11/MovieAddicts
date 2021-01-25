package sanchez.sanchez.sergio.feature_main.persistence.network.repository.people

import androidx.annotation.WorkerThread
import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.network.mapper.PersonNetworkMapper
import sanchez.sanchez.sergio.feature_main.persistence.network.service.PeopleService
import sanchez.sanchez.sergio.test.core.persistence.network.exception.NetworkNoResultException
import sanchez.sanchez.sergio.test.core.persistence.network.repository.SupportNetworkRepository

/**
 * People Network Repository Impl
 * @param peopleService
 * @param personNetworkMapper
 */
class PeopleNetworkRepositoryImpl(
    private val peopleService: PeopleService,
    private val personNetworkMapper: PersonNetworkMapper
): SupportNetworkRepository(), IPeopleNetworkRepository {

    /**
     * Fetch Popular People
     * @param page
     */
    @WorkerThread
    override suspend fun fetchPopularPeople(page: Int): List<Person> = safeNetworkCall {
        val result = peopleService.fetchPopularPeople(page)
        if(result.results.isEmpty())
            throw NetworkNoResultException("Not Popular People found")
        personNetworkMapper.dtoToModel(result.results)
    }
}