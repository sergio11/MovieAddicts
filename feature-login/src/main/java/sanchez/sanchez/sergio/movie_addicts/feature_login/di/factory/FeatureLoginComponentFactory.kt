package sanchez.sanchez.sergio.movie_addicts.feature_login.di.factory

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.movie_addicts.core.SupportApp
import sanchez.sanchez.sergio.movie_addicts.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ActivityModule
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.component.DaggerFeatureLoginComponent
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.component.FeatureLoginComponent
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.component.LoginComponent

object FeatureLoginComponentFactory {

    private var featureLoginComponent: FeatureLoginComponent? = null
    private var loginComponent: LoginComponent? = null

    /**
     * Get Feature Login Component
     * @param activity
     */
    fun getFeatureLoginComponent(activity: AppCompatActivity): FeatureLoginComponent =
        featureLoginComponent ?: DaggerFeatureLoginComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).activityModule(ActivityModule(activity)).build().also {
                featureLoginComponent = it
            }

    /**
     * Remove Feature Login Component
     */
    fun removeFeatureLoginComponent() {
        featureLoginComponent = null
        loginComponent = null
    }

    /**
     * Get Login Component
     * @param activity
     */
    fun getLoginComponent(activity: AppCompatActivity): LoginComponent =
        loginComponent ?: getFeatureLoginComponent(activity).loginComponent().also {
            loginComponent = it
            }

    fun removeLoginComponent() {
        loginComponent = null
    }
}