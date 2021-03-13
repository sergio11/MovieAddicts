package sanchez.sanchez.sergio.feature_main.ui.core

import android.view.View

/**
 * Navigator Manager
 */
interface INavigatorManager {

    /**
     * Show Movie Detail
     * @param id
     * @param transitionImageView
     */
    fun showMovieDetail(id: Long, transitionImageView: View)

    /**
     * Show Person Detail
     * @param id
     * @param personTransitionImageView
     */
    fun showPersonDetail(id: Long, personTransitionImageView: View)

    /**
     * Show Tv Detail
     * @param id
     */
    fun showTvDetail(id: Long)

    /**
     * Show Login
     */
    fun showLogin()

}