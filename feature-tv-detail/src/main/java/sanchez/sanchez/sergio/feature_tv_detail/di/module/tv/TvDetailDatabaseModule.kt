package sanchez.sanchez.sergio.feature_tv_detail.di.module.tv

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_tv_detail.BuildConfig.BOX_STORE_NAME
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper.TvDetailEntityMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper.TvKeywordEntityMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper.TvReviewEntityMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper.TvVideoEntityMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model.MyObjectBox
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model.TvDetailEntity
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.repository.ITvDBRepository
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.repository.TvDBRepositoryImpl
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Tv Detail Database Module
 */
@Module
class TvDetailDatabaseModule {

    /**
     * Provide Box Store
     * @param appContext
     */
    @Provides
    @PerFragment
    fun provideBoxStore(appContext: Context): BoxStore =
        MyObjectBox.builder()
            .androidContext(appContext)
            .name(BOX_STORE_NAME)
            .build()

    /**
     * Provide Tv Keyword Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideTvKeywordEntityMapper() = TvKeywordEntityMapper()

    /**
     * Provide Tv Review Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideTvReviewEntityMapper() = TvReviewEntityMapper()

    /**
     * Provide Tv Video Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideTvVideoEntityMapper() = TvVideoEntityMapper()

    /**
     * Provide Tv Detail Entity Mapper
     * @param tvKeywordEntityMapper
     * @param tvReviewEntityMapper
     * @param tvVideoEntityMapper
     */
    @Provides
    @PerFragment
    fun provideTvDetailEntityMapper(
        tvKeywordEntityMapper: TvKeywordEntityMapper,
        tvReviewEntityMapper: TvReviewEntityMapper,
        tvVideoEntityMapper: TvVideoEntityMapper
    ) = TvDetailEntityMapper(
        tvKeywordEntityMapper, tvReviewEntityMapper,
        tvVideoEntityMapper
    )

    /**
     * Provide Tv Detail DAO
     * @param boxStore
     */
    @Provides
    @PerFragment
    fun provideTvDetailDAO(boxStore: BoxStore): Box<TvDetailEntity> =
        boxStore.boxFor(TvDetailEntity::class.java)

    /**
     * Provide Tv DB Repository
     * @param tvDetailDAO
     * @param tvDetailEntityMapper
     */
    @Provides
    @PerFragment
    fun provideTvDBRepository(
        tvDetailDAO: Box<TvDetailEntity>,
        tvDetailEntityMapper: TvDetailEntityMapper
    ): ITvDBRepository =
        TvDBRepositoryImpl(tvDetailDAO, tvDetailEntityMapper)

}