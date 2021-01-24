package sanchez.sanchez.sergio.feature_main.di.factory

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_main.di.component.*
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule

object FeatureMainComponentFactory {

    private var featureMainComponent: FeatureMainComponent? = null
    private var movieListComponent: MovieListComponent? = null
    private var personListComponent: PersonListComponent? = null
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
     * Get Person List Component
     */
    fun getPersonListComponent(activity: AppCompatActivity): PersonListComponent =
        personListComponent ?: getFeatureMainComponent(activity).personListComponent().also {
            personListComponent = it
        }

    /**
     * Get Person List Component
     */
    fun getTvListComponent(activity: AppCompatActivity): TvListComponent =
        tvListComponent ?: getFeatureMainComponent(activity).tvListComponent().also {
            tvListComponent = it
        }

}