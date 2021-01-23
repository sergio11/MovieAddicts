package sanchez.sanchez.sergio.feature_main.ui

import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.ActivityFeatureMainBinding
import sanchez.sanchez.sergio.feature_main.di.FeatureMainComponent
import sanchez.sanchez.sergio.feature_main.di.FeatureMainComponentFactory
import sanchez.sanchez.sergio.test.core.ui.SupportActivity
import timber.log.Timber

class FeatureMainActivity : SupportActivity<ActivityFeatureMainBinding>() {

    private val featureMainComponent: FeatureMainComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getFeatureMainComponent(this)
    }

    override fun onInject() {
        featureMainComponent.inject(this)
    }

    override fun initializeUI() {
        Timber.d("initializeUI CALLED")
    }

    override fun layoutId(): Int = R.layout.activity_feature_main
}