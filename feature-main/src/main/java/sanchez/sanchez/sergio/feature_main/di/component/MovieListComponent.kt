package sanchez.sanchez.sergio.feature_main.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.feature_main.di.module.movie.MovieListModule
import sanchez.sanchez.sergio.feature_main.di.module.movie.MovieListViewModelModule
import sanchez.sanchez.sergio.feature_main.ui.movie.MovieListFragment
import sanchez.sanchez.sergio.test.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movie List Component
 */
@PerFragment
@Subcomponent(modules = [ MovieListViewModelModule::class, MovieListModule::class ])
interface MovieListComponent: FragmentComponent {

    /**
     * inject
     */
    fun inject(movieListFragment: MovieListFragment)

}