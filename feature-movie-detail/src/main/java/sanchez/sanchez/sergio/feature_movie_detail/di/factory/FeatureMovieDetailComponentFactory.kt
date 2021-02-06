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
     * Build Feature Movie Detail Component
     * @param activity
     */
    fun buildFeatureMovieDetailComponent(activity: AppCompatActivity): FeatureMovieDetailComponent =
        featureMovieDetailComponent ?: DaggerFeatureMovieDetailComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).activityModule(ActivityModule(activity)).build().also {
                featureMovieDetailComponent = it
            }

    /**
     * Build Movie Detail Component
     * @param activity
     */
    fun buildMovieDetailComponent(activity: AppCompatActivity): MovieDetailComponent =
            movieDetailComponent ?: buildFeatureMovieDetailComponent(activity).movieDetailComponent().also {
                movieDetailComponent = it
            }
}