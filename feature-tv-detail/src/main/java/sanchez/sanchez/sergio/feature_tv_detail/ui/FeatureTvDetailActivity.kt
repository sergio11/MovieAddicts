package sanchez.sanchez.sergio.feature_tv_detail.ui

import android.view.MenuItem
import sanchez.sanchez.sergio.feature_tv_detail.R
import sanchez.sanchez.sergio.feature_tv_detail.databinding.ActivityFeatureTvDetailBinding
import sanchez.sanchez.sergio.feature_tv_detail.di.factory.FeatureTvDetailComponentFactory
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportActivity

class FeatureTvDetailActivity : SupportActivity<ActivityFeatureTvDetailBinding>(),
    FeatureTvDetailActivityDelegate {

    override fun layoutId(): Int = R.layout.activity_feature_tv_detail

    override fun onAttachComponent() {
        FeatureTvDetailComponentFactory.getFeatureTvDetailComponent(this)
                .inject(this)
    }

    override fun onDetachComponent() {
        FeatureTvDetailComponentFactory.removeFeatureTvDetailComponent()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return false
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