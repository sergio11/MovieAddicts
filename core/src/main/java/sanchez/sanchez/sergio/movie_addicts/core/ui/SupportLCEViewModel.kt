package sanchez.sanchez.sergio.movie_addicts.core.ui

import android.util.Log

/**
 * Support LCE View Model
 */
abstract class SupportLCEViewModel: SupportViewModel<LCEContract.Event, LCEContract.State, LCEContract.Effect>(){

    override fun createInitialState(): LCEContract.State =
            LCEContract.State(
                    LCEContract.LCEState.OnIdle
            )

    override fun handleEvent(event: LCEContract.Event) {
        when(event) {
            is LCEContract.Event.OnLoadInitialData -> onFetchData()
            is LCEContract.Event.OnLoadNextPage -> {
                val lceState = currentState.lceState
                if(lceState is LCEContract.LCEState.OnLoaded<*>) {
                    Log.d("ADAPTER", "onFetchData(${lceState.pageData.page + 1}) CALLED")
                    onFetchData(lceState.pageData.page + 1)
                } else {
                    Log.d("ADAPTER", "onFetchData CALLED")
                    onFetchData()
                }
            }
        }
    }

    fun isLoading() = currentState.lceState is LCEContract.LCEState.OnLoading

    fun isIdle() = currentState.lceState is LCEContract.LCEState.OnIdle

    fun isLastPage() = currentState.lceState.let { state ->
        state is LCEContract.LCEState.OnLoaded<*> &&
                state.pageData.isLast
    }

    /**
     * abstract methods
     */

    /**
     * On Fetch Data
     * @param page
     */
    protected abstract fun onFetchData(page: Long = 1)


}