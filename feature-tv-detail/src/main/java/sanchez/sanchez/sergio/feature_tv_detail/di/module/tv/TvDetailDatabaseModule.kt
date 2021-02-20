package sanchez.sanchez.sergio.feature_tv_detail.di.module.tv

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_tv_detail.BuildConfig.BOX_STORE_NAME
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Video
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper.TvDetailEntityMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper.TvKeywordEntityMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper.TvReviewEntityMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper.TvVideoEntityMapper
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model.*
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment
import sanchez.sanchez.sergio.test.core.persistence.db.mapper.IEntityToModelMapper
import sanchez.sanchez.sergio.test.core.persistence.db.repository.IDBRepository
import sanchez.sanchez.sergio.test.core.persistence.db.repository.objectbox.ObjectBoxRepositoryConfiguration
import sanchez.sanchez.sergio.test.core.persistence.db.repository.objectbox.SupportObjectBoxRepositoryImpl

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
    fun provideTvKeywordEntityMapper(): IEntityToModelMapper<KeywordEntity, Keyword>
        = TvKeywordEntityMapper()

    /**
     * Provide Tv Review Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideTvReviewEntityMapper(): IEntityToModelMapper<ReviewEntity, Review>
        = TvReviewEntityMapper()

    /**
     * Provide Tv Video Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideTvVideoEntityMapper(): IEntityToModelMapper<VideoEntity, Video>
        = TvVideoEntityMapper()

    /**
     * Provide Tv Detail Entity Mapper
     * @param tvKeywordEntityMapper
     * @param tvReviewEntityMapper
     * @param tvVideoEntityMapper
     */
    @Provides
    @PerFragment
    fun provideTvDetailEntityMapper(
        tvKeywordEntityMapper: IEntityToModelMapper<KeywordEntity, Keyword>,
        tvReviewEntityMapper: IEntityToModelMapper<ReviewEntity, Review>,
        tvVideoEntityMapper: IEntityToModelMapper<VideoEntity, Video>
    ): IEntityToModelMapper<TvDetailEntity, TvDetail> = TvDetailEntityMapper(
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
     * Provide Object Box Configuration
     */
    @Provides
    @PerFragment
    fun provideObjectBoxConfiguration(): ObjectBoxRepositoryConfiguration<TvDetailEntity>
            = ObjectBoxRepositoryConfiguration(
            maxObjectsAllowed = MAX_OBJECTS_ALLOWED,
            objectsExpireInMillis = OBJECTS_EXPIRE_IN_MILLIS,
            objectIdProperty = TvDetailEntity_.id,
            savedAtInMillisProperty = TvDetailEntity_.savedAtInMillis)

    /**
     * Provide Tv DB Repository
     * @param tvDetailDAO
     * @param tvDetailEntityMapper
     */
    @Provides
    @PerFragment
    fun provideTvDBRepository(
        tvDetailDAO: Box<TvDetailEntity>,
        tvDetailEntityMapper: IEntityToModelMapper<TvDetailEntity, TvDetail>,
        objectBoxRepositoryConfiguration: ObjectBoxRepositoryConfiguration<TvDetailEntity>
    ): IDBRepository<TvDetail> =
        SupportObjectBoxRepositoryImpl(tvDetailDAO, tvDetailEntityMapper,
                objectBoxRepositoryConfiguration)


    companion object {
        private const val MAX_OBJECTS_ALLOWED = 20
        private const val OBJECTS_EXPIRE_IN_MILLIS = 86400000 // 24 hours
    }
}