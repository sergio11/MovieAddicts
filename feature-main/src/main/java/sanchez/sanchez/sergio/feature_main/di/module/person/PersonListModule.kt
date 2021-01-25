package sanchez.sanchez.sergio.feature_main.di.module.person

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_main.domain.usecase.FetchPopularPeopleInteract
import sanchez.sanchez.sergio.feature_main.persistence.api.people.IPeopleRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

@Module(includes = [ PeopleRepositoryModule::class ])
class PersonListModule {

    /**
     * Provide Fetch Popular People Interact
     * @param peopleRepository
     */
    @PerFragment
    @Provides
    fun provideFetchPopularPeopleInteract(
        peopleRepository: IPeopleRepository
    ) = FetchPopularPeopleInteract(peopleRepository)

}