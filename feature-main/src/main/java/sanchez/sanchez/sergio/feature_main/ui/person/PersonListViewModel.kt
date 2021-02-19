package sanchez.sanchez.sergio.feature_main.ui.person

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_main.domain.usecase.FetchPopularPeopleInteract
import sanchez.sanchez.sergio.test.core.ui.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportLCEViewModel
import javax.inject.Inject

/**
 * Person List View Model
 */
class PersonListViewModel @Inject constructor(
    private val peopleInteract: FetchPopularPeopleInteract
): SupportLCEViewModel() {

    /**
     * Fetch Popular People
     * @param page
     */
    override fun onFetchData(page: Int) {
        viewModelScope.launch {
            setState { copy(lceState = LCEContract.LCEState.OnLoading) }
            peopleInteract.execute(
                    params = FetchPopularPeopleInteract.Params(page),
                    onSuccess = fun(popularPeople) {
                        Log.d("PERSON_L", "onSuccess (people size -> ${popularPeople.size}) CALLED")
                        setState {
                            copy(lceState = LCEContract.LCEState.OnLoaded(page, popularPeople))
                        }
                    },
                    onError = fun(ex) {
                        Log.d("PERSON_L", "onError ${ex.message} CALLED")
                        setEffect { LCEContract.Effect.OnShowError(ex) }
                    }
            )
        }
    }
}