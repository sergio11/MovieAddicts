package sanchez.sanchez.sergio.feature_tv_detail.ui

import sanchez.sanchez.sergio.feature_tv_detail.R
import sanchez.sanchez.sergio.feature_tv_detail.databinding.ActivityFeatureTvDetailBinding
import sanchez.sanchez.sergio.feature_tv_detail.di.component.FeatureTvDetailComponent
import sanchez.sanchez.sergio.feature_tv_detail.di.factory.FeatureTvDetailComponentFactory
import sanchez.sanchez.sergio.test.core.ui.SupportActivity

class FeatureTvDetailActivity : SupportActivity<ActivityFeatureTvDetailBinding>(),
    FeatureTvDetailActivityDelegate {

    private val component: FeatureTvDetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureTvDetailComponentFactory.buildFeatureTvDetailComponent(this)
    }

    override fun layoutId(): Int = R.layout.activity_feature_tv_detail

    override fun onInject() {
        component.inject(this)
    }

    override fun initializeUI() {
        if(!intent.hasExtra(TV_ID_ARG_NAME))
            throw IllegalStateException("You must provide a Tv Id")
    }

    override fun getTvId(): Long =
            intent.getLongExtra(TV_ID_ARG_NAME, -1)

    companion object {
        private const val TV_ID_ARG_NAME = "TV_ID"
    }
}