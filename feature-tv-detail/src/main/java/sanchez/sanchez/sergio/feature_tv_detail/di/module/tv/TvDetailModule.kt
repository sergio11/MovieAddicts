package sanchez.sanchez.sergio.feature_tv_detail.di.module.tv

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_tv_detail.domain.usecase.GetTvDetailInteract
import sanchez.sanchez.sergio.feature_tv_detail.persistence.api.ITvRepository
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment

/**
 * Tv Detail Module
 */
@Module(includes = [ TvDetailRepositoryModule::class ])
class TvDetailModule {

    /**
     * Provide Get Tv Detail Interact
     * @param tvRepository
     */
    @PerFragment
    @Provides
    fun provideGetTvDetailInteract(tvRepository: ITvRepository)
            = GetTvDetailInteract(tvRepository)

}