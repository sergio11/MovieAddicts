package sanchez.sanchez.sergio.feature_main.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.feature_main.di.module.person.PersonListModule
import sanchez.sanchez.sergio.feature_main.di.module.person.PersonListViewModelModule
import sanchez.sanchez.sergio.feature_main.ui.person.PeopleListFragment
import sanchez.sanchez.sergio.movie_addicts.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment

/**
 * Person List Component
 */
@PerFragment
@Subcomponent(modules = [ PersonListViewModelModule::class, PersonListModule::class ])
interface PeopleListComponent: FragmentComponent {

    /**
     * Inject into
     */
    fun inject(peopleListFragment: PeopleListFragment)

}