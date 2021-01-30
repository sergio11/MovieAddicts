package sanchez.sanchez.sergio.feature_main.ui.core.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette

object SupportGlideBindings {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindLoadImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("loadCircleImage")
    fun bindLoadCircleImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .apply(RequestOptions().circleCrop())
            .into(view)


    }

    @JvmStatic
    @BindingAdapter("loadPaletteImageColor")
    fun loadPaletteImageColor(view: ImageView, url: String) {
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