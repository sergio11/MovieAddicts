package sanchez.sanchez.sergio.feature_tv_detail.ui.tv

import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Tv Detail View Model
 */
class TvDetailViewModel @Inject constructor():
        SupportViewModel<TvDetailContract.Event, TvDetailContract.State, TvDetailContract.Effect>(){

    override fun createInitialState(): TvDetailContract.State =
            TvDetailContract.State(
                    tvState = TvDetailContract.TvState.OnIdle
            )

    override fun handleEvent(event: TvDetailContract.Event) {

    }
}