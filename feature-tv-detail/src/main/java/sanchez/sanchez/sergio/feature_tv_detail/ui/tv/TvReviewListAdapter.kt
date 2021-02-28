package sanchez.sanchez.sergio.feature_tv_detail.ui.tv

import android.content.Context
import android.view.ViewGroup
import sanchez.sanchez.sergio.feature_tv_detail.databinding.TvReviewItemLayoutBinding
import sanchez.sanchez.sergio.feature_tv_detail.databinding.TvReviewItemLayoutBindingImpl
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Review
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportAdapter

/**
 * Tv Review List Adapter
 * @param context
 * @param data
 */
class TvReviewListAdapter (context: Context, data: MutableList<Review>):
    SupportAdapter<TvReviewListAdapter.TvReviewViewHolder, Review>(context, data) {

    /**
     * on Create View Holder
     * @param parent
     * @param viewType
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvReviewListAdapter.TvReviewViewHolder =
            TvReviewViewHolder(TvReviewItemLayoutBindingImpl.inflate(inflater, parent, false))

    /**
     * Tv Review View Holder
     * @param binding
     */
    inner class TvReviewViewHolder(private val binding: TvReviewItemLayoutBinding): SupportAdapter.SupportViewHolder<Review>(binding.root) {
        override fun bind(model: Review) {
            with(binding) {
                review = model
            }
        }
    }
}