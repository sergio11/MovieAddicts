package sanchez.sanchez.sergio.movie_addicts.feature_login.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportFragment
import sanchez.sanchez.sergio.movie_addicts.feature_login.R
import sanchez.sanchez.sergio.movie_addicts.feature_login.databinding.LoginFragmentBinding
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.factory.FeatureLoginComponentFactory
import sanchez.sanchez.sergio.movie_addicts.feature_login.ui.core.INavigatorManager
import javax.inject.Inject

/**
 * Login Fragment
 */
class LoginFragment: SupportFragment<LoginViewModel, LoginFragmentBinding>(LoginViewModel::class.java),
    FacebookCallback<LoginResult>{

    @Inject
    lateinit var callbackManager: CallbackManager

    @Inject
    lateinit var loginManager: LoginManager

    @Inject
    lateinit var navigatorManager: INavigatorManager

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
            viewModel.uiState.collect {
                with(binding) {
                    uiState = it.loginState
                    if(it.loginState is LoginContract.LoginState.OnSuccess)
                        navigatorManager.showHome()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            loginFacebookBtn.apply {
                fragment = this@LoginFragment
                setPermissions("email", "public_profile")
                loginManager.registerCallback(callbackManager, this@LoginFragment)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    override fun onSuccess(result: LoginResult?) {
        result?.accessToken?.token?.let {
            viewModel.setEvent(LoginContract.Event.SignInWithCredential(it))
        }
        loginManager.logOut()
    }

    override fun onCancel() {
        Log.d("LOGIN_FRA", "facebook:onCancel")
    }

    override fun onError(error: FacebookException?) {
        Log.d("LOGIN_FRA", "facebook:onError", error)
    }
}