package sanchez.sanchez.sergio.feature_movie_detail.di.module.movie

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_movie_detail.persistence.api.IMoviesRepository
import sanchez.sanchez.sergio.feature_movie_detail.persistence.api.MoviesRepositoryImpl
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.repository.IMoviesDBRepository
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository.IMoviesNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

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
            movieDBRepository: IMoviesDBRepository
    ): IMoviesRepository = MoviesRepositoryImpl(moviesNetworkRepository, movieDBRepository)
}