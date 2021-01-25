package sanchez.sanchez.sergio.feature_main.di.module.core

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sanchez.sanchez.sergio.feature_main.persistence.network.mapper.MovieNetworkMapper
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies.DiscoverMoviesNetworkRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies.IDiscoverMoviesNetworkRepository
import sanchez.sanchez.sergio.feature_main.persistence.network.service.DiscoverMoviesService
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movies Network Module
 */
@Module
class MoviesNetworkModule {

    /**
     * Provide Discover Movies Service
     * @param retrofit
     */
    @Provides
    @PerFragment
    fun provideDiscoverMoviesService(retrofit: Retrofit): DiscoverMoviesService =
            retrofit.create(DiscoverMoviesService::class.java)

    /**
     * Provide Discover Movies Network Mapper
     */
    @Provides
    @PerFragment
    fun privateDiscoverMoviesNetworkMapper(): MovieNetworkMapper = MovieNetworkMapper()


    /**
     * Provide Discover Movies Network Repository
     * @param discoverMoviesService
     * @param movieNetworkMapper
     *
     */
    @Provides
    @PerFragment
    fun provideDiscoverMoviesNetworkRepository(
            discoverMoviesService: DiscoverMoviesService,
            movieNetworkMapper: MovieNetworkMapper
    ): IDiscoverMoviesNetworkRepository = DiscoverMoviesNetworkRepositoryImpl(movieNetworkMapper, discoverMoviesService)

}