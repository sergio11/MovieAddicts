package sanchez.sanchez.sergio.feature_main.ui.core.binding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import sanchez.sanchez.sergio.feature_main.ui.core.LCEContract

object SupportBindings {

    @JvmStatic
    @BindingAdapter("bindSwipeRefreshState")
    fun bindSwipeRefreshState(view: SwipeRefreshLayout, lceState: LCEContract.LCEState) {
        view.isRefreshing = lceState is LCEContract.LCEState.OnLoading
    }
}