package sanchez.sanchez.sergio.feature_main.ui.core

import sanchez.sanchez.sergio.test.core.ui.UiEffect
import sanchez.sanchez.sergio.test.core.ui.UiEvent
import sanchez.sanchez.sergio.test.core.ui.UiState
import java.lang.Exception

class LCEContract {

    sealed class Event : UiEvent {
        data class OnFetchData(val page: Int = 1) : Event()
    }

    data class State(
        val lceState: LCEState
    ) : UiState

    sealed class LCEState {
        object OnIdle: LCEState()
        object OnLoading : LCEState()
        data class OnLoaded<T>(val page : Int, val data: List<T>) : LCEState()
    }

    sealed class Effect : UiEffect {
        data class OnShowError(val ex: Exception) : Effect()
    }
}