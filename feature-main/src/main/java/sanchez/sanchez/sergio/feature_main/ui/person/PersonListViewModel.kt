package sanchez.sanchez.sergio.feature_main.ui.person

import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Person List View Model
 */
class PersonListViewModel @Inject constructor(): SupportViewModel<PersonListContract.Event, PersonListContract.State, PersonListContract.Effect>() {

    override fun createInitialState(): PersonListContract.State =
        PersonListContract.State(
            PersonListContract.RandomNumberState.Idle
        )

    override fun handleEvent(event: PersonListContract.Event) {

    }
}