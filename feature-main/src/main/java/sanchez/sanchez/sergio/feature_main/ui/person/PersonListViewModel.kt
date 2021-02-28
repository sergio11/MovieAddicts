package sanchez.sanchez.sergio.feature_main.ui.person

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_main.domain.usecase.FetchPopularPeopleInteract
import sanchez.sanchez.sergio.movie_addicts.core.ui.LCEContract
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportLCEViewModel
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
    override fun onFetchData(page: Long) {
        viewModelScope.launch {
            setState { copy(lceState = LCEContract.LCEState.OnLoading) }
            peopleInteract.execute(
                    params = FetchPopularPeopleInteract.Params(page),
                    onSuccess = fun(pageData) {
                        Log.d("PERSON_L", "onSuccess (people size -> ${pageData.data.size}) CALLED")
                        setState {
                            copy(lceState = LCEContract.LCEState.OnLoaded(pageData))
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