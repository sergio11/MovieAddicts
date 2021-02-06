package sanchez.sanchez.sergio.feature_main.ui.tv

import android.content.Intent

/**
 * Show Tv Detail
 */
fun TvListFragment.showTvDetail(id: Long) {
    activity?.let {
        startActivity(
                Intent("sanchez.sanchez.sergio.intent.action.SHOW_TV_DETAIL").apply {
                    putExtra("TV_ID", id)
                    setPackage(it.packageName)
                }
        )
    }
}