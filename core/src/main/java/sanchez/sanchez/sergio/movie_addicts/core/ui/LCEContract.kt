package sanchez.sanchez.sergio.movie_addicts.core.ui

import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData
import java.lang.Exception

class LCEContract {

    sealed class Event : UiEvent {
        object OnLoadInitialData : Event()
        object OnLoadNextPage : Event()
    }

    data class State(
        val lceState: LCEState
    ) : UiState

    sealed class LCEState {
        object OnIdle: LCEState()
        object OnLoading : LCEState()
        object OnError: LCEState()
        data class OnLoaded<T>(val pageData: PageData<T>) : LCEState()
    }

    sealed class Effect : UiEffect {
        data class OnShowError(val ex: Exception) : Effect()
    }
}