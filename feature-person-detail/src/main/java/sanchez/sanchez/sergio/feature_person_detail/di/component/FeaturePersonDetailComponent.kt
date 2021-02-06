package sanchez.sanchez.sergio.feature_person_detail.di.component

import dagger.Component
import sanchez.sanchez.sergio.feature_person_detail.di.module.FeatureMovieDetailModule
import sanchez.sanchez.sergio.feature_person_detail.ui.FeaturePersonDetailActivity
import sanchez.sanchez.sergio.test.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.scope.PerActivity

@PerActivity
@Component(
    modules = [
        ActivityModule::class,
        ViewModelModule::class,
        FeatureMovieDetailModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FeaturePersonDetailComponent {

    /**
     * Sub components
     */

    fun personDetailComponent(): PersonDetailComponent


    /**
     * Inject into Feature Person Detail Activity
     */
    fun inject(featurePersonDetailActivityActivity: FeaturePersonDetailActivity)

}