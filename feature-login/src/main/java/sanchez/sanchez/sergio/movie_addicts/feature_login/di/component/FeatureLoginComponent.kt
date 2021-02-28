package sanchez.sanchez.sergio.movie_addicts.feature_login.di.component

import dagger.Component
import sanchez.sanchez.sergio.movie_addicts.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ActivityModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.FeatureLoginModule
import sanchez.sanchez.sergio.movie_addicts.feature_login.ui.FeatureLoginActivity

/**
 * Feature Login Component
 */
@PerActivity
@Component(
    modules = [
        ActivityModule::class,
        ViewModelModule::class,
        FeatureLoginModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FeatureLoginComponent {

    /**
     * Sub-components
     */
    fun loginComponent(): LoginComponent

    /**
     * Inject into Feature Login Activity
     */
    fun inject(featureLoginActivity: FeatureLoginActivity)

}