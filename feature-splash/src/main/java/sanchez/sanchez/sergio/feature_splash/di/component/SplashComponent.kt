package sanchez.sanchez.sergio.feature_splash.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.test.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment
import sanchez.sanchez.sergio.feature_splash.di.module.splash.SplashViewModelModule
import sanchez.sanchez.sergio.feature_splash.ui.splash.SplashFragment

/**
 * Splash Component
 */
@PerFragment
@Subcomponent(modules = [ SplashViewModelModule::class ])
interface SplashComponent: FragmentComponent {

    /**
     * Inject into Splash Fragment
     */
    fun inject(splashFragment: SplashFragment)
}