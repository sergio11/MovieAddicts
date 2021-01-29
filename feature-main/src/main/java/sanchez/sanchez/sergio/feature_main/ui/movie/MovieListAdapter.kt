package sanchez.sanchez.sergio.feature_main.ui.movie

import android.content.Context
import android.view.View
import android.view.ViewGroup
import sanchez.sanchez.sergio.feature_main.R
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
            MovieViewHolder(inflateLayout(R.layout.movie_item_layout, parent))


    interface OnMovieClickListener {
        /**
         * on Movie Clicked
         * @param character
         */
        fun onMovieClicked(character: Movie)
    }

    /**
     * Movie View Holder
     * @param itemView
     */
    inner class MovieViewHolder(itemView: View): SupportAdapter.SupportViewHolder<Movie>(itemView) {
        override fun bind(model: Movie) {
            itemView.setOnClickListener {
                movieItemListener.onMovieClicked(model)
            }
        }
    }


}