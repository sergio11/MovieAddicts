package sanchez.sanchez.sergio.test.core.ui.binding

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.appbar.MaterialToolbar
import sanchez.sanchez.sergio.test.core.extension.applyToolbarMargin
import sanchez.sanchez.sergio.test.core.extension.simpleToolbarWithHome
import sanchez.sanchez.sergio.test.core.extension.visible
import sanchez.sanchez.sergio.test.core.ui.LCEContract

object SupportBindings {

    /**
     * Bind Swipe Refresh State
     * @param view
     * @param lceState
     */
    @JvmStatic
    @BindingAdapter("bindSwipeRefreshState")
    fun bindSwipeRefreshState(view: SwipeRefreshLayout, lceState: LCEContract.LCEState) {
        view.isRefreshing = lceState is LCEContract.LCEState.OnLoading
    }

    /**
     * Bind Toolbar with Title
     * @param toolbar
     * @param activity
     * @param title
     */
    @JvmStatic
    @BindingAdapter("bindToolbarWithActivity", "bindToolbarWithTitle")
    fun bindToolbarWithTitle(toolbar: MaterialToolbar, activity: AppCompatActivity, title: String) {
        activity.apply {
            simpleToolbarWithHome(toolbar, title)
            applyToolbarMargin(toolbar)
        }
    }

    /**
     * Bind Visibility By List State
     * @param view
     * @param anyList
     */
    @JvmStatic
    @BindingAdapter("bindVisibilityByListState")
    fun bindVisibilityByListState(view: View, anyList: List<Any>?) {
        if(!anyList.isNullOrEmpty())
            view.visible()
    }
}