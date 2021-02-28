package sanchez.sanchez.sergio.feature_main.di.component

import dagger.Component
import sanchez.sanchez.sergio.feature_main.di.module.FeatureMainModule
import sanchez.sanchez.sergio.feature_main.ui.FeatureMainActivity
import sanchez.sanchez.sergio.movie_addicts.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ActivityModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity

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
     * Sub-components
     */

    fun movieListComponent(): MovieListComponent
    fun peopleListComponent(): PeopleListComponent
    fun tvListComponent(): TvListComponent

    /**
     * Inject into Feature Main Activity
     */
    fun inject(featureMainActivity: FeatureMainActivity)

}