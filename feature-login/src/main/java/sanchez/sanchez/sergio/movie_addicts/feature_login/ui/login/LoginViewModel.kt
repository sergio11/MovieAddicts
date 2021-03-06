package sanchez.sanchez.sergio.movie_addicts.feature_login.ui.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.AuthTypeEnum
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.AuthUser
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportViewModel
import sanchez.sanchez.sergio.movie_addicts.feature_login.domain.usecase.SignInWithCredentialInteract
import javax.inject.Inject

/**
 * Login View Model
 */
class LoginViewModel @Inject constructor(
    private val signInWithCredentialInteract: SignInWithCredentialInteract
):
    SupportViewModel<LoginContract.Event, LoginContract.State, LoginContract.Effect>() {

    override fun createInitialState(): LoginContract.State =
        LoginContract.State(
            LoginContract.LoginState.OnIdle
        )

    override fun handleEvent(event: LoginContract.Event) {
        when(event) {
            is LoginContract.Event.SignInWithToken ->
                signInWithCredential(event.accessToken, event.authType)
        }
    }

    /**
     * Private Methods
     */

    private fun signInWithCredential(accessToken: String, authType: AuthTypeEnum) = viewModelScope.launch {
        Log.d("LOGIN_FRA", "signInWithCredential ($accessToken) CALLED")
        setState { copy(loginState = LoginContract.LoginState.OnProgress) }
        signInWithCredentialInteract.execute(
            params = SignInWithCredentialInteract.Params(accessToken, authType),
            onSuccess = fun(authUser: AuthUser) {
                Log.d("LOGIN_FRA", "authUser (${authUser.displayName}) CALLED")
                setState {
                    copy(loginState = LoginContract.LoginState.OnSuccess)
                }
            },
            onError = fun(ex: Exception) {
                Log.d("LOGIN_FRA", "onError (${ex}) CALLED")
                ex.printStackTrace()
                setEffect { LoginContract.Effect.OnShowError(ex) }
            })

    }
}