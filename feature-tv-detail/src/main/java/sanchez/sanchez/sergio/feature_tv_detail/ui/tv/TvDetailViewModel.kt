package sanchez.sanchez.sergio.feature_tv_detail.ui.tv

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_tv_detail.domain.usecase.GetTvDetailInteract
import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Tv Detail View Model
 */
class TvDetailViewModel @Inject constructor(
        private val getTvDetailInteract: GetTvDetailInteract
): SupportViewModel<TvDetailContract.Event, TvDetailContract.State, TvDetailContract.Effect>(){

    override fun createInitialState(): TvDetailContract.State =
            TvDetailContract.State(
                    tvState = TvDetailContract.TvState.OnIdle
            )

    override fun handleEvent(event: TvDetailContract.Event) {
        when(event) {
            is TvDetailContract.Event.FetchTvDetail -> fetchTvDetail(event.id)
        }
    }

    /**
     * Private Methods
     */

    /**
     * Fetch Tv Detail
     * @param tvId
     */
    private fun fetchTvDetail(tvId: Long) = viewModelScope.launch {
        setState { copy(tvState = TvDetailContract.TvState.OnLoading) }
        getTvDetailInteract.execute(
                params = GetTvDetailInteract.Params(tvId),
                onSuccess = fun(tvDetail) {
                    setState {
                        copy(tvState = TvDetailContract.TvState.OnLoaded(tvDetail))
                    }
                },
                onError = fun(ex) {
                    ex.printStackTrace()
                    setEffect { TvDetailContract.Effect.OnShowError(ex) }
                }
        )
    }
}