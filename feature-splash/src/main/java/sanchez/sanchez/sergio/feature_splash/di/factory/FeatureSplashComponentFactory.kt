package sanchez.sanchez.sergio.feature_splash.di.factory

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.feature_splash.di.component.DaggerFeatureSplashComponent
import sanchez.sanchez.sergio.feature_splash.di.component.FeatureSplashComponent
import sanchez.sanchez.sergio.feature_splash.di.component.SplashComponent
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule

object FeatureSplashComponentFactory {

    private var featureSplashComponent: FeatureSplashComponent? = null
    private var splashComponent: SplashComponent? = null

    fun buildFeatureSplashComponent(activity: AppCompatActivity): FeatureSplashComponent =
        featureSplashComponent ?: DaggerFeatureSplashComponent.builder()
            .applicationComponent(
                AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).activityModule(ActivityModule(activity)).build().also {
                featureSplashComponent = it
            }

    fun buildSplashComponent(activity: AppCompatActivity): SplashComponent =
        splashComponent ?: buildFeatureSplashComponent(activity).splashComponent().also {
            splashComponent = it
        }

}