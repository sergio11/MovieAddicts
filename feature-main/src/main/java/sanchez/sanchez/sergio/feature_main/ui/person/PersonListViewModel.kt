package sanchez.sanchez.sergio.feature_main.ui.person

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_main.domain.usecase.FetchPopularPeopleInteract
import sanchez.sanchez.sergio.feature_main.ui.core.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Person List View Model
 */
class PersonListViewModel @Inject constructor(
    private val peopleInteract: FetchPopularPeopleInteract
): SupportViewModel<LCEContract.Event, LCEContract.State, LCEContract.Effect>() {

    override fun createInitialState(): LCEContract.State =
        LCEContract.State(
            LCEContract.LCEState.OnIdle
        )

    override fun handleEvent(event: LCEContract.Event) {
        when(event) {
            is LCEContract.Event.OnFetchData -> {
                fetchPopularPeople(event.page)
            }
        }
    }

    /**
     * Private Methods
     */

    /**
     * Fetch Popular People
     * @param page
     */
    private fun fetchPopularPeople(page: Int) = viewModelScope.launch {
        Log.d("MOVIES_L", "fetchPopularPeople (page -> $page) CALLED")
        setState { copy(lceState = LCEContract.LCEState.OnLoading) }
        peopleInteract.execute(
            params = FetchPopularPeopleInteract.Params(page),
            onSuccess = fun(popularPeople) {
                Log.d("MOVIES_L", "onSuccess (movies size -> ${popularPeople.size}) CALLED")
                setState {
                    copy(lceState = LCEContract.LCEState.OnLoaded(page, popularPeople))
                }
            },
            onError = fun(ex) {
                Log.d("MOVIES_L", "onError ${ex.message} CALLED")
                setEffect { LCEContract.Effect.OnShowError(ex) }
            }
        )
    }
}