package sanchez.sanchez.sergio.feature_main.ui.tv

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.test.core.ui.SupportAdapter
import sanchez.sanchez.sergio.test.core.ui.SupportLCEFragment

/**
 * Tv List Fragment
 */
class TvListFragment : SupportLCEFragment<TvListViewModel, Tv, TvListAdapter.TvViewHolder>(TvListViewModel::class.java), TvListAdapter.OnTvClickListener {

    override fun onAttachComponent() {
        FeatureMainComponentFactory.getTvListComponent(requireActivity() as AppCompatActivity)
                .inject(this)
    }

    override fun onDetachComponent() {
        FeatureMainComponentFactory.removeTvListComponent()
    }

    override fun onBuildAdapter(): SupportAdapter<TvListAdapter.TvViewHolder, Tv> =
            TvListAdapter(
                    context = requireContext(),
                    data = mutableListOf(),
                    tvItemListener = this@TvListFragment
            )

    /**
     *  On Tv Clicked
     *  @param tv
     */
    override fun onTvClicked(tv: Tv) {
        showTvDetail(tv.id)
    }


}