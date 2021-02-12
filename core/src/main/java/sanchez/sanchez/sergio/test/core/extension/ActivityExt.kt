package sanchez.sanchez.sergio.test.core.extension

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.appbar.CollapsingToolbarLayout
import sanchez.sanchez.sergio.R

fun Activity.circularRevealedAtCenter(view: View) {
    val cx = (view.left + view.right) / 2
    val cy = (view.top + view.bottom) / 2
    val finalRadius = view.width.coerceAtLeast(view.height)
    if (view.isAttachedToWindow) {
        ViewAnimationUtils.createCircularReveal(view, cx, cy, 0f, finalRadius.toFloat())
            .apply {
                view.visibility = View.VISIBLE
                view.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.background))
                duration = 550
                start()
            }
    }
}

fun Activity.requestGlideListener(view: View): RequestListener<Drawable> {
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
            circularRevealedAtCenter(view)
            return false
        }
    }
}

fun AppCompatActivity.simpleToolbarWithHome(toolbar: Toolbar, toolbarTitle: String = "") {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        setDisplayHomeAsUpEnabled(true)
        setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        title = toolbarTitle
    }
}

/**
 * Apply Toolbar Margin
 * @param toolbar
 */
fun AppCompatActivity.applyToolbarMargin(toolbar: Toolbar) {
    if(toolbar.layoutParams is CollapsingToolbarLayout.LayoutParams)
        toolbar.layoutParams = (toolbar.layoutParams as CollapsingToolbarLayout.LayoutParams).apply {
            topMargin = getStatusBarSize()
        }
}

/**
 * Get Status Bar Size
 */
fun AppCompatActivity.getStatusBarSize(): Int {
    val idStatusBarHeight = resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (idStatusBarHeight > 0) {
        resources.getDimensionPixelSize(idStatusBarHeight)
    } else 0
}