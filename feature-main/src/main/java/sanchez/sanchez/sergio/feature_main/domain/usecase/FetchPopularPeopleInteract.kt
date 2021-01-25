package sanchez.sanchez.sergio.feature_main.domain.usecase

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.api.people.IPeopleRepository

/**
 * Fetch Popular People Interact
 * @param peopleRepository
 */
class FetchPopularPeopleInteract (private val peopleRepository: IPeopleRepository) {

    /**
     * Execute
     * @param onSuccess
     * @param onError
     */
    suspend fun execute(
        params: Params,
        onSuccess: (personList: List<Person>) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val personList = peopleRepository.fetchPopularPeople(params.page)
        onSuccess(personList)
    } catch (ex: Exception) {
        onError(ex)
    }

    /**
     * Params
     */
    data class Params(
        val page: Int
    )

}