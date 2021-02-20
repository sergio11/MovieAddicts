package sanchez.sanchez.sergio.feature_main.domain.usecase

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.api.people.IPeopleRepository
import sanchez.sanchez.sergio.test.core.domain.model.PageData

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
        onSuccess: (pageDate: PageData<Person>) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val pageDate = peopleRepository.fetchPopularPeople(params.page)
        onSuccess(pageDate)
    } catch (ex: Exception) {
        onError(ex)
    }

    /**
     * Params
     */
    data class Params(
        val page: Long
    )

}