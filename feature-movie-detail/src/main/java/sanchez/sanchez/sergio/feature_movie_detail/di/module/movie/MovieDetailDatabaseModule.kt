package sanchez.sanchez.sergio.feature_movie_detail.di.module.movie


import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_movie_detail.BuildConfig
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Video
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper.MovieDetailEntityMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper.MovieKeywordEntityMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper.MovieReviewEntityMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper.MovieVideoEntityMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.*
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.ObjectBoxManager
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.objectbox.ObjectBoxRepositoryConfiguration
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.objectbox.SupportObjectBoxRepositoryImpl

/**
 * Movie Detail Database Module
 */
@Module
class MovieDetailDatabaseModule {

    /**
     * Provide Movie Keyword Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideMovieKeywordEntityMapper(): IEntityToModelMapper<KeywordEntity, Keyword>
            = MovieKeywordEntityMapper()

    /**
     * Provide Movie Review Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideMovieReviewEntityMapper(): IEntityToModelMapper<ReviewEntity, Review>
        = MovieReviewEntityMapper()

    /**
     * Provide Movie Video Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideMovieVideoEntityMapper(): IEntityToModelMapper<VideoEntity, Video>
        = MovieVideoEntityMapper()

    /**
     * Provide Movie Detail Entity Mapper
     * @param movieKeywordEntityMapper
     * @param movieReviewEntityMapper
     * @param movieVideoEntityMapper
     */
    @Provides
    @PerFragment
    fun provideMovieDetailEntityMapper(
         movieKeywordEntityMapper: IEntityToModelMapper<KeywordEntity, Keyword>,
         movieReviewEntityMapper: IEntityToModelMapper<ReviewEntity, Review> ,
         movieVideoEntityMapper: IEntityToModelMapper<VideoEntity, Video>
    ): IEntityToModelMapper<MovieDetailEntity, MovieDetail> = MovieDetailEntityMapper(
        movieKeywordEntityMapper, movieReviewEntityMapper,
        movieVideoEntityMapper
    )

    /**
     * Provide Box Store
     * @param appContext
     * @param objectBoxManager
     */
    @Provides
    @PerFragment
    fun provideBoxStore(appContext: Context, objectBoxManager: ObjectBoxManager): BoxStore =
            objectBoxManager.getBoxStore(BuildConfig.BOX_STORE_NAME) ?:
                MyObjectBox.builder()
                    .androidContext(appContext)
                    .name(BuildConfig.BOX_STORE_NAME)
                    .build().also {
                        objectBoxManager.registerBoxStore(BuildConfig.BOX_STORE_NAME, it)
                    }

    /**
     * Provide Movie Detail DAO
     * @param boxStore
     */
    @Provides
    @PerFragment
    fun provideMovieDetailDAO(boxStore: BoxStore): Box<MovieDetailEntity> =
            boxStore.boxFor(MovieDetailEntity::class.java)

    /**
     * Provide Object Box Configuration
     */
    @Provides
    @PerFragment
    fun provideObjectBoxConfiguration(): ObjectBoxRepositoryConfiguration<MovieDetailEntity>
            = ObjectBoxRepositoryConfiguration(
            maxObjectsAllowed = MAX_OBJECTS_ALLOWED,
            objectsExpireInMillis = OBJECTS_EXPIRE_IN_MILLIS,
            objectIdProperty = MovieDetailEntity_.id,
            savedAtInMillisProperty = MovieDetailEntity_.savedAtInMillis)

    /**
     * Provide Movie DB Repository
     * @param movieDetailDAO
     * @param movieDetailEntityMapper
     */
    @Provides
    @PerFragment
    fun provideMovieDBRepository(
        movieDetailDAO: Box<MovieDetailEntity>,
        movieDetailEntityMapper: IEntityToModelMapper<MovieDetailEntity, MovieDetail>,
        objectBoxRepositoryConfiguration: ObjectBoxRepositoryConfiguration<MovieDetailEntity>
    ): IDBRepository<MovieDetail> =
        SupportObjectBoxRepositoryImpl(movieDetailDAO, movieDetailEntityMapper, objectBoxRepositoryConfiguration)


    companion object {
        private const val MAX_OBJECTS_ALLOWED = 20
        private const val OBJECTS_EXPIRE_IN_MILLIS = 86400000 // 24 hours
    }

}