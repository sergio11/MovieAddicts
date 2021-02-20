package sanchez.sanchez.sergio.feature_splash.di.module.splash

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.module.viewmodel.ViewModelKey
import sanchez.sanchez.sergio.feature_splash.ui.splash.SplashViewModel

/**
 * Splash View ModelModule
 */
@Module(includes = [ ViewModelModule::class ])
abstract class SplashViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindsSplashViewModel(viewModel: SplashViewModel): ViewModel
}