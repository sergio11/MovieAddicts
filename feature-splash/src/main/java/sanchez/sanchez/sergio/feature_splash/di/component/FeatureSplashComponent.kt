package sanchez.sanchez.sergio.feature_splash.di.component

import dagger.Component
import sanchez.sanchez.sergio.movie_addicts.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ActivityModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity
import sanchez.sanchez.sergio.feature_splash.di.module.FeatureSplashModule
import sanchez.sanchez.sergio.feature_splash.ui.FeatureSplashActivity

/**
 * Feature Splash Component
 */
@PerActivity
@Component(
    modules = [
        ActivityModule::class,
        ViewModelModule::class,
        FeatureSplashModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FeatureSplashComponent {

    /**
     * Sub-components
     */
    fun splashComponent(): SplashComponent

    /**
     * Inject into Feature Splash Activity
     */
    fun inject(featureSplashActivity: FeatureSplashActivity)
}