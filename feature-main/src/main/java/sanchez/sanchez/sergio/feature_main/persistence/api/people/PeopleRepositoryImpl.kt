package sanchez.sanchez.sergio.feature_main.persistence.api.people

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.people.IPeopleNetworkRepository
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository
import java.lang.Exception

/**
 * People Repository Impl
 * @param peopleNetworkRepository
 * @param peopleDBRepository
 */
class PeopleRepositoryImpl(
    private val peopleNetworkRepository: IPeopleNetworkRepository,
    private val peopleDBRepository: IDBRepository<Person>
): IPeopleRepository {

    /**
     * Fetch Popular People
     * @param page
     */
    override suspend fun fetchPopularPeople(page: Long): PageData<Person> = try {
        peopleNetworkRepository.fetchPopularPeople(page).also {
            peopleDBRepository.save(it.data)
        }
    } catch (ex: Exception) {
        try {
            PageData(page = 1, data = peopleDBRepository.getAll(), isLast = true)
        } catch (ex: Exception) {
            throw RepoErrorException(ex)
        }
    }
}