package sanchez.sanchez.sergio.feature_main.ui.tv

import android.content.Context
import android.view.View
import android.view.ViewGroup
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.ui.core.SupportAdapter

/**
 * Tv List Adapter
 * @param context
 * @param data
 * @param tvItemListener
 */
class TvListAdapter(
        context: Context,
        data: MutableList<Tv>,
        private val tvItemListener: OnTvClickListener,
): SupportAdapter<TvListAdapter.TvViewHolder, Tv>(context, data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder =
            TvViewHolder(inflateLayout(R.layout.tv_item_layout, parent))

    interface OnTvClickListener {

        /**
         * on Tv Clicked
         * @param tv
         */
        fun onTvClicked(tv: Tv)
    }

    /**
     * Tv View Holder
     * @param itemView
     */
    inner class TvViewHolder(itemView: View): SupportAdapter.SupportViewHolder<Tv>(itemView) {
        override fun bind(model: Tv) {
            itemView.setOnClickListener {
                tvItemListener.onTvClicked(model)
            }
        }
    }
}