package sanchez.sanchez.sergio.feature_movie_detail.di.module.movie

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_movie_detail.persistence.api.IMoviesRepository
import sanchez.sanchez.sergio.feature_movie_detail.persistence.api.MoviesRepositoryImpl
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository.IMoviesNetworkRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movie Detail Repository Module
 */
@Module(includes = [ MovieDetailNetworkModule::class ])
class MovieDetailRepositoryModule {

    /**
     * Provide Movies Repository
     * @param moviesNetworkRepository
     */
    @PerFragment
    @Provides
    fun provideMoviesRepository(
            moviesNetworkRepository: IMoviesNetworkRepository
    ): IMoviesRepository = MoviesRepositoryImpl(moviesNetworkRepository)
}