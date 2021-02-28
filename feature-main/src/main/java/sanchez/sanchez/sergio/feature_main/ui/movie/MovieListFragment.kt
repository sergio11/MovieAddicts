package sanchez.sanchez.sergio.feature_main.ui.movie

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.ui.core.INavigatorManager
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportAdapter
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportLCEFragment
import javax.inject.Inject

/**
 * Movie List Fragment
 */
class MovieListFragment : SupportLCEFragment<MovieListViewModel, Movie, MovieListAdapter.MovieViewHolder>(MovieListViewModel::class.java),
    MovieListAdapter.OnMovieClickListener {

    @Inject
    lateinit var navigationManager: INavigatorManager

    override fun onAttachComponent() {
        FeatureMainComponentFactory.getMovieListComponent(requireActivity() as AppCompatActivity)
                .inject(this)
    }

    override fun onDetachComponent() {
        FeatureMainComponentFactory.removeMovieListComponent()
    }

    override fun onBuildAdapter(): SupportAdapter<MovieListAdapter.MovieViewHolder, Movie> =
            MovieListAdapter(context = requireContext(), data = mutableListOf(), movieItemListener = this)

    /**
     * Movie Clicked
     * @param movie
     * @param itemMovieImageView
     */
    override fun onMovieClicked(movie: Movie, itemMovieImageView: ImageView) {
        navigationManager.showMovieDetail(movie.id, itemMovieImageView)
    }

}