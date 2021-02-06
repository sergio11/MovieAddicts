package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import sanchez.sanchez.sergio.test.core.ui.UiEffect
import sanchez.sanchez.sergio.test.core.ui.UiEvent
import sanchez.sanchez.sergio.test.core.ui.UiState

/**
 * Movie Detail MVI Contract
 */
class MovieDetailContract {

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
            val movieState: MovieState
    ) : UiState

    sealed class MovieState {
        object OnIdle: MovieState()
        object OnLoading : MovieState()
    }
}