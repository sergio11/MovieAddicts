package sanchez.sanchez.sergio.feature_main.ui.tv

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.feature_main.domain.model.Tv

/**
 * Tv List View Bindings
 */
object TvListViewBindings {

    /**
     * @param view
     * @param tvList
     */
    @JvmStatic
    @BindingAdapter("adapterTvList")
    fun bindAdapterTvList(view: RecyclerView, tvList: List<Any>?) {
        tvList?.let { data ->
            view.adapter?.let {
                if(it is TvListAdapter)
                    it.addData(data as List<Tv>)
            }
        }
    }
}