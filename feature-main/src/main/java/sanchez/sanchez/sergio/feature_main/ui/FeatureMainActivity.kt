package sanchez.sanchez.sergio.feature_main.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.ActivityFeatureMainBinding
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportActivity
import timber.log.Timber

class FeatureMainActivity : SupportActivity<ActivityFeatureMainBinding>() {

    override fun layoutId(): Int = R.layout.activity_feature_main

    override fun onAttachComponent() {
        FeatureMainComponentFactory.getFeatureMainComponent(this)
                .inject(this)
    }

    override fun onDetachComponent() {
        FeatureMainComponentFactory.removeFeatureMainComponent()
    }

    override fun navHostId(): Int = R.id.mainNavHostContainer

    override fun onSetupNavigation(savedInstanceState: Bundle?, navController: NavController) {
        with(binding) {
            NavigationUI.setupWithNavController(mainBottomNavigation, navController)
        }
    }

    override fun initializeUI() {
        Timber.d("initializeUI CALLED")
    }

}