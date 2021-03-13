package sanchez.sanchez.sergio.feature_tv_detail.ui.tv

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_tv_detail.R
import sanchez.sanchez.sergio.feature_tv_detail.databinding.TvDetailFragmentBinding
import sanchez.sanchez.sergio.feature_tv_detail.di.factory.FeatureTvDetailComponentFactory
import sanchez.sanchez.sergio.feature_tv_detail.ui.FeatureTvDetailActivity
import sanchez.sanchez.sergio.feature_tv_detail.ui.FeatureTvDetailActivityDelegate
import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportFragment
import java.lang.IllegalStateException
import kotlin.math.abs

/**
 * Tv Detail Fragment
 */
class TvDetailFragment : SupportFragment<TvDetailViewModel, TvDetailFragmentBinding>(TvDetailViewModel::class.java) {

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

    override fun onAttachComponent() {
        FeatureTvDetailComponentFactory.getTvDetailComponent(requireActivity() as AppCompatActivity)
                .inject(this)
    }

    override fun onDetachComponent() {
        FeatureTvDetailComponentFactory.removeTvDetailComponent()
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

        lifecycleScope.launchWhenStarted {
            viewModel.effect.collect {
                if(it is TvDetailContract.Effect.OnShowError)
                    Snackbar.make(requireView(), getString(R.string.common_error), Snackbar.LENGTH_LONG).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setEvent(TvDetailContract.Event.FetchTvDetail(activityDelegate.getTvId()))
        with(binding) {
            appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (abs(verticalOffset) == appBarLayout.totalScrollRange) {
                    configureHomeAsUpIndicatorWithColor(android.R.color.black)
                } else {
                    configureHomeAsUpIndicatorWithColor(R.color.colorPrimaryDark)
                }
            })
        }
    }

    /**
     * Private Methods
     */

    private fun configureHomeAsUpIndicatorWithColor(color: Int) {
        ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_arrow_back_24)?.let {
            DrawableCompat.setTint(it, requireContext().getColor(color))
            parentActivity.supportActionBar?.setHomeAsUpIndicator(it)
        }
    }
}