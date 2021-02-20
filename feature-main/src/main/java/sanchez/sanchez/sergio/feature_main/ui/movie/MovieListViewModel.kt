package sanchez.sanchez.sergio.feature_main.ui.movie

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_main.domain.usecase.DiscoverMoviesInteract
import sanchez.sanchez.sergio.test.core.ui.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportLCEViewModel
import javax.inject.Inject

/**
 * Movie List View Model
 */
class MovieListViewModel @Inject constructor(
        private val getMoviesInteract: DiscoverMoviesInteract
): SupportLCEViewModel() {

    /**
     * Fetch Movies
     */
    override fun onFetchData(page: Long) {
        viewModelScope.launch {
            Log.d("MOVIES_L", "fetchMovies (page -> $page) CALLED")
            setState { copy(lceState = LCEContract.LCEState.OnLoading) }
            getMoviesInteract.execute(
                    params = DiscoverMoviesInteract.Params(page),
                    onSuccess = fun(pageData) {
                        Log.d("MOVIES_L", "onSuccess (movies size -> ${pageData.data.size}) CALLED")
                        setState {
                            copy(lceState = LCEContract.LCEState.OnLoaded(pageData))
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

}