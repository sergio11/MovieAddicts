package sanchez.sanchez.sergio.feature_person_detail.ui

import android.view.MenuItem
import sanchez.sanchez.sergio.feature_person_detail.R
import sanchez.sanchez.sergio.feature_person_detail.databinding.ActivityFeaturePersonDetailBinding
import sanchez.sanchez.sergio.feature_person_detail.di.component.FeaturePersonDetailComponent
import sanchez.sanchez.sergio.feature_person_detail.di.factory.FeaturePersonDetailComponentFactory
import sanchez.sanchez.sergio.test.core.ui.SupportActivity
import java.lang.IllegalStateException

class FeaturePersonDetailActivity : SupportActivity<ActivityFeaturePersonDetailBinding>(),
        FeaturePersonDetailActivityDelegate {

    private val component: FeaturePersonDetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeaturePersonDetailComponentFactory.buildFeaturePersonDetailComponent(this)
    }

    override fun onInject() {
        component.inject(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return false
    }

    override fun layoutId(): Int = R.layout.activity_feature_person_detail

    override fun initializeUI() {
        if(!intent.hasExtra(PERSON_ID_ARG_NAME))
            throw IllegalStateException("You must provide a Person Id")
    }

    /**
     * Delegate
     */
    override fun getPersonId(): Long =
            intent.getLongExtra(PERSON_ID_ARG_NAME, -1)

    companion object {
        private const val PERSON_ID_ARG_NAME = "PERSON_ID"
    }
}