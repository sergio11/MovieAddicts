package sanchez.sanchez.sergio.feature_main.persistence.api.people

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.test.core.domain.model.PageData
import sanchez.sanchez.sergio.test.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.test.core.persistence.api.RepoNoResultException

/**
 * People Repository
 */
interface IPeopleRepository {

    /**
     * Fetch Popular People
     * @param page
     */
    @Throws(RepoNoResultException::class, RepoErrorException::class)
    suspend fun fetchPopularPeople(page: Long): PageData<Person>
}