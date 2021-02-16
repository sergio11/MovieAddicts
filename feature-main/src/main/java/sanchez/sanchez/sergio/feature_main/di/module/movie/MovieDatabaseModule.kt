package sanchez.sanchez.sergio.feature_main.di.module.movie

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_main.di.module.core.DatabaseModule
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.MovieEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.movies.MovieEntity
import sanchez.sanchez.sergio.feature_main.persistence.db.repository.movies.DiscoverMoviesDBRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.db.repository.movies.IDiscoverMoviesDBRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movie Database Module
 */
@Module(includes = [ DatabaseModule::class ])
class MovieDatabaseModule {

    /**
     * Provide Movie Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideMovieEntityMapper() = MovieEntityMapper()

    /**
     * Provide Movie DAO
     * @param boxStore
     */
    @Provides
    @PerFragment
    fun provideMovieDAO(boxStore: BoxStore): Box<MovieEntity> =
        boxStore.boxFor(MovieEntity::class.java)

    /**
     * Provide Movie DB Repository
     * @param movieDAO
     * @param movieEntityMapper
     */
    @Provides
    @PerFragment
    fun provideMovieDBRepository(
        movieDAO: Box<MovieEntity>,
        movieEntityMapper: MovieEntityMapper
    ): IDiscoverMoviesDBRepository =
        DiscoverMoviesDBRepositoryImpl(movieDAO, movieEntityMapper)

}