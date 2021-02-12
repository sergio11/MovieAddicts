package sanchez.sanchez.sergio.feature_person_detail.ui.person

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import sanchez.sanchez.sergio.feature_person_detail.R
import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.test.core.extension.visible

/**
 * Person Detail Binding
 */
object PersonDetailBinding {

    /**
     * Bind Back Drop
     * @param view
     * @param person
     */
    @JvmStatic
    @BindingAdapter("bindBackDrop")
    fun bindBackDrop(view: ImageView, person: PersonDetail?) {
        person?.profilePath?.let {
            Glide.with(view.context).load(it)
                    .apply(RequestOptions().circleCrop())
                    .into(view)
        }
    }

    /**
     * Bind Biography
     * @param view
     * @param personDetail
     */
    @JvmStatic
    @BindingAdapter("bindBiography")
    fun bindBiography(view: TextView, personDetail: PersonDetail?) {
        view.text = personDetail?.biography
    }

    /**
     * Bind Name Tag List
     * @param chipGroup
     * @param personDetail
     */
    @JvmStatic
    @BindingAdapter("bindNameTagList")
    fun bindNameTagList(chipGroup: ChipGroup, personDetail: PersonDetail?) {
        personDetail?.alsoKnownAs?.let {
            chipGroup.visible()
            for (nameTag in it) {
                chipGroup.addView(
                        Chip(chipGroup.context).apply {
                            text = nameTag
                            isCheckable = false
                            setTextAppearanceResource(R.style.ChipTextStyle)
                            setChipBackgroundColorResource(R.color.colorPrimary)
                        }
                )
            }
        }
    }

}