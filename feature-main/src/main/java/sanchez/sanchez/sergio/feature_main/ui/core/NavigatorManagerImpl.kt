package sanchez.sanchez.sergio.feature_main.ui.core

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat

/**
 * Navigator Manager Impl
 * @param activity
 */
class NavigatorManagerImpl constructor(
        private val activity: AppCompatActivity
): INavigatorManager {

    /**
     * Show Movie Detail
     * @param id
     * @param transitionImageView
     */
    override fun showMovieDetail(id: Long, transitionImageView: View) {
        ViewCompat.getTransitionName(transitionImageView)?.let { transitionName ->
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                    transitionImageView, transitionName)
            activity.startActivity(
                    Intent("sanchez.sanchez.sergio.intent.action.SHOW_MOVIE_DETAIL").apply {
                        putExtra("MOVIE_ID", id)
                        setPackage(activity.packageName)
                    },
                    options.toBundle()
            )
        }
    }

    /**
     * Show Person Detail
     * @param id
     * @param personTransitionImageView
     */
    override fun showPersonDetail(id: Long, personTransitionImageView: View) {
        ViewCompat.getTransitionName(personTransitionImageView)?.let { transitionName ->
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                    personTransitionImageView, transitionName)
            activity.startActivityForResult(Intent("sanchez.sanchez.sergio.intent.action.SHOW_PERSON_DETAIL").apply {
                putExtra("PERSON_ID", id)
                setPackage(activity.packageName)
            }, 1000, options.toBundle())
        }
    }

    /**
     * Show Tv Detail
     * @param id
     */
    override fun showTvDetail(id: Long) {
        activity.startActivity(
                Intent("sanchez.sanchez.sergio.intent.action.SHOW_TV_DETAIL").apply {
                    putExtra("TV_ID", id)
                    setPackage(activity.packageName)
                }
        )
    }


}