package sanchez.sanchez.sergio.feature_splash.ui.splash

import android.content.Intent

/**
 * Show Home
 */
fun SplashFragment.showHome() {
    activity?.let {
        startActivity(
                Intent("sanchez.sanchez.sergio.intent.action.SHOW_HOME").apply {
                    setPackage(it.packageName)
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
        )
        it.finish()
    }
}