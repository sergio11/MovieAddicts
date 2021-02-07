package sanchez.sanchez.sergio.feature_person_detail.di.module.person

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.mapper.PersonDetailNetworkMapper
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.repository.IPeopleNetworkRepository
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.repository.PeopleNetworkRepositoryImpl
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.service.PeopleService
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Person Detail Network Module
 */
@Module
class PersonDetailNetworkModule {

    /**
     * Provide People Service
     * @param retrofit
     */
    @Provides
    @PerFragment
    fun providePeopleService(retrofit: Retrofit): PeopleService =
            retrofit.create(PeopleService::class.java)

    /**
     * Provide Person Detail Network Mapper
     */
    @Provides
    @PerFragment
    fun privatePersonDetailNetworkMapper(): PersonDetailNetworkMapper = PersonDetailNetworkMapper()

    /**
     * Provide People Network Repository
     */
    @Provides
    @PerFragment
    fun providePeopleNetworkRepository(
            peopleService: PeopleService,
            personDetailNetworkMapper: PersonDetailNetworkMapper
    ): IPeopleNetworkRepository = PeopleNetworkRepositoryImpl(
            personDetailNetworkMapper, peopleService
    )

}