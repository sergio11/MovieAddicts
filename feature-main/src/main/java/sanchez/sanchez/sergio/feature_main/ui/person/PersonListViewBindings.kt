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
    fun bindAdapterPersonList(view: RecyclerView, personList: List<Any>?) {
        personList?.let { data ->
            view.adapter?.let {
                if(it is PeopleListAdapter)
                    it.addData(data as List<Person>)
            }
        }

    }
}