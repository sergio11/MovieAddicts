package sanchez.sanchez.sergio.feature_main.ui.person

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.feature_main.domain.model.Person

/**
 * Person List View Bindings
 */
object PersonListViewBindings {

    /**
     * @param view
     * @param personList
     */
    @JvmStatic
    @BindingAdapter("adapterPersonList")
    fun bindAdapterMovieList(view: RecyclerView, personList: List<Person>) {
        view.adapter?.let {
            if(it is PersonListAdapter)
                it.addData(personList)
        }
    }
}