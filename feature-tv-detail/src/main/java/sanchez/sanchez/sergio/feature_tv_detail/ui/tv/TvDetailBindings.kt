package sanchez.sanchez.sergio.feature_tv_detail.ui.tv

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import sanchez.sanchez.sergio.feature_tv_detail.R
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Video
import sanchez.sanchez.sergio.movie_addicts.core.extension.requestGlideListener
import sanchez.sanchez.sergio.movie_addicts.core.extension.visible

/**
 * Tv Detail Bindings
 */
object TvDetailBindings {

    /**
     * Bind Back Drop
     * @param view
     * @param tv
     */
    @JvmStatic
    @BindingAdapter("bindBackDrop")
    fun bindBackDrop(view: ImageView, tv: TvDetail?) {
        tv?.let {
            Glide.with(view.context).load(it.backdropPath ?: it.posterPath)
                    .listener(view.requestGlideListener())
                    .into(view)
        }
    }

    /**
     * Bind Air Date
     * @param view
     * @param tv
     */
    @JvmStatic
    @SuppressLint("SetTextI18n")
    @BindingAdapter("bindAirDate")
    fun bindAirDate(view: TextView, tv: TvDetail?) {
        tv?.firstAirDate?.let {
            view.text = "First Air Date : $it"
        }
    }

    /**
     * Bind Tv Video Adapter
     * @param view
     * @param tvVideoAdapter
     */
    @JvmStatic
    @BindingAdapter("bindTvVideoAdapter")
    fun bindTvVideoAdapter(view: RecyclerView, tvVideoAdapter: TvVideoListAdapter) {
        view.adapter = tvVideoAdapter
    }

    /**
     * Bind Tv Video List
     * @param view
     * @param videos
     */
    @JvmStatic
    @BindingAdapter("bindTvVideoList")
    fun bindTvVideoList(view: RecyclerView, videos: List<Video>?) {
        videos?.let {
            (view.adapter as? TvVideoListAdapter)?.addData(it)
        }
    }

    /**
     * Bind Tv Review Adapter
     * @param view
     * @param tvReviewAdapter
     */
    @JvmStatic
    @BindingAdapter("bindTvReviewAdapter")
    fun bindTvReviewAdapter(view: RecyclerView, tvReviewAdapter: TvReviewListAdapter) {
        view.adapter = tvReviewAdapter
    }

    /**
     * Bind Tv Review List
     * @param view
     * @param reviews
     */
    @JvmStatic
    @BindingAdapter("bindTvReviewList")
    fun bindTvReviewList(view: RecyclerView, reviews: List<Review>?) {
        reviews?.let {
            (view.adapter as? TvReviewListAdapter)?.addData(it)
        }
    }

    /**
     * Bind Tv Keyword List
     * @param chipGroup
     * @param keywords
     */
    @JvmStatic
    @BindingAdapter("bindTvKeywordList")
    fun bindTvKeywordList(chipGroup: ChipGroup, keywords: List<Keyword>?) {
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