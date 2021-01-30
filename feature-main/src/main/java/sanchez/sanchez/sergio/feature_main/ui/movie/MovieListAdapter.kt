package sanchez.sanchez.sergio.feature_main.ui.movie

import android.content.Context
import android.view.ViewGroup
import sanchez.sanchez.sergio.feature_main.databinding.MovieItemLayoutBinding
import sanchez.sanchez.sergio.feature_main.databinding.MovieItemLayoutBindingImpl
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.ui.core.SupportAdapter

/**
 * Movie List Adapter
 * @param context
 * @param data
 * @param movieItemListener
 */
class MovieListAdapter(
        context: Context,
        data: MutableList<Movie>,
        private val movieItemListener: OnMovieClickListener,
): SupportAdapter<MovieListAdapter.MovieViewHolder, Movie>(context, data) {

    /**
     * Create View Holder
     * @param parent
     * @param viewType
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
            MovieViewHolder(MovieItemLayoutBindingImpl.inflate(inflater, parent, false))


    interface OnMovieClickListener {
        /**
         * on Movie Clicked
         * @param movie
         */
        fun onMovieClicked(movie: Movie)
    }

    /**
     * Movie View Holder
     * @param binding
     */
    inner class MovieViewHolder(val binding: MovieItemLayoutBinding): SupportAdapter.SupportViewHolder<Movie>(binding.root) {
        override fun bind(model: Movie) {
            with(binding) {
                movie = model
                movieListener = movieItemListener
            }
        }
    }


}