package sanchez.sanchez.sergio.feature_person_detail.ui.person

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_person_detail.domain.usecase.GetPersonDetailInteract
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Person Detail View Model
 */
class PersonDetailViewModel @Inject constructor(
        private val getPersonDetailInteract: GetPersonDetailInteract
): SupportViewModel<PersonDetailContract.Event, PersonDetailContract.State, PersonDetailContract.Effect>() {

    override fun createInitialState(): PersonDetailContract.State =
            PersonDetailContract.State(
                    PersonDetailContract.PersonState.OnIdle
            )

    override fun handleEvent(event: PersonDetailContract.Event) {
        when(event) {
            is PersonDetailContract.Event.FetchPersonDetail -> fetchPersonDetail(event.id)
        }
    }

    /**
     * Private Methods
     */

    /**
     * Fetch Person Detail
     * @param personId
     */
    private fun fetchPersonDetail(personId: Long) = viewModelScope.launch {
        setState { copy(personState = PersonDetailContract.PersonState.OnLoading) }
        getPersonDetailInteract.execute(
                params = GetPersonDetailInteract.Params(personId),
                onSuccess = fun(personDetail) {
                    setState {
                        copy(personState = PersonDetailContract.PersonState.OnLoaded(personDetail))
                    }
                },
                onError = fun(ex) {
                    ex.printStackTrace()
                    setEffect { PersonDetailContract.Effect.OnShowError(ex) }
                }
        )
    }
}