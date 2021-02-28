package sanchez.sanchez.sergio.feature_tv_detail.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.feature_tv_detail.di.module.tv.TvDetailModule
import sanchez.sanchez.sergio.feature_tv_detail.di.module.tv.TvDetailViewModelModule
import sanchez.sanchez.sergio.feature_tv_detail.ui.tv.TvDetailFragment
import sanchez.sanchez.sergio.movie_addicts.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment

@PerFragment
@Subcomponent(modules = [ TvDetailViewModelModule::class, TvDetailModule::class  ])
interface TvDetailComponent: FragmentComponent {

    /**
     * Inject into
     */

    fun inject(fragment: TvDetailFragment)

}