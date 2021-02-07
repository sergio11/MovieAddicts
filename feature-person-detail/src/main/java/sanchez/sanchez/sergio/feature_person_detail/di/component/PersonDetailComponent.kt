package sanchez.sanchez.sergio.feature_person_detail.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.feature_person_detail.di.module.person.PersonDetailModule
import sanchez.sanchez.sergio.feature_person_detail.di.module.person.PersonDetailViewModelModule
import sanchez.sanchez.sergio.feature_person_detail.ui.person.PersonDetailFragment
import sanchez.sanchez.sergio.test.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Person Detail Component
 */
@PerFragment
@Subcomponent(modules = [ PersonDetailViewModelModule::class, PersonDetailModule::class ])
interface PersonDetailComponent: FragmentComponent {

    /**
     * inject into
     * @param personDetailFragment
     */
    fun inject(personDetailFragment: PersonDetailFragment)
}