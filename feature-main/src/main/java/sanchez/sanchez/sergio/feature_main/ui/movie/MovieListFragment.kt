package sanchez.sanchez.sergio.feature_main.ui.movie

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_main.di.component.MovieListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.test.core.ui.SupportAdapter
import sanchez.sanchez.sergio.test.core.ui.SupportLCEFragment

/**
 * Movie List Fragment
 */
class MovieListFragment : SupportLCEFragment<MovieListViewModel, Movie, MovieListAdapter.MovieViewHolder>(MovieListViewModel::class.java),
    MovieListAdapter.OnMovieClickListener {

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
     */
    override fun onMovieClicked(movie: Movie) {
        Log.d("MOVIES_L", "onMovieClicked CALLED (${movie.id})")
        showMovieDetail(movie.id)
    }

}