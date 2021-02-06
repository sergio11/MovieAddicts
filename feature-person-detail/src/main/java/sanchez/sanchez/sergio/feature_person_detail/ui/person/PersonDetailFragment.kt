package sanchez.sanchez.sergio.feature_person_detail.ui.person

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_person_detail.R
import sanchez.sanchez.sergio.feature_person_detail.databinding.PersonDetailFragmentBinding
import sanchez.sanchez.sergio.feature_person_detail.di.component.PersonDetailComponent
import sanchez.sanchez.sergio.feature_person_detail.di.factory.FeaturePersonDetailComponentFactory
import sanchez.sanchez.sergio.feature_person_detail.ui.FeaturePersonDetailActivityDelegate
import sanchez.sanchez.sergio.test.core.ui.SupportFragment
import java.lang.IllegalStateException

/**
 * Person Detail Fragment
 */
class PersonDetailFragment: SupportFragment<PersonDetailViewModel, PersonDetailFragmentBinding>(PersonDetailViewModel::class.java) {

    private val component: PersonDetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeaturePersonDetailComponentFactory.buildPersonDetailComponent(requireActivity() as AppCompatActivity)
    }

    private lateinit var activityDelegate: FeaturePersonDetailActivityDelegate

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context !is FeaturePersonDetailActivityDelegate)
            throw IllegalStateException("Parent Activity must implement a FeaturePersonDetailActivityDelegate interface")

        activityDelegate = context
    }

    override fun layoutId(): Int = R.layout.person_detail_fragment

    override fun onInject() {
        component.inject(this)
    }

    override fun onInitObservers() {
        Log.d("PERSON_DETAIL", "Person Id -> ${activityDelegate.getPersonId()}")
    }


}