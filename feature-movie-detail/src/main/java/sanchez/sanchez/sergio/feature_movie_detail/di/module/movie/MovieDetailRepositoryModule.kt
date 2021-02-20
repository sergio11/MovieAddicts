package sanchez.sanchez.sergio.feature_movie_detail.di.module.movie

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.persistence.api.IMoviesRepository
import sanchez.sanchez.sergio.feature_movie_detail.persistence.api.MoviesRepositoryImpl
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository.IMoviesNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment
import sanchez.sanchez.sergio.test.core.persistence.db.repository.IDBRepository

/**
 * Movie Detail Repository Module
 */
@Module(includes = [ MovieDetailNetworkModule::class, MovieDetailDatabaseModule::class ])
class MovieDetailRepositoryModule {

    /**
     * Provide Movies Repository
     * @param moviesNetworkRepository
     * @param movieDBRepository
     */
    @PerFragment
    @Provides
    fun provideMoviesRepository(
            moviesNetworkRepository: IMoviesNetworkRepository,
            movieDBRepository: IDBRepository<MovieDetail>
    ): IMoviesRepository = MoviesRepositoryImpl(moviesNetworkRepository, movieDBRepository)
}