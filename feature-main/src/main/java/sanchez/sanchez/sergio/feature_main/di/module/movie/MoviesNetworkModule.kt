package sanchez.sanchez.sergio.feature_main.di.module.movie

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sanchez.sanchez.sergio.feature_main.persistence.network.mapper.MovieNetworkMapper
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies.DiscoverMoviesNetworkRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies.IDiscoverMoviesNetworkRepository
import sanchez.sanchez.sergio.feature_main.persistence.network.service.DiscoverMoviesService
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.service.IMovieFavoriteService

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
     * @param movieFavoriteService
     *
     */
    @Provides
    @PerFragment
    fun provideDiscoverMoviesNetworkRepository(
            discoverMoviesService: DiscoverMoviesService,
            movieNetworkMapper: MovieNetworkMapper,
            movieFavoriteService: IMovieFavoriteService
    ): IDiscoverMoviesNetworkRepository =
        DiscoverMoviesNetworkRepositoryImpl(movieNetworkMapper, discoverMoviesService, movieFavoriteService)

}