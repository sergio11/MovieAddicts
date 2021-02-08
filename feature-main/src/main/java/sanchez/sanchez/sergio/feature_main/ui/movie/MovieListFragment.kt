package sanchez.sanchez.sergio.feature_main.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.FragmentMovieListBinding
import sanchez.sanchez.sergio.feature_main.di.component.MovieListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.test.core.ui.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportFragment

/**
 * Movie List Fragment
 */
class MovieListFragment : SupportFragment<MovieListViewModel, FragmentMovieListBinding>(MovieListViewModel::class.java),
    MovieListAdapter.OnMovieClickListener {

    private val component: MovieListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.buildMovieListComponent(requireActivity() as AppCompatActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_movie_list

    override fun onInject() {
        component.inject(this)
    }

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                Log.d("MOVIES_L", "uiState UPDATED")
                with(binding) {
                    uiState = state.lceState
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            adapter = MovieListAdapter(
                context = requireContext(),
                data = mutableListOf(),
                movieItemListener = this@MovieListFragment
            )
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.setEvent(LCEContract.Event.OnFetchData())
            }
        }
        viewModel.setEvent(LCEContract.Event.OnFetchData())
    }

    /**
     * Movie Clicked
     * @param movie
     */
    override fun onMovieClicked(movie: Movie) {
        Log.d("MOVIES_L", "onMovieClicked CALLED (${movie.id})")
        showMovieDetail(movie.id)
    }
}