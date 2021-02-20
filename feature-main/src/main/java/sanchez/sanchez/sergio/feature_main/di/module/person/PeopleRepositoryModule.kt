package sanchez.sanchez.sergio.feature_main.di.module.person

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.api.people.IPeopleRepository
import sanchez.sanchez.sergio.feature_main.persistence.api.people.PeopleRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.people.IPeopleNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment
import sanchez.sanchez.sergio.test.core.persistence.db.repository.IDBRepository

/**
 * People Repository Module
 */
@Module(includes = [ PeopleNetworkModule::class, PeopleDatabaseModule::class ])
class PeopleRepositoryModule {

    /**
     * Provide People Repository
     * @param peopleNetworkRepository
     * @param peopleDBRepository
     */
    @PerFragment
    @Provides
    fun providePeopleRepository(
        peopleNetworkRepository: IPeopleNetworkRepository,
        peopleDBRepository: IDBRepository<Person>
    ): IPeopleRepository = PeopleRepositoryImpl(peopleNetworkRepository, peopleDBRepository)

}