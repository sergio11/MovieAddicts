package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import android.content.Context
import android.view.ViewGroup
import sanchez.sanchez.sergio.feature_movie_detail.databinding.MovieVideoItemLayoutBinding
import sanchez.sanchez.sergio.feature_movie_detail.databinding.MovieVideoItemLayoutBindingImpl
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Video
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportAdapter

/**
 * Movie Video List Adapter
 * @param context
 * @param data
 */
class MovieVideoListAdapter (context: Context, data: MutableList<Video>):
    SupportAdapter<MovieVideoListAdapter.MovieVideoViewHolder, Video>(context, data) {

    /**
     * on Create View Holder
     * @param parent
     * @param viewType
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVideoListAdapter.MovieVideoViewHolder =
        MovieVideoViewHolder(MovieVideoItemLayoutBindingImpl.inflate(inflater, parent, false))

    /**
     * Movie Video View Holder
     * @param binding
     */
    inner class MovieVideoViewHolder(private val binding: MovieVideoItemLayoutBinding): SupportAdapter.SupportViewHolder<Video>(binding.root) {
        override fun bind(model: Video) {
            with(binding) {
                video = model
            }
        }
    }
}