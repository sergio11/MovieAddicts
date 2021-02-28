package sanchez.sanchez.sergio.feature_main.di.factory

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_main.di.component.*
import sanchez.sanchez.sergio.movie_addicts.core.SupportApp
import sanchez.sanchez.sergio.movie_addicts.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ActivityModule

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
     * Remove Feature Main Component
     */
    fun removeFeatureMainComponent() {
        featureMainComponent = null
        movieListComponent = null
        peopleListComponent = null
        tvListComponent = null
    }

    /**
     * Get Movie List Component
     */
    fun getMovieListComponent(activity: AppCompatActivity): MovieListComponent =
        movieListComponent ?: getFeatureMainComponent(activity).movieListComponent().also {
            movieListComponent = it
        }

    /**
     * Remove Movie List Component
     */
    fun removeMovieListComponent() {
        movieListComponent = null
    }

    /**
     * Get People List Component
     */
    fun getPeopleListComponent(activity: AppCompatActivity): PeopleListComponent =
        peopleListComponent ?: getFeatureMainComponent(activity).peopleListComponent().also {
            peopleListComponent = it
        }

    /**
     * Remove People List Component
     */
    fun removePeopleListComponent() {
        peopleListComponent = null
    }

    /**
     * Get Person List Component
     */
    fun getTvListComponent(activity: AppCompatActivity): TvListComponent =
        tvListComponent ?: getFeatureMainComponent(activity).tvListComponent().also {
            tvListComponent = it
        }

    fun removeTvListComponent() {
        tvListComponent = null
    }

}