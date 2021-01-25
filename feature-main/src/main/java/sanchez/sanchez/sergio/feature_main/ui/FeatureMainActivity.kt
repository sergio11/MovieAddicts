package sanchez.sanchez.sergio.feature_main.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.ActivityFeatureMainBinding
import sanchez.sanchez.sergio.feature_main.di.component.FeatureMainComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.test.core.ui.SupportActivity
import timber.log.Timber

class FeatureMainActivity : SupportActivity<ActivityFeatureMainBinding>() {

    private val featureMainComponent: FeatureMainComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getFeatureMainComponent(this)
    }

    override fun onInject() {
        featureMainComponent.inject(this)
    }

    override fun layoutId(): Int = R.layout.activity_feature_main

    override fun navHostId(): Int = R.id.mainNavHostContainer

    override fun onSetupNavigation(savedInstanceState: Bundle?, navController: NavController) {
        Timber.d("onSetupNavigation CALLED")
        with(binding) {
            Timber.d("setupWithNavController CALLED")
            NavigationUI.setupWithNavController(mainBottomNavigation, navController)
        }
    }

    override fun initializeUI() {
        Timber.d("initializeUI CALLED")
    }
}