package sanchez.sanchez.sergio.feature_splash.ui

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportActivity
import sanchez.sanchez.sergio.feature_splash.R
import sanchez.sanchez.sergio.feature_splash.databinding.ActivityFeatureSplashBinding
import sanchez.sanchez.sergio.feature_splash.di.factory.FeatureSplashComponentFactory

/**
 * Feature Splash Activity
 */
class FeatureSplashActivity: SupportActivity<ActivityFeatureSplashBinding>() {

    override fun layoutId(): Int = R.layout.activity_feature_splash

    override fun onAttachComponent() {
        FeatureSplashComponentFactory.getFeatureSplashComponent(this)
    }

    override fun onDetachComponent() {
        FeatureSplashComponentFactory.removeFeatureSplashComponent()
    }

    override fun initializeUI() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        with(binding) {

            val animDrawable = container.background as AnimationDrawable
            animDrawable.apply {
                setEnterFadeDuration(10)
                setExitFadeDuration(5000)
                start()
            }

            AnimationUtils.loadAnimation( this@FeatureSplashActivity, R.anim.splash_stripe_anim).let {
                stripes.startAnimation(it)
            }
        }
    }

}