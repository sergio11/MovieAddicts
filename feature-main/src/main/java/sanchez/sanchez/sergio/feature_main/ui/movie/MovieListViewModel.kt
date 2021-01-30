package sanchez.sanchez.sergio.feature_main.ui.movie

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_main.domain.usecase.DiscoverMoviesInteract
import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Movie List View Model
 */
class MovieListViewModel @Inject constructor(
        private val getMoviesInteract: DiscoverMoviesInteract
): SupportViewModel<MovieListContract.Event, MovieListContract.State, MovieListContract.Effect>() {

    override fun createInitialState(): MovieListContract.State =
        MovieListContract.State(
            MovieListContract.MoviesState.OnIdle
        )

    override fun handleEvent(event: MovieListContract.Event) {
        when(event) {
            is MovieListContract.Event.OnFetchMovies -> {
                fetchMovies(event.page)
            }
        }
    }

    /**
     * Private Methods
     */

    /**
     * Fetch Movies
     */
    private fun fetchMovies(page: Int) = viewModelScope.launch {
        Log.d("MOVIES_L", "fetchMovies (page -> $page) CALLED")
        setState { copy(moviesState = MovieListContract.MoviesState.OnLoading) }
        getMoviesInteract.execute(
                params = DiscoverMoviesInteract.Params(page),
                onSuccess = fun(movies) {
                    Log.d("MOVIES_L", "onSuccess (movies size -> ${movies.size}) CALLED")
                    setState {
                        copy(moviesState = MovieListContract.MoviesState.OnLoaded(page, movies))
                    }
                },
                onError = fun(ex) {
                    Log.d("MOVIES_L", "onError ${ex.message} CALLED")
                    setEffect { MovieListContract.Effect.OnShowError(ex) }
                }
        )
    }

}