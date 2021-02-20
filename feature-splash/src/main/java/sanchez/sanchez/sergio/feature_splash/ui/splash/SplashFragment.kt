package sanchez.sanchez.sergio.feature_splash.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.test.core.ui.SupportFragment
import sanchez.sanchez.sergio.feature_splash.R
import sanchez.sanchez.sergio.feature_splash.databinding.FragmentSplashBinding
import sanchez.sanchez.sergio.feature_splash.di.component.SplashComponent
import sanchez.sanchez.sergio.feature_splash.di.factory.FeatureSplashComponentFactory

/**
 * Splash Fragment
 */
class SplashFragment: SupportFragment<SplashViewModel, FragmentSplashBinding>(SplashViewModel::class.java) {

    private val component: SplashComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureSplashComponentFactory.buildSplashComponent(requireActivity() as AppCompatActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_splash

    override fun onInject() {
        component.inject(this)
    }

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                if(state.sessionState is SplashContract.SessionState.OnLoaded)
                    showHome()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.setEvent(SplashContract.Event.LoadSession)
        }, 5000)
    }
}