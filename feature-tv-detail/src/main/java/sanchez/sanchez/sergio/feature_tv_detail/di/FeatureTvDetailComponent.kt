package sanchez.sanchez.sergio.feature_tv_detail.di

import dagger.Component
import sanchez.sanchez.sergio.feature_tv_detail.ui.FeatureTvDetailActivity
import sanchez.sanchez.sergio.test.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.scope.PerActivity

@PerActivity
@Component(
    modules = [
        ViewModelModule::class,
        FeatureTvDetailModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FeatureTvDetailComponent {

    /**
     * Inject into Feature Tv Detail Activity
     */
    fun inject(featureTvDetailActivity: FeatureTvDetailActivity)

}