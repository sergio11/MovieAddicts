package sanchez.sanchez.sergio.feature_main.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.FragmentMovieListBinding
import sanchez.sanchez.sergio.feature_main.di.component.MovieListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.test.core.ui.SupportFragment

/**
 * Movie List Fragment
 */
class MovieListFragment : SupportFragment<MovieListViewModel, FragmentMovieListBinding>(MovieListViewModel::class.java) {

    private val component: MovieListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getMovieListComponent(requireActivity() as AppCompatActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_movie_list

    override fun onInject() {
        component.inject(this)
    }

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                Log.d("MOVIES_L", "uiState UPDATED, ${state.moviesState}")
                with(binding) {
                    uiState = state.moviesState
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MOVIES_L", "OnViewCreated CALLED, OnFetchMovies")
        viewModel.setEvent(MovieListContract.Event.OnFetchMovies())

    }

}