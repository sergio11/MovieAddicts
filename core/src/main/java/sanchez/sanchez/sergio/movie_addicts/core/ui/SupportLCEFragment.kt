package sanchez.sanchez.sergio.movie_addicts.core.ui

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import sanchez.sanchez.sergio.R
import sanchez.sanchez.sergio.databinding.FragmentSupportLceBinding

/**
 * Support LCE (Loading/Content/Error) Fragment
 */
abstract class SupportLCEFragment<VM : SupportLCEViewModel, E, VH: SupportAdapter.SupportViewHolder<E>>(mViewModelClass: Class<VM>)
    : SupportFragment<VM, FragmentSupportLceBinding>(mViewModelClass) {


    private var supportAdapter: SupportAdapter<VH, E>? = null

    override fun layoutId(): Int = R.layout.fragment_support_lce

    /**
     * On Init Observers
     */
    override fun onInitObservers() {
        Log.d("PERSON_L", "onInitObservers CALLED")
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {
                with(binding) {
                    uiState = it.lceState
                    @Suppress("UNCHECKED_CAST")
                    (it.lceState as? LCEContract.LCEState.OnLoaded<E>)?.let {
                        supportAdapter?.addData(it.pageData.data)
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.effect.collect {
                if(it is LCEContract.Effect.OnShowError)
                    Snackbar.make(requireContext(), binding.swipeRefreshLayout,
                            getString(R.string.common_error),
                            Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
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
                        onLast = { viewModel.isLastPage() }
                )

                adapter = onBuildAdapter().also {
                    supportAdapter = it
                }
            }

            swipeRefreshLayout.apply {
                setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimaryDark))
                setProgressBackgroundColorSchemeColor(ContextCompat.getColor(requireContext(), android.R.color.black))
                setOnRefreshListener {
                    viewModel.setEvent(LCEContract.Event.OnLoadInitialData)
                }
            }
        }

        viewModel.setEvent(LCEContract.Event.OnLoadInitialData)
    }

    /**
     * On Build Adapter
     */
    abstract fun  onBuildAdapter(): SupportAdapter<VH, E>
}