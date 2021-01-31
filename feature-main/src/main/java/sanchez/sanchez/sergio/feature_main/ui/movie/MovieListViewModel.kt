package sanchez.sanchez.sergio.feature_main.ui.movie

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_main.domain.usecase.DiscoverMoviesInteract
import sanchez.sanchez.sergio.feature_main.ui.core.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Movie List View Model
 */
class MovieListViewModel @Inject constructor(
        private val getMoviesInteract: DiscoverMoviesInteract
): SupportViewModel<LCEContract.Event, LCEContract.State, LCEContract.Effect>() {

    override fun createInitialState(): LCEContract.State =
        LCEContract.State(
                LCEContract.LCEState.OnIdle
        )

    override fun handleEvent(event: LCEContract.Event) {
        when(event) {
            is LCEContract.Event.OnFetchData -> {
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
    private fun fetchMovies(page: Int) = GlobalScope.launch {
        Log.d("MOVIES_L", "fetchMovies (page -> $page) CALLED")
        setState { copy(lceState = LCEContract.LCEState.OnLoading) }
        getMoviesInteract.execute(
                params = DiscoverMoviesInteract.Params(page),
                onSuccess = fun(movies) {
                    Log.d("MOVIES_L", "onSuccess (movies size -> ${movies.size}) CALLED")
                    setState {
                        copy(lceState = LCEContract.LCEState.OnLoaded(page, movies))
                    }
                },
                onError = fun(ex) {
                    ex.printStackTrace()
                    Log.d("MOVIES_L", "onError ${ex.message} CALLED")
                    setEffect { LCEContract.Effect.OnShowError(ex) }
                }
        )
    }

}