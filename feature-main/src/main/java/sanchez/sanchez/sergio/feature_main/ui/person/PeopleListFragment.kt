package sanchez.sanchez.sergio.feature_main.ui.person

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.FragmentPeopleListBinding
import sanchez.sanchez.sergio.feature_main.di.component.PeopleListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.test.core.ui.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportFragment

/**
 * People List Fragment
 */
class PeopleListFragment : SupportFragment<PersonListViewModel, FragmentPeopleListBinding>(PersonListViewModel::class.java), PeopleListAdapter.OnPersonClickListener {

    private val component: PeopleListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getPeopleListComponent(requireActivity() as AppCompatActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_people_list

    override fun onInject() {
        component.inject(this)
    }

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {
                with(binding) {
                    uiState = it.lceState
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            adapter = PeopleListAdapter(
                    context = requireContext(),
                    data = mutableListOf(),
                    personItemListener = this@PeopleListFragment
            )
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.setEvent(LCEContract.Event.OnFetchData())
            }
        }

        viewModel.setEvent(LCEContract.Event.OnFetchData())
    }

    /**
     * On Person Clicked
     * @param person
     */
    override fun onPersonClicked(person: Person) {
        showPersonDetail(person.id)
    }

}