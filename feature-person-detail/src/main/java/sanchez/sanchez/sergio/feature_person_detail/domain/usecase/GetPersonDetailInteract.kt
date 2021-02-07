package sanchez.sanchez.sergio.feature_person_detail.domain.usecase

import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.api.IPeopleRepository

/**
 * Get Person Detail interact
 * @param peopleRepository
 */
class GetPersonDetailInteract (private val peopleRepository: IPeopleRepository) {

    /**
     * Execute
     * @param onSuccess
     * @param onError
     */
    suspend fun execute(
        params: Params,
        onSuccess: (person: PersonDetail) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val personDetail = peopleRepository.getPersonDetail(params.personId)
        onSuccess(personDetail)
    } catch (ex: Exception) {
        onError(ex)
    }

    /**
     * Params
     */
    data class Params(
        val personId: Long
    )

}