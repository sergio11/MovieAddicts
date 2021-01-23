package sanchez.sanchez.sergio.feature_main.di

import dagger.Component
import sanchez.sanchez.sergio.feature_main.ui.FeatureMainActivity
import sanchez.sanchez.sergio.test.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.scope.PerActivity

@PerActivity
@Component(
    modules = [
        ActivityModule::class,
        ViewModelModule::class,
        FeatureMainModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FeatureMainComponent {

    /**
     * Inject into Feature One Activity
     */
    fun inject(featureOneActivity: FeatureMainActivity)

}