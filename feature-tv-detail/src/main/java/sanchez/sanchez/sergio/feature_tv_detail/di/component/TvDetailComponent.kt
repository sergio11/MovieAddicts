package sanchez.sanchez.sergio.feature_tv_detail.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.feature_tv_detail.di.module.tv.TvDetailViewModelModule
import sanchez.sanchez.sergio.feature_tv_detail.ui.tv.TvDetailFragment
import sanchez.sanchez.sergio.test.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

@PerFragment
@Subcomponent(modules = [ TvDetailViewModelModule::class  ])
interface TvDetailComponent: FragmentComponent {

    /**
     * Inject into
     */

    fun inject(fragment: TvDetailFragment)

}