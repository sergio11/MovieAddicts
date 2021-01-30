package sanchez.sanchez.sergio.feature_main.ui.person

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.FragmentPersonListBinding
import sanchez.sanchez.sergio.feature_main.di.component.PersonListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.test.core.ui.SupportFragment

class PersonListFragment : SupportFragment<PersonListViewModel, FragmentPersonListBinding>(PersonListViewModel::class.java) {

    private val component: PersonListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getPersonListComponent(requireActivity() as AppCompatActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_person_list

    override fun onInject() {
        component.inject(this)
    }

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {

            }
        }
    }


}