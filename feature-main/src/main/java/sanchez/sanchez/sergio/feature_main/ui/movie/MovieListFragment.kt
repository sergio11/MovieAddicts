package sanchez.sanchez.sergio.feature_main.ui.movie

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.FragmentMovieListBinding
import sanchez.sanchez.sergio.feature_main.di.component.MovieListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.test.core.ui.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportFragment
import sanchez.sanchez.sergio.test.core.ui.SupportRecyclerViewPagination

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
            recyclerView.apply {
                addItemDecoration(object: RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                        super.getItemOffsets(outRect, view, parent, state)
                        val commonPadding = requireContext().resources.getDimension(R.dimen.common_small_padding).toInt()
                        outRect.apply {
                            left = commonPadding
                            right = commonPadding
                            top = commonPadding
                            bottom = commonPadding
                        }
                    }
                })

                SupportRecyclerViewPagination(
                        recyclerView = this,
                        isLoading = { viewModel.isLoading() },
                        loadMore = { viewModel.setEvent(LCEContract.Event.OnLoadNextPage) },
                        onLast = { false }
                )
            }

            swipeRefreshLayout.apply {
                setProgressBackgroundColorSchemeColor(ContextCompat.getColor(requireContext(), android.R.color.black))
                setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
                setOnRefreshListener {
                    viewModel.setEvent(LCEContract.Event.OnLoadInitialData)
                }
            }
        }
        viewModel.setEvent(LCEContract.Event.OnLoadInitialData)
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