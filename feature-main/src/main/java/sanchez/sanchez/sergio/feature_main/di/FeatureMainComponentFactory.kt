package sanchez.sanchez.sergio.feature_main.di

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule

object FeatureMainComponentFactory {

    private var featureMainComponent: FeatureMainComponent? = null

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
}