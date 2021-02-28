package sanchez.sanchez.sergio.feature_main.di.module.movie

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.MovieEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.movies.MovieEntity
import sanchez.sanchez.sergio.feature_main.persistence.db.model.movies.MovieEntity_
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.objectbox.ObjectBoxRepositoryConfiguration
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.objectbox.SupportObjectBoxRepositoryImpl

/**
 * Movie Database Module
 */
@Module
class MovieDatabaseModule {

    /**
     * Provide Movie Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideMovieEntityMapper(): IEntityToModelMapper<MovieEntity, Movie> = MovieEntityMapper()

    /**
     * Provide Movie DAO
     * @param boxStore
     */
    @Provides
    @PerFragment
    fun provideMovieDAO(boxStore: BoxStore): Box<MovieEntity> =
            boxStore.boxFor(MovieEntity::class.java)


    /**
     * Provide Object Box Configuration
     */
    @Provides
    @PerFragment
    fun provideObjectBoxConfiguration(): ObjectBoxRepositoryConfiguration<MovieEntity>
            = ObjectBoxRepositoryConfiguration(
            maxObjectsAllowed = MAX_OBJECTS_ALLOWED,
            objectsExpireInMillis = OBJECTS_EXPIRE_IN_MILLIS,
            objectIdProperty = MovieEntity_.id,
            savedAtInMillisProperty = MovieEntity_.savedAtInMillis)

    /**
     * Provide Movie DB Repository
     * @param movieDAO
     * @param movieEntityMapper
     */
    @Provides
    @PerFragment
    fun provideMovieDBRepository(
        movieDAO: Box<MovieEntity>,
        movieEntityMapper: IEntityToModelMapper<MovieEntity, Movie>,
        objectBoxRepositoryConfiguration: ObjectBoxRepositoryConfiguration<MovieEntity>
    ): IDBRepository<Movie> =
        SupportObjectBoxRepositoryImpl(movieDAO, movieEntityMapper, objectBoxRepositoryConfiguration)


    companion object {
        private const val MAX_OBJECTS_ALLOWED = 20
        private const val OBJECTS_EXPIRE_IN_MILLIS = 86400000 // 24 hours
    }
}