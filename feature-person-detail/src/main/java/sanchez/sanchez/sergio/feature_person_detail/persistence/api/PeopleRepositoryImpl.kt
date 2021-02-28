package sanchez.sanchez.sergio.feature_person_detail.persistence.api

import android.util.Log
import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.repository.IPeopleNetworkRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.api.RepoErrorException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository

/**
 * People Repository Impl
 * @param peopleNetworkRepository
 * @param peopleDBRepository
 */
class PeopleRepositoryImpl constructor(
        private val peopleNetworkRepository: IPeopleNetworkRepository,
        private val peopleDBRepository: IDBRepository<PersonDetail>
): IPeopleRepository {

    /**
     * Get Person Detail
     * @param id
     */
    override suspend fun getPersonDetail(id: Long): PersonDetail = try {
        Log.d("PEOPLE_REPO", "peopleDBRepository.getById CALLED")
        peopleDBRepository.getById(id)
    }  catch (ex: Exception) {
        try {
            Log.d("PEOPLE_REPO", "peopleNetworkRepository.getPersonDetail CALLED")
            peopleNetworkRepository.getPersonDetail(id).also {
                Log.d("PEOPLE_REPO", "peopleDBRepository.save CALLED")
                peopleDBRepository.save(it)
            }
        } catch (ex: Exception) {
            throw RepoErrorException(ex)
        }
    }
}