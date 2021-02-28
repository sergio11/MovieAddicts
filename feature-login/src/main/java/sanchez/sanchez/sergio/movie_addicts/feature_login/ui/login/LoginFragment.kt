package sanchez.sanchez.sergio.movie_addicts.feature_login.ui.login

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportFragment
import sanchez.sanchez.sergio.movie_addicts.feature_login.R
import sanchez.sanchez.sergio.movie_addicts.feature_login.databinding.LoginFragmentBinding
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.factory.FeatureLoginComponentFactory

/**
 * Login Fragment
 */
class LoginFragment: SupportFragment<LoginViewModel, LoginFragmentBinding>(LoginViewModel::class.java) {

    override fun onAttachComponent() {
        FeatureLoginComponentFactory.getLoginComponent(requireActivity() as AppCompatActivity)
            .inject(this)
    }

    override fun onDetachComponent() {
        FeatureLoginComponentFactory.removeLoginComponent()
    }

    override fun layoutId(): Int = R.layout.login_fragment

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {


        }
    }
}