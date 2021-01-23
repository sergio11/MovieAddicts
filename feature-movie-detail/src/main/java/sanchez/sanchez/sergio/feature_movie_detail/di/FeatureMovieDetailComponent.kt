package sanchez.sanchez.sergio.feature_movie_detail.di

import dagger.Component
import sanchez.sanchez.sergio.feature_movie_detail.ui.FeatureMovieDetailActivity

import sanchez.sanchez.sergio.test.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.scope.PerActivity

@PerActivity
@Component(
    modules = [
        ViewModelModule::class,
        FeatureMovieDetailModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FeatureMovieDetailComponent {

    /**
     * Inject into Feature Movie Detail Activity
     */
    fun inject(featureMovieDetailActivityActivity: FeatureMovieDetailActivity)

}