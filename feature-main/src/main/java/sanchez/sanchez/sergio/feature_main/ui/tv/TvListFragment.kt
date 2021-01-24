package sanchez.sanchez.sergio.feature_main.ui.tv

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.FragmentTvListBinding
import sanchez.sanchez.sergio.feature_main.di.component.TvListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.test.core.ui.SupportFragment

class TvListFragment : SupportFragment<TvListViewModel, FragmentTvListBinding>(TvListViewModel::class.java) {

    private val component: TvListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getTvListComponent(requireActivity() as AppCompatActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_tv_list

    override fun onInject() {
        component.inject(this)
    }

}