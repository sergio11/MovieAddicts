package sanchez.sanchez.sergio.feature_main.ui.person

import android.content.Context
import android.view.View
import android.view.ViewGroup
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.ui.core.SupportAdapter

/**
 * Person List Adapter
 * @param context
 * @param data
 * @param personItemListener
 */
class PersonListAdapter(
        context: Context,
        data: MutableList<Person>,
        private val personItemListener: OnPersonClickListener,
): SupportAdapter<PersonListAdapter.PersonViewHolder, Person>(context, data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
            PersonViewHolder(inflateLayout(R.layout.person_item_layout, parent))

    /**
     * Person Click Listener
     */
    interface OnPersonClickListener {

        /**
         * on Person Clicked
         * @param person
         */
        fun onPersonClicked(person: Person)
    }

    /**
     * Person View Holder
     * @param itemView
     */
    inner class PersonViewHolder(itemView: View): SupportViewHolder<Person>(itemView) {
        override fun bind(model: Person) {
            itemView.setOnClickListener {
                personItemListener.onPersonClicked(model)
            }
        }
    }
}