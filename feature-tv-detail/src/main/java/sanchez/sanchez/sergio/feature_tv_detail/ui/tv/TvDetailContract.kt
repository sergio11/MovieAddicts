package sanchez.sanchez.sergio.feature_tv_detail.ui.tv

import sanchez.sanchez.sergio.test.core.ui.UiEffect
import sanchez.sanchez.sergio.test.core.ui.UiEvent
import sanchez.sanchez.sergio.test.core.ui.UiState


/**
 * Tv Detail MVI Contract
 */
class TvDetailContract {

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
            val tvState: TvState
    ) : UiState

    sealed class TvState {
        object OnIdle: TvState()
        object OnLoading : TvState()
    }
}