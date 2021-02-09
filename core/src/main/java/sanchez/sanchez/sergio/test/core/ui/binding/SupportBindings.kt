package sanchez.sanchez.sergio.test.core.ui.binding

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.appbar.MaterialToolbar
import sanchez.sanchez.sergio.test.core.extension.applyToolbarMargin
import sanchez.sanchez.sergio.test.core.extension.simpleToolbarWithHome
import sanchez.sanchez.sergio.test.core.ui.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportAdapter

object SupportBindings {

    @JvmStatic
    @BindingAdapter("bindSwipeRefreshState")
    fun bindSwipeRefreshState(view: SwipeRefreshLayout, lceState: LCEContract.LCEState) {
        view.isRefreshing = lceState is LCEContract.LCEState.OnLoading
    }

    @JvmStatic
    @BindingAdapter("bindToolbarWithActivity", "bindToolbarWithTitle")
    fun bindToolbarWithTitle(toolbar: MaterialToolbar, activity: AppCompatActivity, title: String) {
        activity.apply {
            simpleToolbarWithHome(toolbar, title)
            applyToolbarMargin(toolbar)
        }
    }
}