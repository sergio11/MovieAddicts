package sanchez.sanchez.sergio.feature_person_detail.ui.person

import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Person Detail View Model
 */
class PersonDetailViewModel @Inject constructor():
    SupportViewModel<PersonDetailContract.Event, PersonDetailContract.State, PersonDetailContract.Effect>() {

    override fun createInitialState(): PersonDetailContract.State =
            PersonDetailContract.State(
                    PersonDetailContract.PersonState.OnIdle
            )

    override fun handleEvent(event: PersonDetailContract.Event) {

    }
}