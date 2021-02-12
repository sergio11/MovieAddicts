package sanchez.sanchez.sergio.feature_tv_detail.ui.tv

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_tv_detail.R
import sanchez.sanchez.sergio.feature_tv_detail.databinding.TvDetailFragmentBinding
import sanchez.sanchez.sergio.feature_tv_detail.di.component.TvDetailComponent
import sanchez.sanchez.sergio.feature_tv_detail.di.factory.FeatureTvDetailComponentFactory
import sanchez.sanchez.sergio.feature_tv_detail.ui.FeatureTvDetailActivity
import sanchez.sanchez.sergio.feature_tv_detail.ui.FeatureTvDetailActivityDelegate
import sanchez.sanchez.sergio.test.core.ui.SupportFragment
import java.lang.IllegalStateException

/**
 * Tv Detail Fragment
 */
class TvDetailFragment : SupportFragment<TvDetailViewModel, TvDetailFragmentBinding>(TvDetailViewModel::class.java) {

    private val component: TvDetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureTvDetailComponentFactory.buildTvDetailComponent(requireActivity() as AppCompatActivity)
    }

    private val tvVideoListAdapter by lazy {
        TvVideoListAdapter(requireContext(), mutableListOf())
    }

    private val tvReviewListAdapter by lazy {
        TvReviewListAdapter(requireContext(), mutableListOf())
    }

    lateinit var activityDelegate: FeatureTvDetailActivityDelegate

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context !is FeatureTvDetailActivityDelegate)
            throw IllegalStateException("Parent activity must implement a FeatureTvDetailActivityDelegate interface")
        activityDelegate = context
    }

    override fun layoutId(): Int = R.layout.tv_detail_fragment

    override fun onInject() {
        component.inject(this)
    }

    override fun onInitObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                with(binding) {
                    activity = requireActivity() as FeatureTvDetailActivity
                    tv = if(state.tvState is TvDetailContract.TvState.OnLoaded)
                        state.tvState.tv
                    else
                        null
                    tvVideoAdapter = tvVideoListAdapter
                    tvReviewAdapter = tvReviewListAdapter
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setEvent(TvDetailContract.Event.FetchTvDetail(activityDelegate.getTvId()))
    }
}