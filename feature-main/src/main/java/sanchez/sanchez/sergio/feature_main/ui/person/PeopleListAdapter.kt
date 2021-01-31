package sanchez.sanchez.sergio.feature_main.ui.person

import android.content.Context
import android.view.ViewGroup
import sanchez.sanchez.sergio.feature_main.databinding.PersonItemLayoutBinding
import sanchez.sanchez.sergio.feature_main.databinding.PersonItemLayoutBindingImpl
import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.ui.core.SupportAdapter

/**
 * People List Adapter
 * @param context
 * @param data
 * @param personItemListener
 */
class PeopleListAdapter(
        context: Context,
        data: MutableList<Person>,
        private val personItemListener: OnPersonClickListener,
): SupportAdapter<PeopleListAdapter.PersonViewHolder, Person>(context, data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
            PersonViewHolder(PersonItemLayoutBindingImpl.inflate(inflater, parent, false))

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
     * @param binding
     */
    inner class PersonViewHolder(val binding: PersonItemLayoutBinding): SupportViewHolder<Person>(binding.root) {
        override fun bind(model: Person) {
            with(binding) {
                person = model
                personListener = personItemListener
            }
        }
    }
}