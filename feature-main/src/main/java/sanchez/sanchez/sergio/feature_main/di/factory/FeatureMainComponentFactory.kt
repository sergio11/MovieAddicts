package sanchez.sanchez.sergio.feature_main.di.factory

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_main.di.component.*
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule

object FeatureMainComponentFactory {

    private var featureMainComponent: FeatureMainComponent? = null
    private var movieListComponent: MovieListComponent? = null
    private var peopleListComponent: PeopleListComponent? = null
    private var tvListComponent: TvListComponent? = null

    /**
     * Get Feature Main Component
     * @param activity
     */
    fun getFeatureMainComponent(activity: AppCompatActivity): FeatureMainComponent =
        featureMainComponent ?: DaggerFeatureMainComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).activityModule(ActivityModule(activity)).build().also {
                featureMainComponent = it
            }

    /**
     * Get Movie List Component
     */
    fun getMovieListComponent(activity: AppCompatActivity): MovieListComponent =
        movieListComponent ?: getFeatureMainComponent(activity).movieListComponent().also {
            movieListComponent = it
        }

    /**
     * Get People List Component
     */
    fun getPeopleListComponent(activity: AppCompatActivity): PeopleListComponent =
        peopleListComponent ?: getFeatureMainComponent(activity).peopleListComponent().also {
            peopleListComponent = it
        }

    /**
     * Get Person List Component
     */
    fun getTvListComponent(activity: AppCompatActivity): TvListComponent =
        tvListComponent ?: getFeatureMainComponent(activity).tvListComponent().also {
            tvListComponent = it
        }

}