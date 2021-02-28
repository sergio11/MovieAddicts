package sanchez.sanchez.sergio.feature_tv_detail.di.component

import dagger.Component
import sanchez.sanchez.sergio.feature_tv_detail.di.module.FeatureTvDetailModule
import sanchez.sanchez.sergio.feature_tv_detail.ui.FeatureTvDetailActivity
import sanchez.sanchez.sergio.movie_addicts.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ActivityModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity

@PerActivity
@Component(
    modules = [
        ActivityModule::class,
        ViewModelModule::class,
        FeatureTvDetailModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FeatureTvDetailComponent {

    /**
     * Sub components
     */

    fun tvDetailComponent(): TvDetailComponent


    /**
     * Inject into Feature Tv Detail Activity
     */
    fun inject(featureTvDetailActivity: FeatureTvDetailActivity)

}