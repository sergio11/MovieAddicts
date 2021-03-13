package sanchez.sanchez.sergio.feature_main.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.ActivityFeatureMainBinding
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.ui.core.INavigatorManager
import sanchez.sanchez.sergio.movie_addicts.core.auth.IAuthManager
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportActivity
import timber.log.Timber
import javax.inject.Inject

class FeatureMainActivity : SupportActivity<ActivityFeatureMainBinding>() {

    @Inject
    lateinit var navigationManager: INavigatorManager

    @Inject
    lateinit var authManager: IAuthManager

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
        setSupportActionBar(binding.toolbar)
        Timber.d("initializeUI CALLED")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.closeSession -> {
                onCloseSession()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    /**
     * Private Methods
     */

    private fun onCloseSession() {
        lifecycleScope.launch {
            authManager.closeSession()
        }
        navigationManager.showLogin()
    }
}