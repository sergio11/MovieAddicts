package sanchez.sanchez.sergio.feature_person_detail.di.module.person

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_person_detail.persistence.api.IPeopleRepository
import sanchez.sanchez.sergio.feature_person_detail.persistence.api.PeopleRepositoryImpl
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.repository.IPeopleDBRepository
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.repository.IPeopleNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Person Detail Repository Module
 */
@Module(includes = [ PersonDetailNetworkModule::class, PersonDetailDatabaseModule::class ])
class PersonDetailRepositoryModule {

    /**
     * Provide People Repository
     * @param peopleNetworkRepository
     * @param peopleDBRepository
     */
    @PerFragment
    @Provides
    fun providePeopleRepository(
            peopleNetworkRepository: IPeopleNetworkRepository,
            peopleDBRepository: IPeopleDBRepository
    ): IPeopleRepository = PeopleRepositoryImpl(peopleNetworkRepository, peopleDBRepository)
}