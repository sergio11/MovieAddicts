package sanchez.sanchez.sergio.test.core.extension

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewAnimationUtils
import androidx.core.content.ContextCompat
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import sanchez.sanchez.sergio.R
import kotlin.math.max

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.requestGlideListener(): RequestListener<Drawable> {
    return object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            circularRevealedAtCenter()
            return false
        }
    }
}

fun View.circularRevealedAtCenter() {
    val view = this
    val cx = (view.left + view.right) / 2
    val cy = (view.top + view.bottom) / 2
    val finalRadius = max(view.width, view.height)

    if (view.isAttachedToWindow) {
        ViewAnimationUtils.createCircularReveal(view, cx, cy, 0f, finalRadius.toFloat())
            .apply {
                view.visible()
                view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorAppBackground))
                duration = 550
                start()
            }
    }
}