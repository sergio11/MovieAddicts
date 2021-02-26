package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_movie_detail.R
import sanchez.sanchez.sergio.feature_movie_detail.databinding.MovieDetailFragmentBinding
import sanchez.sanchez.sergio.feature_movie_detail.di.factory.FeatureMovieDetailComponentFactory
import sanchez.sanchez.sergio.feature_movie_detail.ui.FeatureMovieDetailActivity
import sanchez.sanchez.sergio.feature_movie_detail.ui.FeatureMovieDetailActivityDelegate
import sanchez.sanchez.sergio.test.core.extension.gone
import sanchez.sanchez.sergio.test.core.extension.visible
import sanchez.sanchez.sergio.test.core.ui.SupportFragment
import kotlin.math.abs

/**
 * Movie Detail Fragment
 */
class MovieDetailFragment: SupportFragment<MovieDetailViewModel, MovieDetailFragmentBinding>(MovieDetailViewModel::class.java) {

    private lateinit var activityDelegate: FeatureMovieDetailActivityDelegate

    private val movieVideoListAdapter by lazy {
        MovieVideoListAdapter(requireContext(), mutableListOf())
    }

    private val movieReviewListAdapter by lazy {
        MovieReviewListAdapter(requireContext(), mutableListOf())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context !is FeatureMovieDetailActivityDelegate)
            throw IllegalStateException("Parent Activity must implement a FeatureMovieDetailActivityDelegate interface")
        activityDelegate = context
    }

    override fun layoutId(): Int = R.layout.movie_detail_fragment

    override fun onAttachComponent() {
        FeatureMovieDetailComponentFactory.getMovieDetailComponent(requireActivity() as AppCompatActivity)
                .inject(this)
    }

    override fun onDetachComponent() {
        FeatureMovieDetailComponentFactory.removeMovieDetailComponent()
    }

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                with(binding) {
                    activity = requireActivity() as FeatureMovieDetailActivity
                    videoListAdapter = movieVideoListAdapter
                    reviewListAdapter = movieReviewListAdapter
                    movie = if (state.movieState is MovieDetailContract.MovieState.OnLoaded)
                        state.movieState.movie
                    else
                        null
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setEvent(MovieDetailContract.Event.FetchMovieDetail(activityDelegate.getMovieId()))

        with(binding) {
            appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                Log.d("MOVIE_DETAIL", "measuredHeight -> ${appBarLayout.measuredHeight}")
                Log.d("MOVIE_DETAIL", "height -> ${appBarLayout.height}")
                Log.d("MOVIE_DETAIL", "appBarLayout.totalScrollRange -> ${appBarLayout.totalScrollRange}")

                if (abs(verticalOffset) == appBarLayout.totalScrollRange) {
                    configureHomeAsUpIndicatorWithColor(android.R.color.black)
                    moviePoster.gone()
                } else {
                    configureHomeAsUpIndicatorWithColor(R.color.colorPrimaryDark)
                    moviePoster.visible()
                }
            })
        }
    }

    /**
     * Private Methods
     */

    fun configureHomeAsUpIndicatorWithColor(color: Int) {
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_arrow_back_24)?.let {
            DrawableCompat.setTint(it, requireContext().getColor(color))
            parentActivity.supportActionBar?.setHomeAsUpIndicator(it)
        }
    }


}