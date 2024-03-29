package sanchez.sanchez.sergio.movie_addicts.core.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import sanchez.sanchez.sergio.R

/**
 * Support Glide Bindings
 */
object SupportGlideBindings {

    /**
     * Bind Load Image
     * @param view
     * @param url
     */
    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindLoadImage(view: ImageView, url: String?) {
        Glide.with(view.context)
            .load(url)
            .transition(
                DrawableTransitionOptions.withCrossFade(
                    DrawableCrossFadeFactory.Builder()
                        .setCrossFadeEnabled(true)
                        .build()
                )
            )
            .apply(RequestOptions.skipMemoryCacheOf(false))
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
            .placeholder(R.drawable.ic_default_placeholder)
            .error(R.drawable.ic_default_placeholder)
            .into(view)
    }

    /**
     * Bind Load Circle Image
     * @param view
     * @param url
     */
    @JvmStatic
    @BindingAdapter("loadCircleImage")
    fun bindLoadCircleImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .transition(
                DrawableTransitionOptions.withCrossFade(
                    DrawableCrossFadeFactory.Builder()
                        .setCrossFadeEnabled(true)
                        .build()
                )
            )
            .apply(RequestOptions.skipMemoryCacheOf(false))
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
            .apply(RequestOptions().circleCrop())
            .placeholder(R.drawable.ic_default_placeholder)
            .error(R.drawable.ic_default_placeholder)
            .into(view)
    }
}