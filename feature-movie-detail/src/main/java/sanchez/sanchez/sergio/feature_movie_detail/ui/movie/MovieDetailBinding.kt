package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.test.core.extension.requestGlideListener

/**
 * Movie Detail Binding
 */
object MovieDetailBinding {

    /**
     * Bind Release Date
     * @param view
     * @param movie
     */
    @JvmStatic
    @SuppressLint("SetTextI18n")
    @BindingAdapter("bindReleaseDate")
    fun bindReleaseDate(view: TextView, movie: MovieDetail) {
        view.text = "Release Date : ${movie.releaseDate}"
    }

    /**
     * Bind Back Drop
     * @param view
     * @param movie
     */
    @JvmStatic
    @BindingAdapter("bindBackDrop")
    fun bindBackDrop(view: ImageView, movie: MovieDetail) {
        Glide.with(view.context).load(movie.backdropPath ?: movie.posterPath)
            .listener(view.requestGlideListener())
            .into(view)
    }

}