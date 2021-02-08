package sanchez.sanchez.sergio.test.core.ui.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette

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
    fun bindLoadImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
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
            .apply(RequestOptions().circleCrop())
            .into(view)


    }

    /**
     * Bind Load Palette Image Color
     * @param view
     * @param url
     */
    @JvmStatic
    @BindingAdapter("loadPaletteImageColor")
    fun bindLoadPaletteImageColor(view: ImageView, url: String) {
        Glide.with(view)
            .load(url)
            .listener(
                GlidePalette.with(url)
                    .use(BitmapPalette.Profile.VIBRANT)
                    .intoBackground(view.parent as View)
                    .crossfade(true)
            )
            .into(view)
    }
}