package sanchez.sanchez.sergio.feature_movie_detail.di.component

import dagger.Component
import sanchez.sanchez.sergio.feature_movie_detail.di.module.FeatureMovieDetailModule
import sanchez.sanchez.sergio.feature_movie_detail.ui.FeatureMovieDetailActivity
import sanchez.sanchez.sergio.test.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.scope.PerActivity

/**
 * Feature Movie Detail Component
 */
@PerActivity
@Component(
    modules = [
        ActivityModule::class,
        ViewModelModule::class,
        FeatureMovieDetailModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FeatureMovieDetailComponent {

    /**
     * Sub-components
     */
    fun movieDetailComponent(): MovieDetailComponent

    /**
     * Inject into Feature Movie Detail Activity
     */
    fun inject(featureMovieDetailActivityActivity: FeatureMovieDetailActivity)

}