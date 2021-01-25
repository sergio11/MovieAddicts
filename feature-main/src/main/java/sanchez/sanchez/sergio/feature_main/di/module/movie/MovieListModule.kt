package sanchez.sanchez.sergio.feature_main.di.module.movie

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_main.domain.usecase.DiscoverMoviesInteract
import sanchez.sanchez.sergio.feature_main.persistence.api.IDiscoverMoviesRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movie List Module
 */
@Module(includes = [ MovieRepositoryModule::class ])
class MovieListModule {

    /**
     * Provide Discover Movies Interact
     * @param discoverMoviesRepository
     */
    @PerFragment
    @Provides
    fun provideDiscoverMoviesInteract(
        discoverMoviesRepository: IDiscoverMoviesRepository
    ) = DiscoverMoviesInteract(discoverMoviesRepository)

}