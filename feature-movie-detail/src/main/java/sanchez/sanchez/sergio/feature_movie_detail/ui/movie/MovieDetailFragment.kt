package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_movie_detail.R
import sanchez.sanchez.sergio.feature_movie_detail.databinding.MovieDetailFragmentBinding
import sanchez.sanchez.sergio.feature_movie_detail.di.component.MovieDetailComponent
import sanchez.sanchez.sergio.feature_movie_detail.di.factory.FeatureMovieDetailComponentFactory
import sanchez.sanchez.sergio.feature_movie_detail.ui.FeatureMovieDetailActivity
import sanchez.sanchez.sergio.feature_movie_detail.ui.FeatureMovieDetailActivityDelegate
import sanchez.sanchez.sergio.test.core.ui.SupportFragment

/**
 * Movie Detail Fragment
 */
class MovieDetailFragment: SupportFragment<MovieDetailViewModel, MovieDetailFragmentBinding>(MovieDetailViewModel::class.java) {

    private val component: MovieDetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMovieDetailComponentFactory.buildMovieDetailComponent(requireActivity() as AppCompatActivity)
    }

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

    override fun onInject() {
        component.inject(this)
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
    }
}