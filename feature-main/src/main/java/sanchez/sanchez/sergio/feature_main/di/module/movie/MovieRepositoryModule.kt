package sanchez.sanchez.sergio.feature_main.di.module.movie

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_main.di.module.core.MoviesNetworkModule
import sanchez.sanchez.sergio.feature_main.persistence.api.movies.DiscoverMoviesRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies.IDiscoverMoviesNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movie Repository Module
 */
@Module(includes = [ MoviesNetworkModule::class ])
class MovieRepositoryModule {

    @PerFragment
    @Provides
    fun provideDiscoverMoviesRepository(
            disNetworkRepository: IDiscoverMoviesNetworkRepository
    ) {
        DiscoverMoviesRepositoryImpl(disNetworkRepository)
    }

}