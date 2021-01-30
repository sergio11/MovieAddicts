package sanchez.sanchez.sergio.feature_main.ui.movie

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.feature_main.domain.model.Movie

object MovieListViewBindings {

    /**
     * @param view
     * @param movies
     */
    @JvmStatic
    @BindingAdapter("adapterMovieList")
    fun bindAdapterMovieList(view: RecyclerView, movies: List<Any>?) {
        movies?.let {
            view.adapter?.let {
                if(it is MovieListAdapter)
                    it.addData(movies as List<Movie>)
            }
        }
    }

}