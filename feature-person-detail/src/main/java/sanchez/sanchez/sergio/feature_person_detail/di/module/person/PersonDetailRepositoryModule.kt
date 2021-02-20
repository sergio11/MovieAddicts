package sanchez.sanchez.sergio.feature_person_detail.di.module.person

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.api.IPeopleRepository
import sanchez.sanchez.sergio.feature_person_detail.persistence.api.PeopleRepositoryImpl
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.repository.IPeopleNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment
import sanchez.sanchez.sergio.test.core.persistence.db.repository.IDBRepository

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
            peopleDBRepository: IDBRepository<PersonDetail>
    ): IPeopleRepository = PeopleRepositoryImpl(peopleNetworkRepository, peopleDBRepository)
}