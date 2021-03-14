package sanchez.sanchez.sergio.feature_person_detail.ui.person

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_person_detail.R
import sanchez.sanchez.sergio.feature_person_detail.databinding.PersonDetailFragmentBinding
import sanchez.sanchez.sergio.feature_person_detail.di.factory.FeaturePersonDetailComponentFactory
import sanchez.sanchez.sergio.feature_person_detail.ui.FeaturePersonDetailActivity
import sanchez.sanchez.sergio.feature_person_detail.ui.FeaturePersonDetailActivityDelegate
import sanchez.sanchez.sergio.movie_addicts.core.extension.gone
import sanchez.sanchez.sergio.movie_addicts.core.extension.visible
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportFragment
import java.lang.IllegalStateException
import kotlin.math.abs

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
                    uiState = state.personState
                    activity = requireActivity() as FeaturePersonDetailActivity
                    person = if(state.personState is PersonDetailContract.PersonState.OnLoaded)
                        state.personState.personDetail
                    else
                        null
                }
            }

        }

        lifecycleScope.launchWhenStarted {
            viewModel.effect.collect {
                if(it is PersonDetailContract.Effect.OnShowError)
                    Snackbar.make(requireView(), getString(R.string.common_error), Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setEvent(PersonDetailContract.Event.FetchPersonDetail(activityDelegate.getPersonId()))
        configureHomeAsUpIndicatorWithColor(android.R.color.black)
    }


    /**
     * Private Methods
     */

    private fun configureHomeAsUpIndicatorWithColor(color: Int) {
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_arrow_back_24)?.let {
            DrawableCompat.setTint(it, requireContext().getColor(color))
            parentActivity.supportActionBar?.setHomeAsUpIndicator(it)
        }
    }
}