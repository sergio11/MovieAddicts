package sanchez.sanchez.sergio.feature_main.ui.movie

import android.content.Intent

/**
 * Show Movie Detail
 */
fun MovieListFragment.showMovieDetail(id: Long) {
    activity?.let {
        startActivity(
                Intent("sanchez.sanchez.sergio.intent.action.SHOW_MOVIE_DETAIL").apply {
                    putExtra("MOVIE_ID", id)
                    setPackage(it.packageName)
                }
        )
    }
}