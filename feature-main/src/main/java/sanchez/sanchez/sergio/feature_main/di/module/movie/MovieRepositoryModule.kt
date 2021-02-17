package sanchez.sanchez.sergio.feature_main.di.module.movie

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_main.persistence.api.movies.DiscoverMoviesRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.api.movies.IDiscoverMoviesRepository
import sanchez.sanchez.sergio.feature_main.persistence.db.repository.movies.IDiscoverMoviesDBRepository
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies.IDiscoverMoviesNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movie Repository Module
 */
@Module(includes = [ MoviesNetworkModule::class, MovieDatabaseModule::class ])
class MovieRepositoryModule {

    /**
     * Provide Discover Movies Repository
     * @param disNetworkRepository
     * @param moviesDBRepository
     */
    @PerFragment
    @Provides
    fun provideDiscoverMoviesRepository(
            disNetworkRepository: IDiscoverMoviesNetworkRepository,
            moviesDBRepository: IDiscoverMoviesDBRepository
    ): IDiscoverMoviesRepository = DiscoverMoviesRepositoryImpl(disNetworkRepository, moviesDBRepository)

}