package sanchez.sanchez.sergio.movie_addicts.core.ui

import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import sanchez.sanchez.sergio.movie_addicts.core.extension.navController

abstract class SupportActivity<T: ViewDataBinding>: AppCompatActivity() {

    protected lateinit var binding: T

    protected var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        onAttachComponent()
        super.onCreate(savedInstanceState)
        // Create Binding
        binding = DataBindingUtil.setContentView(this, layoutId())
        // Configure Navigation Controller
        navHostId()?.let {
            navController(it)?.let { navCon ->
                navController = navCon
                onSetupNavigation(savedInstanceState, navCon)
            }
        }
        initializeUI()
    }

    override fun onDestroy() {
        onDetachComponent()
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Delegate activity result to fragments
        delegateActivityResult(requestCode, resultCode, data, supportFragmentManager)
    }

    private fun delegateActivityResult(requestCode: Int, resultCode: Int, data: Intent?, fragmentManager: FragmentManager){
        for (fragment in fragmentManager.fragments) {
            if(fragment.childFragmentManager.fragments.isNotEmpty())
                delegateActivityResult(requestCode, resultCode, data, fragment.childFragmentManager)
            else {
                fragment.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    /**
     * If you want to inject Dependency Injection
     * on your activity, you can override this.
     */
    abstract fun onAttachComponent()

    /**
     * Using this method for remove component
     */
    abstract fun onDetachComponent()

    /**
     * Initialize UI
     */
    abstract fun initializeUI()

    /**
     * Layout id
     */
    @LayoutRes
    abstract fun layoutId(): Int

    /**
     * Nav Host Id
     */
    @IdRes
    open fun navHostId(): Int? = null

    /**
     * On Setup Navigation
     */
    open fun onSetupNavigation(savedInstanceState: Bundle?, navController: NavController){}

}