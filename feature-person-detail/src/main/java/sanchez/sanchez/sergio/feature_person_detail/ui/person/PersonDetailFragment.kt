package sanchez.sanchez.sergio.feature_person_detail.ui.person

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_person_detail.R
import sanchez.sanchez.sergio.feature_person_detail.databinding.PersonDetailFragmentBinding
import sanchez.sanchez.sergio.feature_person_detail.di.factory.FeaturePersonDetailComponentFactory
import sanchez.sanchez.sergio.feature_person_detail.ui.FeaturePersonDetailActivity
import sanchez.sanchez.sergio.feature_person_detail.ui.FeaturePersonDetailActivityDelegate
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportFragment
import java.lang.IllegalStateException

/**
 * Person Detail Fragment
 */
class PersonDetailFragment: SupportFragment<PersonDetailViewModel, PersonDetailFragmentBinding>(PersonDetailViewModel::class.java) {

    private lateinit var activityDelegate: FeaturePersonDetailActivityDelegate

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context !is FeaturePersonDetailActivityDelegate)
            throw IllegalStateException("Parent Activity must implement a FeaturePersonDetailActivityDelegate interface")

        activityDelegate = context
    }

    override fun layoutId(): Int = R.layout.person_detail_fragment

    override fun onAttachComponent() {
        FeaturePersonDetailComponentFactory.getPersonDetailComponent(requireActivity() as AppCompatActivity)
                .inject(this)
    }

    override fun onDetachComponent() {
        FeaturePersonDetailComponentFactory.removePersonDetailComponent()
    }

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                with(binding) {
                    activity = requireActivity() as FeaturePersonDetailActivity
                    person = if(state.personState is PersonDetailContract.PersonState.OnLoaded)
                        state.personState.personDetail
                    else
                        null
                }
            }
            viewModel.effect.collect {
                if(it is PersonDetailContract.Effect.OnShowError)
                    Snackbar.make(requireView(), it.ex.message ?: "An error occurred, please try again", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setEvent(PersonDetailContract.Event.FetchPersonDetail(activityDelegate.getPersonId()))
    }

}