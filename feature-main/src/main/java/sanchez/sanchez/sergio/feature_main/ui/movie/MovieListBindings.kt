package sanchez.sanchez.sergio.feature_main.ui.movie

import android.view.View
import androidx.databinding.BindingAdapter
import sanchez.sanchez.sergio.movie_addicts.core.extension.gone
import sanchez.sanchez.sergio.movie_addicts.core.extension.visible

object MovieListBindings {

    /**
     * Bind Visibility By Favorite State
     * @param view
     * @param favoriteState
     */
    @JvmStatic
    @BindingAdapter("bindVisibilityByFavoriteState")
    fun bindVisibilityByFavoriteState(view: View, favoriteState: Boolean?) {
        favoriteState?.let {
            if(it)
                view.visible()
            else
                view.gone()
        }

    }
}