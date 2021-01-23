package sanchez.sanchez.sergio.feature_person_detail.di

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory

object FeaturePersonDetailComponentFactory {

    private var featurePersonDetailComponent: FeaturePersonDetailComponent? = null

    /**
     * Get Feature Person Detail Component
     * @param activity
     */
    fun getFeaturePersonDetailComponent(activity: AppCompatActivity): FeaturePersonDetailComponent =
        featurePersonDetailComponent ?: DaggerFeaturePersonDetailComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).build().also {
                featurePersonDetailComponent = it
            }
}