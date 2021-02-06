package sanchez.sanchez.sergio.feature_tv_detail.di.factory

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_tv_detail.di.component.DaggerFeatureTvDetailComponent
import sanchez.sanchez.sergio.feature_tv_detail.di.component.FeatureTvDetailComponent
import sanchez.sanchez.sergio.feature_tv_detail.di.component.TvDetailComponent
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.factory.AppComponentFactory
import sanchez.sanchez.sergio.test.core.di.module.ActivityModule

object FeatureTvDetailComponentFactory {

    private var featureTvDetailComponent: FeatureTvDetailComponent? = null
    private var tvDetailComponent: TvDetailComponent? = null

    /**
     * Build Feature Tv Detail Component
     * @param activity
     */
    fun buildFeatureTvDetailComponent(activity: AppCompatActivity): FeatureTvDetailComponent =
        featureTvDetailComponent ?: DaggerFeatureTvDetailComponent.builder()
            .applicationComponent(AppComponentFactory.getAppComponent(
                activity.application as SupportApp
            )).activityModule(ActivityModule(activity)).build().also {
                featureTvDetailComponent = it
            }

    /**
     * Build Tv Detail Component
     * @param activity
     */
    fun buildTvDetailComponent(activity: AppCompatActivity): TvDetailComponent =
            tvDetailComponent ?: buildFeatureTvDetailComponent(activity).tvDetailComponent().also {
                tvDetailComponent = it
            }


}