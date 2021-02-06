package sanchez.sanchez.sergio.feature_person_detail.di.factory

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_person_detail.di.component.DaggerFeaturePersonDetailComponent
import sanchez.sanchez.sergio.feature_person_detail.di.component.FeaturePersonDetailComponent
import sanchez.sanchez.sergio.feature_person_detail.di.component.PersonDetailComponent
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule

/**
 * Feature Person Detail Component Factory
 */
object FeaturePersonDetailComponentFactory {

    private var featurePersonDetailComponent: FeaturePersonDetailComponent? = null
    private var personDetailComponent: PersonDetailComponent? = null

    /**
     * Build Feature Person Detail Component
     * @param activity
     */
    fun buildFeaturePersonDetailComponent(activity: AppCompatActivity): FeaturePersonDetailComponent =
        featurePersonDetailComponent ?: DaggerFeaturePersonDetailComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).activityModule(ActivityModule(activity)).build().also {
                featurePersonDetailComponent = it
            }

    /**
     * Build Person Detail Component
     * @param activity
     */
    fun buildPersonDetailComponent(activity: AppCompatActivity): PersonDetailComponent =
            personDetailComponent ?: buildFeaturePersonDetailComponent(activity).personDetailComponent().also {
                personDetailComponent = it
            }
}