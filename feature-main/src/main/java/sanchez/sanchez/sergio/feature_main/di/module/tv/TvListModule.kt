package sanchez.sanchez.sergio.feature_main.di.module.tv

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_main.domain.usecase.DiscoverTvsInteract
import sanchez.sanchez.sergio.feature_main.persistence.api.tv.IDiscoverTvRepository
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment

@Module(includes = [ TvRepositoryModule::class ])
class TvListModule {

    /**
     * Provide Discover Tvs Interact
     * @param discoverTvRepository
     */
    @PerFragment
    @Provides
    fun provideDiscoverTvsInteract(
        discoverTvRepository: IDiscoverTvRepository
    ) = DiscoverTvsInteract(discoverTvRepository)
}