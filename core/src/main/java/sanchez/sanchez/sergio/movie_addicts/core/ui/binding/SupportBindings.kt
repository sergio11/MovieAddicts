package sanchez.sanchez.sergio.movie_addicts.core.ui.binding

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.appbar.MaterialToolbar
import sanchez.sanchez.sergio.movie_addicts.core.extension.applyToolbarMargin
import sanchez.sanchez.sergio.movie_addicts.core.extension.simpleToolbarWithHome
import sanchez.sanchez.sergio.movie_addicts.core.extension.visible
import sanchez.sanchez.sergio.movie_addicts.core.ui.LCEContract
import sanchez.sanchez.sergio.movie_addicts.core.ui.LCEContract.LCEState.OnError




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

    @JvmStatic
    @BindingAdapter("bindVisibilityByState")
    fun bindVisibilityByState(view: RecyclerView, lceState: LCEContract.LCEState) {
        view.visibility = if (lceState is LCEContract.LCEState.OnLoaded<*>) View.VISIBLE else View.GONE
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