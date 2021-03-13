package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiEffect
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiEvent
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiState
import java.lang.Exception

/**
 * Movie Detail MVI Contract
 */
class MovieDetailContract {

    /**
     * UI Events
     */
    sealed class Event : UiEvent {
        data class FetchMovieDetail(val id: Long): Event()
        data class ChangeFavoriteState(val id: Long): Event()
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
            val movieState: MovieState
    ) : UiState

    sealed class MovieState {
        object OnIdle: MovieState()
        object OnLoading : MovieState()
        data class OnLoaded(val movie: MovieDetail): MovieState()
    }
}