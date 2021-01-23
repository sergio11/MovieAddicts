package sanchez.sanchez.sergio.test.core.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class SupportActivity<T: ViewDataBinding>: AppCompatActivity() {

    protected val binding: T by lazy {
        DataBindingUtil.setContentView(this, layoutId())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        onInject()
        super.onCreate(savedInstanceState)
        initializeUI()
    }

    /**
     * On Inject
     */
    abstract fun onInject()

    /**
     * Initialize UI
     */
    abstract fun initializeUI()

    /**
     * Layout id
     */
    @LayoutRes
    abstract fun layoutId(): Int


}