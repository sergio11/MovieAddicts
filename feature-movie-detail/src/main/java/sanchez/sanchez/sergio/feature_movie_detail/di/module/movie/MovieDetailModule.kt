package sanchez.sanchez.sergio.feature_movie_detail.di.module.movie

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_movie_detail.domain.usecase.GetMovieDetailInteract
import sanchez.sanchez.sergio.feature_movie_detail.persistence.api.IMoviesRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movie Detail Module
 */
@Module(includes = [ MovieDetailRepositoryModule::class ])
class MovieDetailModule {

    /**
     * Provide Get Movie Detail Interact
     * @param moviesRepository
     */
    @PerFragment
    @Provides
    fun provideGetMovieDetailInteract(
        moviesRepository: IMoviesRepository
    ) = GetMovieDetailInteract(moviesRepository)

}