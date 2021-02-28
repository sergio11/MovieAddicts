package sanchez.sanchez.sergio.feature_tv_detail.di.module.tv

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper.TvDetailNetworkMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper.TvKeywordNetworkMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper.TvReviewNetworkMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper.TvVideoNetworkMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.repository.ITvNetworkRepository
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.repository.TvNetworkRepositoryImpl
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.service.TvService
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment

/**
 * Tv Detail Network Module
 */
@Module
class TvDetailNetworkModule {

    /**
     * Provide Tv Service
     * @param retrofit
     */
    @Provides
    @PerFragment
    fun provideTvService(retrofit: Retrofit): TvService =
            retrofit.create(TvService::class.java)

    /**
     * Provide Tv Detail Network Mapper
     */
    @Provides
    @PerFragment
    fun privateTvDetailNetworkMapper(): TvDetailNetworkMapper = TvDetailNetworkMapper()

    /**
     * Provide Tv Keyword Network Mapper
     */
    @Provides
    @PerFragment
    fun privateTvKeywordNetworkMapper(): TvKeywordNetworkMapper = TvKeywordNetworkMapper()

    /**
     * Provide Tv Review Network Mapper
     */
    @Provides
    @PerFragment
    fun privateTvReviewNetworkMapper(): TvReviewNetworkMapper = TvReviewNetworkMapper()

    /**
     * Provide Tv Video Network Mapper
     */
    @Provides
    @PerFragment
    fun privateTvVideoNetworkMapper(): TvVideoNetworkMapper = TvVideoNetworkMapper()

    /**
     * Provide Tv Network Repository
     */
    @Provides
    @PerFragment
    fun provideTvNetworkRepository(
            tvService: TvService,
            tvDetailNetworkMapper: TvDetailNetworkMapper,
            tvKeywordNetworkMapper: TvKeywordNetworkMapper,
            tvReviewNetworkMapper: TvReviewNetworkMapper,
            tvVideoNetworkMapper: TvVideoNetworkMapper
    ): ITvNetworkRepository = TvNetworkRepositoryImpl(
            tvDetailNetworkMapper, tvKeywordNetworkMapper,
            tvReviewNetworkMapper, tvVideoNetworkMapper,
            tvService
    )

}