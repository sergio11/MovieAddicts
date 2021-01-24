package sanchez.sanchez.sergio.feature_main.ui.tv

import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Tv list View Model
 */
class TvListViewModel @Inject constructor(): SupportViewModel<TvListContract.Event, TvListContract.State, TvListContract.Effect>() {

    override fun createInitialState(): TvListContract.State =
        TvListContract.State(
            TvListContract.RandomNumberState.Idle
        )

    override fun handleEvent(event: TvListContract.Event) {

    }
}