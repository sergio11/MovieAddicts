package sanchez.sanchez.sergio.movie_addicts.core.extension

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

fun AppCompatActivity.navController(@IdRes navHostId: Int): NavController? =
    supportFragmentManager.findFragmentById(navHostId)?.let {
        return if(it is NavHostFragment) {
            it.navController
        } else {
            null
        }
    }

fun Fragment.navController(@IdRes navHostId: Int): NavController? =
    childFragmentManager.findFragmentById(navHostId)?.let {
        return if(it is NavHostFragment) {
            it.navController
        } else {
            null
        }
    }