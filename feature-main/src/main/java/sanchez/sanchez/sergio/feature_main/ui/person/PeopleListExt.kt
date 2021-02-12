package sanchez.sanchez.sergio.feature_main.ui.person

import android.content.Intent
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat

/**
 * Show Person Detail
 * @param id
 * @param personTransitionImageView
 */
fun PeopleListFragment.showPersonDetail(id: Long, personTransitionImageView: View) {
    activity?.let {
        ViewCompat.getTransitionName(personTransitionImageView)?.let { transitionName ->
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(it,
                    personTransitionImageView, transitionName)
            startActivityForResult(Intent("sanchez.sanchez.sergio.intent.action.SHOW_PERSON_DETAIL").apply {
                putExtra("PERSON_ID", id)
                setPackage(it.packageName)
            }, 1000, options.toBundle())
        }
    }
}