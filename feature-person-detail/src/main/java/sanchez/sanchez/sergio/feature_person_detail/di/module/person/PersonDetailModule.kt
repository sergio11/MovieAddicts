package sanchez.sanchez.sergio.feature_person_detail.di.module.person

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_person_detail.domain.usecase.GetPersonDetailInteract
import sanchez.sanchez.sergio.feature_person_detail.persistence.api.IPeopleRepository
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment

/**
 * Person Detail Module
 */
@Module(includes = [ PersonDetailRepositoryModule::class ])
class PersonDetailModule {

    /**
     * Provide Get Person Detail Interact
     * @param peopleRepository
     */
    @PerFragment
    @Provides
    fun provideGetPersonDetailInteract(
        peopleRepository: IPeopleRepository
    ) = GetPersonDetailInteract(peopleRepository)

}