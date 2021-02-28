package sanchez.sanchez.sergio.feature_splash.ui.core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 * Navigation Manager
 */
class NavigationManagerImpl constructor(
    private val activity: AppCompatActivity
): INavigatorManager {

    override fun showHome() {
        activity.run {
            startActivity(
                Intent("sanchez.sanchez.sergio.intent.action.SHOW_HOME").apply {
                    setPackage(packageName)
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
            )
            finish()
        }
    }

    override fun showLogin() {
        activity.run {
            startActivity(
                Intent("sanchez.sanchez.sergio.intent.action.SHOW_LOGIN").apply {
                    setPackage(packageName)
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
            )
            finish()
        }
    }
}