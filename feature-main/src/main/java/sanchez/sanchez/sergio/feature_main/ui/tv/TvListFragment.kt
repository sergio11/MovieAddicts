package sanchez.sanchez.sergio.feature_main.ui.tv

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.FragmentTvListBinding
import sanchez.sanchez.sergio.feature_main.di.component.TvListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.test.core.ui.LCEContract
import sanchez.sanchez.sergio.test.core.ui.SupportFragment
import sanchez.sanchez.sergio.test.core.ui.SupportRecyclerViewPagination

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
            recyclerView.apply {
                addItemDecoration(object: RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                        super.getItemOffsets(outRect, view, parent, state)
                        val commonPadding = requireContext().resources.getDimension(R.dimen.common_small_padding).toInt()
                        outRect.apply {
                            left = commonPadding
                            right = commonPadding
                            top = commonPadding
                            bottom = commonPadding
                        }
                    }
                })
                SupportRecyclerViewPagination(
                        recyclerView = this,
                        isLoading = { viewModel.isLoading() },
                        loadMore = { viewModel.setEvent(LCEContract.Event.OnLoadNextPage) },
                        onLast = { false }
                )
            }
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.setEvent(LCEContract.Event.OnLoadInitialData)
            }
        }

        viewModel.setEvent(LCEContract.Event.OnLoadInitialData)
    }

    /**
     *  On Tv Clicked
     *  @param tv
     */
    override fun onTvClicked(tv: Tv) {
        showTvDetail(tv.id)
    }

}