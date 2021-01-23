package sanchez.sanchez.sergio.feature_movie_detail.di

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory

object FeatureMovieDetailComponentFactory {

    private var featureMovieDetailComponent: FeatureMovieDetailComponent? = null

    /**
     * Get Feature Movie Detail Component
     * @param activity
     */
    fun getFeatureMovieDetailComponent(activity: AppCompatActivity): FeatureMovieDetailComponent =
        featureMovieDetailComponent ?: DaggerFeatureMovieDetailComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).build().also {
                featureMovieDetailComponent = it
            }
}