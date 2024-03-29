package sanchez.sanchez.sergio.movie_addicts.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class SupportFragment<VM : ViewModel, VB: ViewDataBinding>(private val mViewModelClass: Class<VM>): Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var parentActivity: AppCompatActivity

    // View Model
    lateinit var viewModel: VM

    // Binding
    lateinit var binding: VB

    /**
     * on Create
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        onAttachComponent()
        super.onCreate(savedInstanceState)
        viewModel = initViewModel()
        onInitObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return binding.root
    }

    override fun onDestroy() {
        onDetachComponent()
        super.onDestroy()
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
     * Layout Id
     */
    @LayoutRes
    abstract fun layoutId(): Int

    /**
     * On Init Observers
     */
    abstract fun onInitObservers()

    /**
     * Private Methods
     */

    /**
     * Get View Model
     */
    private fun initViewModel(): VM =
            ViewModelProvider(this, viewModelFactory).get(mViewModelClass)
    
}