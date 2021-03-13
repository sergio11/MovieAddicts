package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_movie_detail.domain.usecase.AddMovieToFavoritesInteract
import sanchez.sanchez.sergio.feature_movie_detail.domain.usecase.DeleteMovieFromFavoritesInteract
import sanchez.sanchez.sergio.feature_movie_detail.domain.usecase.GetMovieDetailInteract
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Movie Detail View Model
 * @param getMovieDetailInteract
 * @param addMovieToFavoritesInteract
 * @param deleteMovieFromFavoritesInteract
 */
class MovieDetailViewModel @Inject constructor(
        private val getMovieDetailInteract: GetMovieDetailInteract,
        private val addMovieToFavoritesInteract: AddMovieToFavoritesInteract,
        private val deleteMovieFromFavoritesInteract: DeleteMovieFromFavoritesInteract
) : SupportViewModel<MovieDetailContract.Event, MovieDetailContract.State, MovieDetailContract.Effect>(){

    override fun createInitialState(): MovieDetailContract.State =
            MovieDetailContract.State(
                    MovieDetailContract.MovieState.OnIdle
            )

    override fun handleEvent(event: MovieDetailContract.Event) {
        when(event) {
            is MovieDetailContract.Event.FetchMovieDetail -> fetchMovieDetail(event.id)
            is MovieDetailContract.Event.ChangeFavoriteState -> onChangeFavoriteState(event.id)
        }
    }

    /**
     * Private Methods
     */

    /**
     * On Change Favorite State
     * @param movieId
     */
    private fun onChangeFavoriteState(movieId: Long)  {
        val state = currentState.movieState
        if(state is MovieDetailContract.MovieState.OnLoaded)
            if(state.movie.isFavorite)
                onDeleteFromFavorites(movieId)
            else
                onAddMovieToFavorites(movieId)
    }

    /**
     * On Add Movie to favorites
     * @param movieId
     */
    private fun onAddMovieToFavorites(movieId: Long) = viewModelScope.launch {
        addMovieToFavoritesInteract.execute(
            params = AddMovieToFavoritesInteract.Params(movieId),
            onSuccess = fun(movieDetail) {
                Log.d("MOVIES_DETAIL", "onSuccess CALLED")
                setState {
                    copy(movieState = MovieDetailContract.MovieState.OnLoaded(movieDetail))
                }
            },
            onError = fun(ex: Exception) {
                ex.printStackTrace()
                Log.d("MOVIES_DETAIL", "onError ${ex.message} CALLED")
                setEffect { MovieDetailContract.Effect.OnShowError(ex) }
            }
        )
    }

    /**
     * On Delete from favorites
     * @param movieId
     */
    private fun onDeleteFromFavorites(movieId: Long) = viewModelScope.launch {
        deleteMovieFromFavoritesInteract.execute(
            params = DeleteMovieFromFavoritesInteract.Params(movieId),
            onSuccess = fun(movieDetail) {
                Log.d("MOVIES_DETAIL", "onSuccess CALLED")
                setState {
                    copy(movieState = MovieDetailContract.MovieState.OnLoaded(movieDetail))
                }
            },
            onError = fun(ex: Exception) {
                ex.printStackTrace()
                Log.d("MOVIES_DETAIL", "onError ${ex.message} CALLED")
                setEffect { MovieDetailContract.Effect.OnShowError(ex) }
            }
        )
    }

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