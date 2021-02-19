package sanchez.sanchez.sergio.feature_main.ui.person

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_main.di.component.PeopleListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.test.core.ui.SupportAdapter
import sanchez.sanchez.sergio.test.core.ui.SupportLCEFragment

/**
 * People List Fragment
 */
class PeopleListFragment : SupportLCEFragment<PersonListViewModel, Person, PeopleListAdapter.PersonViewHolder>(PersonListViewModel::class.java), PeopleListAdapter.OnPersonClickListener {

    private val component: PeopleListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getPeopleListComponent(requireActivity() as AppCompatActivity)
    }

    override fun onInject() {
        component.inject(this)
    }

    override fun onBuildAdapter(): SupportAdapter<PeopleListAdapter.PersonViewHolder, Person> =
            PeopleListAdapter(
                    context = requireContext(),
                    data = mutableListOf(),
                    personItemListener = this
            )

    /**
     * On Person Clicked
     * @param person
     * @param itemPersonProfileImageView
     */
    override fun onPersonClicked(person: Person, itemPersonProfileImageView: ImageView) {
        showPersonDetail(person.id, itemPersonProfileImageView)
    }

}