package sanchez.sanchez.sergio.feature_main.di.module.person

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sanchez.sanchez.sergio.feature_main.persistence.network.mapper.PersonNetworkMapper
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.people.IPeopleNetworkRepository
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.people.PeopleNetworkRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.network.service.PeopleService
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment

/**
 * People Network Module
 */
@Module
class PeopleNetworkModule {

    /**
     * Provide People Service
     * @param retrofit
     */
    @Provides
    @PerFragment
    fun providePeopleService(retrofit: Retrofit): PeopleService =
            retrofit.create(PeopleService::class.java)

    /**
     * Provide People Network Mapper
     */
    @Provides
    @PerFragment
    fun providePersonNetworkMapper(): PersonNetworkMapper = PersonNetworkMapper()

    /**
     * Provide People Network Repository
     * @param peopleService
     * @param personNetworkMapper
     *
     */
    @Provides
    @PerFragment
    fun providePeopleNetworkRepository(
        peopleService: PeopleService,
        personNetworkMapper: PersonNetworkMapper
    ): IPeopleNetworkRepository = PeopleNetworkRepositoryImpl(peopleService, personNetworkMapper)

}