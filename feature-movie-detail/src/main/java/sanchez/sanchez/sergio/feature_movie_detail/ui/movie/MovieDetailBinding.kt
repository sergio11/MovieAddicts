package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import sanchez.sanchez.sergio.feature_movie_detail.R
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Video
import sanchez.sanchez.sergio.movie_addicts.core.extension.requestGlideListener
import sanchez.sanchez.sergio.movie_addicts.core.extension.visible

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
    fun bindReleaseDate(view: TextView, movie: MovieDetail?) {
        movie?.releaseDate?.let {
            view.text = "Release Date : $it"
        }

    }

    /**
     * Bind Favorite State
     * @param view
     * @param movie
     */
    @JvmStatic
    @BindingAdapter("bindFavoriteState")
    fun bindFavoriteState(view: FloatingActionButton, movie: MovieDetail?) {
        view.isEnabled = true
        movie?.isFavorite?.let { isFavorite ->
            ContextCompat.getDrawable(view.context, R.drawable.ic_baseline_favorite_24)?.let { drawable ->
                val color = ContextCompat.getColor(view.context, if(isFavorite) R.color.colorAccent else R.color.colorPrimaryDark)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    drawable.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP)
                } else {
                    drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
                }
                view.setImageDrawable(drawable)
            }

            view.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(
                view.context, if(isFavorite) R.color.colorPrimaryDark else R.color.colorSecondary
            ))
        }

    }

    /**
     * Bind Back Drop
     * @param view
     * @param movie
     */
    @JvmStatic
    @BindingAdapter("bindBackDrop")
    fun bindBackDrop(view: ImageView, movie: MovieDetail?) {
        movie?.let {
            Glide.with(view.context).load(movie.backdropPath ?: movie.posterPath)
                    .listener(view.requestGlideListener())
                    .into(view)
        }
    }

    /**
     * Bind Movie Video List Adapter
     * @param view
     * @param adapter
     */
    @JvmStatic
    @BindingAdapter("bindMovieVideoListAdapter")
    fun bindMovieVideoListAdapter(view: RecyclerView, adapter: MovieVideoListAdapter) {
        view.adapter = adapter
    }

    /**
     * Bind Movie Video List
     * @param view
     * @param movieVideoList
     */
    @JvmStatic
    @BindingAdapter("bindMovieVideoList")
    fun bindMovieVideoList(view: RecyclerView, movieVideoList: List<Video>?) {
        movieVideoList?.let {
            val adapter = view.adapter
            if(adapter is MovieVideoListAdapter)
                adapter.addData(it)
        }
    }

    /**
     * Bind Movie Review List Adapter
     * @param view
     * @param adapter
     */
    @JvmStatic
    @BindingAdapter("bindMovieReviewListAdapter")
    fun bindMovieReviewListAdapter(view: RecyclerView, adapter: MovieReviewListAdapter) {
        view.adapter = adapter
    }

    /**
     * Bind Movie Review List
     * @param view
     * @param movieReviewList
     */
    @JvmStatic
    @BindingAdapter("bindMovieReviewList")
    fun bindMovieReviewList(view: RecyclerView, movieReviewList: List<Review>?) {
        movieReviewList?.let {
            val adapter = view.adapter
            if(adapter is MovieReviewListAdapter)
                adapter.addData(it)
        }
    }

    /**
     * Bind Movie Keyword List
     * @param chipGroup
     * @param keywords
     */
    @JvmStatic
    @BindingAdapter("bindMovieKeywordList")
    fun bindMovieKeywordList(chipGroup: ChipGroup, keywords: List<Keyword>?) {
        keywords?.let {
            chipGroup.visible()
            for (keyword in it) {
                chipGroup.addView(
                    Chip(chipGroup.context).apply {
                        text = keyword.name
                        isCheckable = false
                        setChipBackgroundColorResource(R.color.colorPrimary)
                    }
                )
            }
        }
    }

}