package sanchez.sanchez.sergio.feature_main.di.module.tv

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_main.persistence.api.tv.DiscoverTvRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.tv.IDiscoverTvNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Tv Repository Module
 */
@Module(includes = [ TvNetworkModule::class ])
class TvRepositoryModule {

    /**
     * Provide Tv Repository
     * @param discoverTvNetworkRepository
     */
    @PerFragment
    @Provides
    fun provideTvRepository(
        discoverTvNetworkRepository: IDiscoverTvNetworkRepository
    ) = DiscoverTvRepositoryImpl(discoverTvNetworkRepository)

}