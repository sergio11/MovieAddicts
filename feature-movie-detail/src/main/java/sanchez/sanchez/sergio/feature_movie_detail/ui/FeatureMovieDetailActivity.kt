package sanchez.sanchez.sergio.feature_movie_detail.ui

import android.view.MenuItem
import sanchez.sanchez.sergio.feature_movie_detail.R
import sanchez.sanchez.sergio.feature_movie_detail.databinding.ActivityFeatureMovieDetailBinding
import sanchez.sanchez.sergio.feature_movie_detail.di.factory.FeatureMovieDetailComponentFactory
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportActivity
import java.lang.IllegalStateException

class FeatureMovieDetailActivity : SupportActivity<ActivityFeatureMovieDetailBinding>(),
        FeatureMovieDetailActivityDelegate {

    override fun layoutId(): Int = R.layout.activity_feature_movie_detail

    override fun onAttachComponent() {
        FeatureMovieDetailComponentFactory.getFeatureMovieDetailComponent(this)
                .inject(this)
    }

    override fun onDetachComponent() {
        FeatureMovieDetailComponentFactory.removeFeatureMovieDetailComponent()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return false
    }

    override fun initializeUI() {
        if(!intent.hasExtra(MOVIE_ID_ARG_NAME))
            throw IllegalStateException("You must provide a Movie Id")
    }

    override fun getMovieId(): Long =
            intent.getLongExtra(MOVIE_ID_ARG_NAME, -1)

    companion object {
        private const val MOVIE_ID_ARG_NAME = "MOVIE_ID"
    }
}