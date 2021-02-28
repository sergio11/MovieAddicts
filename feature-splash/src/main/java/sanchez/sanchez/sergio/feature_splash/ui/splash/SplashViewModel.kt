package sanchez.sanchez.sergio.feature_splash.ui.splash

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.movie_addicts.core.auth.IAuthManager
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Splash View Model
 * @param authManager
 */
class SplashViewModel @Inject constructor(
    private val authManager: IAuthManager
): SupportViewModel<SplashContract.Event, SplashContract.State, SplashContract.Effect>() {

    override fun createInitialState(): SplashContract.State =
        SplashContract.State(
            SplashContract.SessionState.OnIdle
        )

    override fun handleEvent(event: SplashContract.Event) {
        when(event) {
            is SplashContract.Event.LoadSession -> fetchSession()
        }
    }

    /**
     * Fetch session
     */

    private fun fetchSession() = viewModelScope.launch {

        val sessionState = if(authManager.isAuthenticated())
            SplashContract.SessionState.OnLoaded
        else
            SplashContract.SessionState.OnNotFound

        setState { copy(sessionState = sessionState) }
    }
}