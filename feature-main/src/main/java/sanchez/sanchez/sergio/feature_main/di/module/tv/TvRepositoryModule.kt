package sanchez.sanchez.sergio.feature_main.di.module.tv

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_main.persistence.api.tv.DiscoverTvRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.api.tv.IDiscoverTvRepository
import sanchez.sanchez.sergio.feature_main.persistence.db.repository.tv.IDiscoverTvDBRepository
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.tv.IDiscoverTvNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Tv Repository Module
 */
@Module(includes = [ TvNetworkModule::class, TvDatabaseModule::class ])
class TvRepositoryModule {

    /**
     * Provide Tv Repository
     * @param discoverTvNetworkRepository
     * @param tvDBRepository
     */
    @PerFragment
    @Provides
    fun provideTvRepository(
        discoverTvNetworkRepository: IDiscoverTvNetworkRepository,
        tvDBRepository: IDiscoverTvDBRepository
    ): IDiscoverTvRepository = DiscoverTvRepositoryImpl(discoverTvNetworkRepository, tvDBRepository)

}