package sanchez.sanchez.sergio.feature_person_detail.ui.person

import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiEffect
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiEvent
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiState
import java.lang.Exception

/**
 * Person Detail MVI Contract
 */
class PersonDetailContract {

    /**
     * UI Events
     */
    sealed class Event : UiEvent {
        data class FetchPersonDetail(val id: Long): Event()
    }

    /**
     * UI Effects
     */
    sealed class Effect : UiEffect {
        data class OnShowError(val ex: Exception): Effect()
    }

    /**
     * UI State
     */
    data class State(
            val personState: PersonState
    ) : UiState

    sealed class PersonState {
        object OnIdle: PersonState()
        object OnLoading : PersonState()
        data class OnLoaded(val personDetail: PersonDetail): PersonState()
    }
}