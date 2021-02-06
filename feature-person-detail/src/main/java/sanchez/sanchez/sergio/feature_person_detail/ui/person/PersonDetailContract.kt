package sanchez.sanchez.sergio.feature_person_detail.ui.person

import sanchez.sanchez.sergio.test.core.ui.UiEffect
import sanchez.sanchez.sergio.test.core.ui.UiEvent
import sanchez.sanchez.sergio.test.core.ui.UiState

/**
 * Person Detail MVI Contract
 */
class PersonDetailContract {

    /**
     * UI Events
     */
    sealed class Event : UiEvent

    /**
     * UI Effects
     */
    sealed class Effect : UiEffect

    /**
     * UI State
     */
    data class State(
            val movieState: PersonState
    ) : UiState

    sealed class PersonState {
        object OnIdle: PersonState()
        object OnLoading : PersonState()
    }
}