package sanchez.sanchez.sergio.feature_main.ui.movie

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.test.core.ui.UiEffect
import sanchez.sanchez.sergio.test.core.ui.UiEvent
import sanchez.sanchez.sergio.test.core.ui.UiState
import java.lang.Exception

class MovieListContract {

    sealed class Event : UiEvent {
        data class OnFetchMovies(val page: Int = 1) : Event()
    }

    data class State(
        val moviesState: MoviesState
    ) : UiState

    sealed class MoviesState {
        object OnIdle: MoviesState()
        object OnLoading : MoviesState()
        data class OnLoaded(val page : Int, val movies: List<Movie>) : MoviesState()
    }

    sealed class Effect : UiEffect {
        data class OnShowError(val ex: Exception) : Effect()
    }

}