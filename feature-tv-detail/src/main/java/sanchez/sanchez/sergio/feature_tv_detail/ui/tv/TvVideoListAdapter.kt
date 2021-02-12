package sanchez.sanchez.sergio.feature_tv_detail.ui.tv

import android.content.Context
import android.view.ViewGroup
import sanchez.sanchez.sergio.feature_tv_detail.databinding.TvVideoItemLayoutBinding
import sanchez.sanchez.sergio.feature_tv_detail.databinding.TvVideoItemLayoutBindingImpl
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Video
import sanchez.sanchez.sergio.test.core.ui.SupportAdapter

/**
 * Tv Video List Adapter
 * @param context
 * @param data
 */
class TvVideoListAdapter (context: Context, data: MutableList<Video>):
    SupportAdapter<TvVideoListAdapter.TvVideoViewHolder, Video>(context, data) {

    /**
     * on Create View Holder
     * @param parent
     * @param viewType
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvVideoListAdapter.TvVideoViewHolder =
            TvVideoViewHolder(TvVideoItemLayoutBindingImpl.inflate(inflater, parent, false))

    /**
     * Tv Video View Holder
     * @param binding
     */
    inner class TvVideoViewHolder(private val binding: TvVideoItemLayoutBinding): SupportAdapter.SupportViewHolder<Video>(binding.root) {
        override fun bind(model: Video) {
            with(binding) {
                video = model
            }
        }
    }
}