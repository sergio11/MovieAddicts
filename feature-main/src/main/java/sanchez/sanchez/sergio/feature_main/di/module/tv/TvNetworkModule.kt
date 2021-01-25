package sanchez.sanchez.sergio.feature_main.di.module.tv

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sanchez.sanchez.sergio.feature_main.persistence.network.mapper.TvNetworkMapper
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.tv.DiscoverTvNetworkRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.tv.IDiscoverTvNetworkRepository
import sanchez.sanchez.sergio.feature_main.persistence.network.service.DiscoverTvService
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Tv Network Module
 */
@Module
class TvNetworkModule {

    /**
     * Provide Discover Tv Service
     * @param retrofit
     */
    @Provides
    @PerFragment
    fun provideDiscoverTvService(retrofit: Retrofit): DiscoverTvService =
            retrofit.create(DiscoverTvService::class.java)

    /**
     * Provide Tv Network Mapper
     */
    @Provides
    @PerFragment
    fun provideTvNetworkMapper(): TvNetworkMapper = TvNetworkMapper()

    /**
     * Provide People Network Repository
     * @param discoverTvService
     * @param tvNetworkMapper
     *
     */
    @Provides
    @PerFragment
    fun providePeopleNetworkRepository(
        discoverTvService: DiscoverTvService,
        tvNetworkMapper: TvNetworkMapper
    ): IDiscoverTvNetworkRepository = DiscoverTvNetworkRepositoryImpl(discoverTvService, tvNetworkMapper)

}