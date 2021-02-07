package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_movie_detail.domain.usecase.GetMovieDetailInteract
import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Movie Detail View Model
 */
class MovieDetailViewModel @Inject constructor(
        private val getMovieDetailInteract: GetMovieDetailInteract
) : SupportViewModel<MovieDetailContract.Event, MovieDetailContract.State, MovieDetailContract.Effect>(){

    override fun createInitialState(): MovieDetailContract.State =
            MovieDetailContract.State(
                    MovieDetailContract.MovieState.OnIdle
            )

    override fun handleEvent(event: MovieDetailContract.Event) {
        when(event) {
            is MovieDetailContract.Event.FetchMovieDetail -> fetchMovieDetail(event.id)
        }
    }

    /**
     * Private Methods
     */

    /**
     * Fetch Movie Detail
     * @param movieId
     */
    private fun fetchMovieDetail(movieId: Long) = viewModelScope.launch {
        Log.d("MOVIES_DETAIL", "Fetch Movie Detail (id -> $movieId) CALLED")
        setState { copy(movieState = MovieDetailContract.MovieState.OnLoading) }
        getMovieDetailInteract.execute(
                params = GetMovieDetailInteract.Params(movieId),
                onSuccess = fun(movieDetail) {
                    Log.d("MOVIES_DETAIL", "onSuccess CALLED")
                    setState {
                        copy(movieState = MovieDetailContract.MovieState.OnLoaded(movieDetail))
                    }
                },
                onError = fun(ex) {
                    ex.printStackTrace()
                    Log.d("MOVIES_DETAIL", "onError ${ex.message} CALLED")
                    setEffect { MovieDetailContract.Effect.OnShowError(ex) }
                }
        )
    }
}