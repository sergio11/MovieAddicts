package sanchez.sanchez.sergio.feature_main.persistence.network.repository.people

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.test.core.domain.model.PageData
import sanchez.sanchez.sergio.test.core.persistence.network.exception.NetworkException

/**
 * People Network Repository
 */
interface IPeopleNetworkRepository {

    /**
     * Fetch Popular People
     * @param page
     */
    @Throws(NetworkException::class)
    suspend fun fetchPopularPeople(page: Long): PageData<Person>
}