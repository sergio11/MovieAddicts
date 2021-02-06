package sanchez.sanchez.sergio.feature_main.ui.person

import android.content.Intent

/**
 * Show Person Detail
 */
fun PeopleListFragment.showPersonDetail(id: Long) {
    activity?.let {
        startActivity(
                Intent("sanchez.sanchez.sergio.intent.action.SHOW_PERSON_DETAIL").apply {
                    putExtra("PERSON_ID", id)
                    setPackage(it.packageName)
                }
        )
    }
}