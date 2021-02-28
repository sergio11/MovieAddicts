package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import android.content.Context
import android.view.ViewGroup
import sanchez.sanchez.sergio.feature_movie_detail.databinding.MovieReviewItemLayoutBinding
import sanchez.sanchez.sergio.feature_movie_detail.databinding.MovieReviewItemLayoutBindingImpl
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Review
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportAdapter

/**
 * Movie Review List Adapter
 * @param context
 * @param data
 */
class MovieReviewListAdapter (context: Context, data: MutableList<Review>):
    SupportAdapter<MovieReviewListAdapter.ReviewViewHolder, Review>(context, data) {

    /**
     * on Create View Holder
     * @param parent
     * @param viewType
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder =
        ReviewViewHolder(MovieReviewItemLayoutBindingImpl.inflate(inflater, parent, false))

    /**
     * Review View Holder
     * @param binding
     */
    inner class ReviewViewHolder(private val binding: MovieReviewItemLayoutBinding): SupportAdapter.SupportViewHolder<Review>(binding.root) {
        override fun bind(model: Review) {
            with(binding) {
                review = model
            }
        }
    }


}