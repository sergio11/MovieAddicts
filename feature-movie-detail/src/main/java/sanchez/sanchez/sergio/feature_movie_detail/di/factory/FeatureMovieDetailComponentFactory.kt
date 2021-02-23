package sanchez.sanchez.sergio.feature_movie_detail.di.factory

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_movie_detail.di.component.DaggerFeatureMovieDetailComponent
import sanchez.sanchez.sergio.feature_movie_detail.di.component.FeatureMovieDetailComponent
import sanchez.sanchez.sergio.feature_movie_detail.di.component.MovieDetailComponent
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule

object FeatureMovieDetailComponentFactory {

    private var featureMovieDetailComponent: FeatureMovieDetailComponent? = null
    private var movieDetailComponent: MovieDetailComponent? = null

    /**
     * Get Feature Movie Detail Component
     * @param activity
     */
    fun getFeatureMovieDetailComponent(activity: AppCompatActivity): FeatureMovieDetailComponent =
        featureMovieDetailComponent ?: DaggerFeatureMovieDetailComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).activityModule(ActivityModule(activity)).build().also {
                featureMovieDetailComponent = it
            }

    /**
     * Remove Feature Movie Detail Component
     */
    fun removeFeatureMovieDetailComponent() {
        featureMovieDetailComponent = null
        movieDetailComponent = null
    }

    /**
     * Get Movie Detail Component
     * @param activity
     */
    fun getMovieDetailComponent(activity: AppCompatActivity): MovieDetailComponent =
            movieDetailComponent ?: getFeatureMovieDetailComponent(activity).movieDetailComponent().also {
                movieDetailComponent = it
            }

    fun removeMovieDetailComponent() {
        movieDetailComponent = null
    }
}