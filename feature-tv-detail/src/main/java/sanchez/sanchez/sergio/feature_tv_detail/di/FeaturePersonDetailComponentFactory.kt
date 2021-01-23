package sanchez.sanchez.sergio.feature_tv_detail.di

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory

object FeaturePersonDetailComponentFactory {

    private var featureTvDetailComponent: FeatureTvDetailComponent? = null

    /**
     * Get Feature Tv Detail Component
     * @param activity
     */
    fun getFeaturePersonDetailComponent(activity: AppCompatActivity): FeatureTvDetailComponent =
        featureTvDetailComponent ?: DaggerFeatureTvDetailComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).build().also {
                featureTvDetailComponent = it
            }
}