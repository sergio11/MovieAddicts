package sanchez.sanchez.sergio.feature_tv_detail.di.factory

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_tv_detail.di.component.DaggerFeatureTvDetailComponent
import sanchez.sanchez.sergio.feature_tv_detail.di.component.FeatureTvDetailComponent
import sanchez.sanchez.sergio.feature_tv_detail.di.component.TvDetailComponent
import sanchez.sanchez.sergio.movie_addicts.core.SupportApp
import sanchez.sanchez.sergio.movie_addicts.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ActivityModule

object FeatureTvDetailComponentFactory {

    private var featureTvDetailComponent: FeatureTvDetailComponent? = null
    private var tvDetailComponent: TvDetailComponent? = null

    /**
     * Build Feature Tv Detail Component
     * @param activity
     */
    fun getFeatureTvDetailComponent(activity: AppCompatActivity): FeatureTvDetailComponent =
        featureTvDetailComponent ?: DaggerFeatureTvDetailComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).activityModule(ActivityModule(activity)).build().also {
                featureTvDetailComponent = it
            }

    /**
     * Remove Feature Tv Detail Component
     */
    fun removeFeatureTvDetailComponent() {
        featureTvDetailComponent = null
        tvDetailComponent = null
    }

    /**
     * Build Tv Detail Component
     * @param activity
     */
    fun getTvDetailComponent(activity: AppCompatActivity): TvDetailComponent =
            tvDetailComponent ?: getFeatureTvDetailComponent(activity).tvDetailComponent().also {
                tvDetailComponent = it
            }

    /**
     * Remove Tv Detail Component
     */
    fun removeTvDetailComponent() {
        tvDetailComponent
    }


}