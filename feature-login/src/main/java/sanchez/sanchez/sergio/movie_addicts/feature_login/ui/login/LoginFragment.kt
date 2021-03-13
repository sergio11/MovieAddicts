package sanchez.sanchez.sergio.movie_addicts.feature_login.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.AuthTypeEnum
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
    @Inject
    lateinit var googleSignInClient: GoogleSignInClient

    private val googleLoginActivityResult = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result?.data?.let {
                onGoogleSignInSuccess(it)
            }
        }
    }

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
            viewModel.effect.collect {
                if(it is LoginContract.Effect.OnShowError)
                    Snackbar.make(requireView(), it.ex.message ?: "An error occurred, please try again", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        binding.screenBackground.resume()
    }

    override fun onStop() {
        super.onStop()
        binding.screenBackground.pause()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {

            containerBlurView.setupWith(container)
                .setFrameClearDrawable(container.background)
                .setBlurAlgorithm(RenderScriptBlur(requireContext()))
                .setBlurRadius(8.0f)
                .setHasFixedTransformationMatrix(true)

            loginFacebookBtn.apply {
                fragment = this@LoginFragment
                setPermissions("email", "public_profile")
                loginManager.registerCallback(callbackManager, this@LoginFragment)
            }

            loginGoogleBtn.apply {
                setSize(SignInButton.SIZE_STANDARD)
                setOnClickListener {
                    onLaunchGoogleSignIn()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    override fun onSuccess(result: LoginResult?) {
        result?.accessToken?.token?.let {
            viewModel.setEvent(LoginContract.Event.SignInWithToken(
                accessToken = it,
                authType = AuthTypeEnum.FACEBOOK
            ))
        }
        loginManager.logOut()
    }

    override fun onCancel() {
        Log.d("LOGIN_FRA", "facebook:onCancel")
    }

    override fun onError(error: FacebookException?) {
        Log.d("LOGIN_FRA", "facebook:onError", error)
    }

    /**
     * Private Methods
     */

    private fun onLaunchGoogleSignIn() {
        googleLoginActivityResult.launch(googleSignInClient.signInIntent)
    }

    private fun onGoogleSignInSuccess(intent: Intent) {
        try {
            val completedTask = GoogleSignIn.getSignedInAccountFromIntent(intent)
            val account = completedTask.getResult(ApiException::class.java)
            Log.d("LOGIN_FRA", "Signed in successfully, show authenticated UI.")
            account?.idToken?.let {
                viewModel.setEvent(LoginContract.Event.SignInWithToken(
                    accessToken = it,
                    authType = AuthTypeEnum.GOOGLE
                ))
            }
        } catch (e: ApiException) {
            Log.d("LOGIN_FRA", "signInResult:failed code=${e.statusCode}")
        }
        googleSignInClient.signOut()
    }

}