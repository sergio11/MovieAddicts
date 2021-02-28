package sanchez.sanchez.sergio.feature_splash.ui.splash

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Splash View Model
 */
class SplashViewModel @Inject constructor(): SupportViewModel<SplashContract.Event, SplashContract.State, SplashContract.Effect>() {

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
        setState { copy(sessionState = SplashContract.SessionState.OnLoaded) }
    }
}