package sanchez.sanchez.sergio.feature_movie_detail.di.module.movie

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_movie_detail.BuildConfig.BOX_STORE_NAME
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper.MovieDetailEntityMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper.MovieKeywordEntityMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper.MovieReviewEntityMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper.MovieVideoEntityMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.MovieDetailEntity
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.MyObjectBox
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.repository.IMoviesDBRepository
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.repository.MovieDBRepositoryImpl
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movie Detail Database Module
 */
@Module
class MovieDetailDatabaseModule {

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
     * Provide Movie Keyword Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideMovieKeywordEntityMapper() = MovieKeywordEntityMapper()

    /**
     * Provide Movie Review Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideMovieReviewEntityMapper() = MovieReviewEntityMapper()

    /**
     * Provide Movie Video Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideMovieVideoEntityMapper() = MovieVideoEntityMapper()

    /**
     * Provide Movie Detail Entity Mapper
     * @param movieKeywordEntityMapper
     * @param movieReviewEntityMapper
     * @param movieVideoEntityMapper
     */
    @Provides
    @PerFragment
    fun provideMovieDetailEntityMapper(
         movieKeywordEntityMapper: MovieKeywordEntityMapper,
         movieReviewEntityMapper: MovieReviewEntityMapper,
         movieVideoEntityMapper: MovieVideoEntityMapper
    ) = MovieDetailEntityMapper(
        movieKeywordEntityMapper, movieReviewEntityMapper,
        movieVideoEntityMapper
    )

    /**
     * Provide Movie Detail DAO
     * @param boxStore
     */
    @Provides
    @PerFragment
    fun provideMovieDetailDAO(boxStore: BoxStore): Box<MovieDetailEntity> =
        boxStore.boxFor(MovieDetailEntity::class.java)

    /**
     * Provide Movie DB Repository
     * @param movieDetailDAO
     * @param movieDetailEntityMapper
     */
    @Provides
    @PerFragment
    fun provideMovieDBRepository(
        movieDetailDAO: Box<MovieDetailEntity>,
        movieDetailEntityMapper: MovieDetailEntityMapper
    ): IMoviesDBRepository =
        MovieDBRepositoryImpl(movieDetailDAO, movieDetailEntityMapper)

}