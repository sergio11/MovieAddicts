package sanchez.sanchez.sergio.feature_main.ui.tv

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_main.domain.usecase.DiscoverTvsInteract
import sanchez.sanchez.sergio.movie_addicts.core.ui.LCEContract
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportLCEViewModel
import javax.inject.Inject

/**
 * Tv list View Model
 */
class TvListViewModel @Inject constructor(
    private val discoverTvsInteract: DiscoverTvsInteract
): SupportLCEViewModel() {

    /**
     * On Fetch Data
     * @param page
     */
    override fun onFetchData(page: Long) {
        viewModelScope.launch {
            Log.d("TVS_L", "fetchTvs (page -> $page) CALLED")
            setState { copy(lceState = LCEContract.LCEState.OnLoading) }
            discoverTvsInteract.execute(
                    params = DiscoverTvsInteract.Params(page),
                    onSuccess = fun(pageData) {
                        Log.d("TVS_L", "onSuccess (TV size -> ${pageData.data.size}) CALLED")
                        setState {
                            copy(lceState = LCEContract.LCEState.OnLoaded(pageData))
                        }
                    },
                    onError = fun(ex) {
                        setState { copy(lceState = LCEContract.LCEState.OnError) }
                        Log.d("TVS_L", "onError ${ex.message} CALLED")
                        setEffect { LCEContract.Effect.OnShowError(ex) }
                    }
            )
        }
    }
}