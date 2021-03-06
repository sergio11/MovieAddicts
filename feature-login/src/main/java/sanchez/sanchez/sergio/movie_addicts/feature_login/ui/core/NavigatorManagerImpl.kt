package sanchez.sanchez.sergio.movie_addicts.feature_login.ui.core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class NavigatorManagerImpl constructor(
    private val activity: AppCompatActivity
): INavigatorManager {

    override fun showHome() {
        activity.startActivity(
            Intent("sanchez.sanchez.sergio.intent.action.SHOW_HOME").apply {
                setPackage(activity.packageName)
            }
        )
    }


}