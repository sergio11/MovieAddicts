package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_movie_detail.R
import sanchez.sanchez.sergio.feature_movie_detail.databinding.MovieDetailFragmentBinding
import sanchez.sanchez.sergio.feature_movie_detail.di.component.MovieDetailComponent
import sanchez.sanchez.sergio.feature_movie_detail.di.factory.FeatureMovieDetailComponentFactory
import sanchez.sanchez.sergio.feature_movie_detail.ui.FeatureMovieDetailActivityDelegate
import sanchez.sanchez.sergio.test.core.ui.SupportFragment
import java.lang.IllegalStateException

/**
 * Movie Detail Fragment
 */
class MovieDetailFragment: SupportFragment<MovieDetailViewModel, MovieDetailFragmentBinding>(MovieDetailViewModel::class.java) {

    private val component: MovieDetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMovieDetailComponentFactory.buildMovieDetailComponent(requireActivity() as AppCompatActivity)
    }

    private lateinit var activityDelegate: FeatureMovieDetailActivityDelegate

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context !is FeatureMovieDetailActivityDelegate)
            throw IllegalStateException("Parent Activity must implement a FeatureMovieDetailActivityDelegate interface")

        activityDelegate = context
    }

    override fun layoutId(): Int = R.layout.movie_detail_fragment

    override fun onInject() {
        component.inject(this)
    }

    override fun onInitObservers() {

        Log.d("MOVIE_DETAIL", "Movie Id -> ${activityDelegate.getMovieId()}")


    }
}