package sanchez.sanchez.sergio.feature_main.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.feature_main.di.module.tv.TvListModule
import sanchez.sanchez.sergio.feature_main.di.module.tv.TvListViewModelModule
import sanchez.sanchez.sergio.feature_main.ui.tv.TvListFragment
import sanchez.sanchez.sergio.test.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Tv List Component
 */
@PerFragment
@Subcomponent(modules = [ TvListViewModelModule::class, TvListModule::class ])
interface TvListComponent: FragmentComponent {

    /**
     * Inject into
     */
    fun inject(tvListFragment: TvListFragment)

}