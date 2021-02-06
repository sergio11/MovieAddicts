package sanchez.sanchez.sergio.feature_movie_detail.ui

import android.os.Bundle
import sanchez.sanchez.sergio.feature_movie_detail.R
import sanchez.sanchez.sergio.feature_movie_detail.databinding.ActivityFeatureMovieDetailBinding
import sanchez.sanchez.sergio.feature_movie_detail.di.component.FeatureMovieDetailComponent
import sanchez.sanchez.sergio.feature_movie_detail.di.factory.FeatureMovieDetailComponentFactory
import sanchez.sanchez.sergio.test.core.ui.SupportActivity
import java.lang.IllegalStateException

class FeatureMovieDetailActivity : SupportActivity<ActivityFeatureMovieDetailBinding>(),
        FeatureMovieDetailActivityDelegate {

    private val component: FeatureMovieDetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMovieDetailComponentFactory.buildFeatureMovieDetailComponent(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(!intent.hasExtra(MOVIE_ID_ARG_NAME))
            throw IllegalStateException("You must provide a Movie Id")
    }

    override fun onInject() {
        component.inject(this)
    }

    override fun initializeUI() {}

    override fun layoutId(): Int = R.layout.activity_feature_movie_detail

    override fun getMovieId(): Long =
            intent.getLongExtra(MOVIE_ID_ARG_NAME, -1)

    companion object {

        private const val MOVIE_ID_ARG_NAME = "MOVIE_ID"

    }
}