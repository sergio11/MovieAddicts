package sanchez.sanchez.sergio.feature_splash.ui.splash

import sanchez.sanchez.sergio.test.core.ui.UiEffect
import sanchez.sanchez.sergio.test.core.ui.UiEvent
import sanchez.sanchez.sergio.test.core.ui.UiState
import java.lang.Exception

class SplashContract {

    /**
     * UI Events
     */
    sealed class Event : UiEvent {
        object LoadSession: Event()
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
        val sessionState: SessionState
    ) : UiState

    sealed class SessionState {
        object OnIdle: SessionState()
        object OnLoaded: SessionState()
        object OnNotFound : SessionState()
    }


}