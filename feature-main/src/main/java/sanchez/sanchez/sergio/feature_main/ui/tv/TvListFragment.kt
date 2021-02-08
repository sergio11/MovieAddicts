package sanchez.sanchez.sergio.feature_main.ui.tv

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.FragmentTvListBinding
import sanchez.sanchez.sergio.feature_main.di.component.TvListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.test.core.ui.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportFragment

/**
 * Tv List Fragment
 */
class TvListFragment : SupportFragment<TvListViewModel, FragmentTvListBinding>(TvListViewModel::class.java), TvListAdapter.OnTvClickListener {

    private val component: TvListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getTvListComponent(requireActivity() as AppCompatActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_tv_list

    override fun onInject() {
        component.inject(this)
    }

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {
                with(binding) {
                    uiState = it.lceState
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            adapter = TvListAdapter(
                    context = requireContext(),
                    data = mutableListOf(),
                    tvItemListener = this@TvListFragment
            )
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.setEvent(LCEContract.Event.OnFetchData())
            }
        }

        viewModel.setEvent(LCEContract.Event.OnFetchData())
    }

    /**
     *  On Tv Clicked
     *  @param tv
     */
    override fun onTvClicked(tv: Tv) {
        showTvDetail(tv.id)
    }

}