package sanchez.sanchez.sergio.movie_addicts.feature_login.ui.login

import sanchez.sanchez.sergio.movie_addicts.core.ui.UiEffect
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiEvent
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiState
import java.lang.Exception

/**
 * Login MVI Contract
 */
class LoginContract {

    /**
     * UI Events
     */
    sealed class Event : UiEvent {
        data class SignInWithCredential(val accessToken: String): Event()
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
            val loginState: LoginState
    ) : UiState

    sealed class LoginState {
        object OnIdle: LoginState()
        object OnSuccess : LoginState()
        object OnProgress: LoginState()
    }
}