package sanchez.sanchez.sergio.feature_tv_detail.ui.tv

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiEffect
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiEvent
import sanchez.sanchez.sergio.movie_addicts.core.ui.UiState
import java.lang.Exception


/**
 * Tv Detail MVI Contract
 */
class TvDetailContract {

    /**
     * UI Events
     */
    sealed class Event : UiEvent {
        data class FetchTvDetail(val id: Long): Event()
    }

    /**
     * UI Effects
     */
    sealed class Effect : UiEffect {
        data class OnShowError(val ex: Exception): Effect()
    }

    /**
     * UI State
     */
    data class State(
            val tvState: TvState
    ) : UiState


    sealed class TvState {
        object OnIdle: TvState()
        object OnLoading : TvState()
        data class OnLoaded(val tv: TvDetail): TvState()
    }
}