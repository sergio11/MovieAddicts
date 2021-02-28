package sanchez.sanchez.sergio.movie_addicts.feature_login.ui.login

import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Login View Model
 */
class LoginViewModel @Inject constructor():
    SupportViewModel<LoginContract.Event, LoginContract.State, LoginContract.Effect>() {

    override fun createInitialState(): LoginContract.State =
        LoginContract.State(
            LoginContract.LoginState.OnIdle
        )

    override fun handleEvent(event: LoginContract.Event) {
        when(event) {
            is LoginContract.Event.FetchMovieDetail -> {

            }
        }
    }
}