package sanchez.sanchez.sergio.feature_main.ui.tv

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_main.domain.usecase.DiscoverTvsInteract
import sanchez.sanchez.sergio.feature_main.ui.core.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Tv list View Model
 */
class TvListViewModel @Inject constructor(
    private val discoverTvsInteract: DiscoverTvsInteract
): SupportViewModel<LCEContract.Event, LCEContract.State, LCEContract.Effect>() {

    override fun createInitialState(): LCEContract.State =
        LCEContract.State(
            LCEContract.LCEState.OnIdle
        )

    override fun handleEvent(event: LCEContract.Event) {
        when(event) {
            is LCEContract.Event.OnFetchData -> {
                fetchTvs(event.page)
            }
        }
    }

    /**
     * Private Methods
     */

    /**
     * Fetch Tvs
     * @param page
     */
    private fun fetchTvs(page: Int) = viewModelScope.launch {
        Log.d("TVS_L", "fetchTvs (page -> $page) CALLED")
        setState { copy(lceState = LCEContract.LCEState.OnLoading) }
        discoverTvsInteract.execute(
            params = DiscoverTvsInteract.Params(page),
            onSuccess = fun(tvList) {
                Log.d("TVS_L", "onSuccess (TV size -> ${tvList.size}) CALLED")
                setState {
                    copy(lceState = LCEContract.LCEState.OnLoaded(page, tvList))
                }
            },
            onError = fun(ex) {
                Log.d("TVS_L", "onError ${ex.message} CALLED")
                setEffect { LCEContract.Effect.OnShowError(ex) }
            }
        )
    }
}