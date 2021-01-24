package sanchez.sanchez.sergio.feature_main.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.feature_main.di.module.movie.MovieListModule
import sanchez.sanchez.sergio.feature_main.di.module.person.PersonListViewModelModule
import sanchez.sanchez.sergio.feature_main.ui.person.PersonListFragment
import sanchez.sanchez.sergio.test.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Person List Component
 */
@PerFragment
@Subcomponent(modules = [ PersonListViewModelModule::class, MovieListModule::class ])
interface PersonListComponent: FragmentComponent {

    fun inject(personListFragment: PersonListFragment)

}