package sanchez.sanchez.sergio.feature_tv_detail.di.module.tv

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.persistence.api.ITvRepository
import sanchez.sanchez.sergio.feature_tv_detail.persistence.api.TvRepositoryImpl
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.repository.ITvNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment
import sanchez.sanchez.sergio.test.core.persistence.db.repository.IDBRepository

/**
 * Tv Detail Repository Module
 */
@Module(includes = [ TvDetailNetworkModule::class, TvDetailDatabaseModule::class ])
class TvDetailRepositoryModule {

    /**
     * Provide Tv Repository
     * @param tvNetworkRepository
     * @param tvDBRepository
     */
    @PerFragment
    @Provides
    fun provideTvRepository(
        tvNetworkRepository: ITvNetworkRepository,
        tvDBRepository: IDBRepository<TvDetail>
    ): ITvRepository = TvRepositoryImpl(tvNetworkRepository, tvDBRepository)
}